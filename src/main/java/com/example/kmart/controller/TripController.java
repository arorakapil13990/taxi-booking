package com.example.kmart.controller;

import com.example.kmart.constants.Constants;
import com.example.kmart.dto.CancellationRateResponse;
import com.example.kmart.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiOperation(value = "tripController",
        notes = "Operations pertaining to trips",
        response = CancellationRateResponse.class,
        responseContainer = "List",
        produces = "application/json")
public class TripController {

    @ApiModelProperty(notes = "Name of the Service Class", name = "service")
    private final UserService service;

    public TripController(UserService service) {
        this.service = service;
    }


    @ApiOperation(value = "Return list of Cancellation Rates for the give range of dates ", response = Iterable.class, tags = "cancellationRate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/cancellationRate")
    public List<CancellationRateResponse> getCancellationRate(@RequestParam(value = Constants.START) String start,
                                                              @RequestParam(value = Constants.END) String end) {
        return service.getCancellationRate(start, end);
    }
}

