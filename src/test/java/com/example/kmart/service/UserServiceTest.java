package com.example.kmart.service;

import com.example.kmart.dto.CancellationRateResponse;
import com.example.kmart.entity.TripDetail;
import com.example.kmart.entity.UserDetail;
import com.example.kmart.enums.Role;
import com.example.kmart.enums.Status;
import com.example.kmart.repository.UserDetailRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private UtilService utilService;

    @Mock
    private UserDetailRepository repository;


    @Test
    public void testCancellationRateByDriverStatus() throws ParseException {

        ArrayList<TripDetail> tripDetail = new ArrayList<>();
        Date endDate = new Date();
        Date requestAt = new Date();
        tripDetail.add(new TripDetail(1l, 1l, 1l, 1l, Status.CANCELLED_BY_DRIVER, requestAt, null));
        UserDetail user = new UserDetail(1l, "No", Role.CLIENT, tripDetail);
        String requestDate = "2019-05-01";
        List<CancellationRateResponse> expectedCancellationRate = Collections.singletonList(new CancellationRateResponse(requestDate, "1.00"));
        when(utilService.parseDate(eq(requestDate))).thenReturn(endDate);
        when(utilService.formatDate(any())).thenReturn(requestDate);
        when(repository.getUserDetailByRoleAndTripDetail_RequestAtBetweenAndBanned(Role.CLIENT, endDate, endDate, "No"))
                .thenReturn(Arrays.asList(user));


        List<CancellationRateResponse> cancellationRates = service.getCancellationRate(requestDate, requestDate);

        Assert.assertEquals(expectedCancellationRate.size(), cancellationRates.size());
        Assert.assertEquals(expectedCancellationRate.get(0).getDay(), cancellationRates.get(0).getDay());
        Assert.assertEquals(expectedCancellationRate.get(0).getCancellationRate(), cancellationRates.get(0).getCancellationRate());
    }


    @Test
    public void testCancellationRateByClientStatus() throws ParseException {
        ArrayList<TripDetail> tripDetail = new ArrayList<>();
        Date endDate = new Date();
        Date requestAt = new Date();
        tripDetail.add(new TripDetail(1l, 1l, 1l, 1l, Status.CANCELLED_BY_CLIENT, requestAt, null));
        UserDetail user = new UserDetail(1l, "No", Role.CLIENT, tripDetail);
        String requestDate = "2019-05-01";
        List<CancellationRateResponse> expectedCancellationRate = Collections.singletonList(new CancellationRateResponse(requestDate, "1.00"));
        when(utilService.parseDate(eq(requestDate))).thenReturn(endDate);
        when(utilService.formatDate(any())).thenReturn(requestDate);
        when(repository.getUserDetailByRoleAndTripDetail_RequestAtBetweenAndBanned(Role.CLIENT, endDate, endDate, "No"))
                .thenReturn(Arrays.asList(user));

        List<CancellationRateResponse> cancellationRates = service.getCancellationRate(requestDate, requestDate);

        Assert.assertEquals(expectedCancellationRate.size(), cancellationRates.size());
        Assert.assertEquals(expectedCancellationRate.get(0).getDay(), cancellationRates.get(0).getDay());
        Assert.assertEquals(expectedCancellationRate.get(0).getCancellationRate(), cancellationRates.get(0).getCancellationRate());
    }

    @Test
    public void testCancellationRateByTripStatus() throws ParseException {
        ArrayList<TripDetail> tripDetail = new ArrayList<>();
        Date endDate = new Date();
        Date requestAt = new Date();
        tripDetail.add(new TripDetail(1l, 1l, 1l, 1l, Status.COMPLETED, requestAt, null));
        UserDetail user = new UserDetail(1l, "No", Role.CLIENT, tripDetail);
        String requestDate = "2019-05-01";
        List<CancellationRateResponse> expectedCancellationRate = Collections.singletonList(new CancellationRateResponse(requestDate, "0.00"));
        when(utilService.parseDate(eq(requestDate))).thenReturn(endDate);
        when(utilService.formatDate(any())).thenReturn(requestDate);
        when(repository.getUserDetailByRoleAndTripDetail_RequestAtBetweenAndBanned(Role.CLIENT, endDate, endDate, "No"))
                .thenReturn(Arrays.asList(user));

        List<CancellationRateResponse> cancellationRates = service.getCancellationRate(requestDate, requestDate);

        Assert.assertEquals(expectedCancellationRate.size(), cancellationRates.size());
        Assert.assertEquals(expectedCancellationRate.get(0).getDay(), cancellationRates.get(0).getDay());
        Assert.assertEquals(expectedCancellationRate.get(0).getCancellationRate(), cancellationRates.get(0).getCancellationRate());
    }

}
