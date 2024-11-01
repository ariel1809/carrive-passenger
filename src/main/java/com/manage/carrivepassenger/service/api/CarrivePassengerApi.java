package com.manage.carrivepassenger.service.api;

import com.manage.carrive.response.PassengerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CarrivePassengerApi {
    ResponseEntity<PassengerResponse> listAllRides();
}
