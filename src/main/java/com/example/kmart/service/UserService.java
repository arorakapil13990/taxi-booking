package com.example.kmart.service;

import com.example.kmart.constants.Constants;
import com.example.kmart.dto.CancellationRateResponse;
import com.example.kmart.entity.TripDetail;
import com.example.kmart.entity.UserDetail;
import com.example.kmart.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.example.kmart.constants.Constants.DECIMAL_FORMAT;
import static com.example.kmart.enums.Role.CLIENT;
import static com.example.kmart.enums.Status.CANCELLED_BY_CLIENT;
import static com.example.kmart.enums.Status.CANCELLED_BY_DRIVER;

@Service
public class UserService {

    private final UtilService utilService;
    private final UserDetailRepository userRepo;

    @Autowired
    public UserService(UserDetailRepository userRepo, UtilService utilService) {
        this.userRepo = userRepo;
        this.utilService = utilService;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public List<CancellationRateResponse> getCancellationRate(String start, String end) {

        List<UserDetail> userDetails = userRepo.getUserDetailByRoleAndTripDetail_RequestAtBetweenAndBanned(
                CLIENT, utilService.parseDate(start), utilService.parseDate(end), Constants.NOT_BANNED).stream().filter(distinctByKey(user -> user.getUserId())).collect(Collectors.toList());
        List<TripDetail> tripDetails = userDetails.stream().flatMap(e -> e.getTripDetail().stream()).collect(Collectors.toList());
        Map<Date, Set<Long>> validTrips = getValidTrips(tripDetails);
        Map<Date, Long> validCancellation = getValidCancellation(tripDetails);
        return createResponse(validCancellation, validTrips, tripDetails);
    }

    public Map<Date, Long> getValidCancellation(List<TripDetail> tripDetails) {
        return tripDetails.stream().filter(((Predicate<TripDetail>) e -> e.getStatus() == CANCELLED_BY_CLIENT)
                .or(e1 -> e1.getStatus() == CANCELLED_BY_DRIVER)).collect(Collectors.groupingBy(TripDetail::getRequestAt, Collectors.counting()));

    }

    private Map<Date, Set<Long>> getValidTrips(List<TripDetail> tripDetails) {
        return tripDetails.stream().collect(Collectors.groupingBy(TripDetail::getRequestAt, Collectors.mapping(TripDetail::getClientId, Collectors.toSet())));
    }

    private List<CancellationRateResponse> createResponse(Map<Date, Long> validCancellation, Map<Date, Set<Long>> validTrips, List<TripDetail> tripDetails) {
        return tripDetails.stream().filter(distinctByKey(trip -> trip.getRequestAt()))
                .collect(Collectors.toList()).stream().map(date -> new CancellationRateResponse(utilService.formatDate(date.getRequestAt()),
                        validCancellation.get(date.getRequestAt()) != null
                                ? DECIMAL_FORMAT.format((double) validCancellation.get(date.getRequestAt()) / validTrips.get(date.getRequestAt()).size())
                                : Constants.ZERO)).sorted(Comparator.comparing(CancellationRateResponse::getDay)).collect(Collectors.toList());

    }


}
