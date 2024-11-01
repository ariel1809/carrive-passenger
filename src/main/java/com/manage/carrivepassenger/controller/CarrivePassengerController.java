package com.manage.carrivepassenger.controller;

import com.manage.carrive.response.PassengerResponse;
import com.manage.carrivepassenger.service.impl.CarrivePassengerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passenger")
public class CarrivePassengerController {

    @Autowired
    private CarrivePassengerImpl service;

    @PostMapping("list-rides")
    public ResponseEntity<PassengerResponse> listAllRides() {
        return service.listAllRides();
    }
}
