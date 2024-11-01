package com.manage.carrivepassenger.service.impl;

import com.manage.carrive.entity.Itinerary;
import com.manage.carrive.enumeration.CodeResponseEnum;
import com.manage.carrive.response.PassengerResponse;
import com.manage.carrivepassenger.service.api.CarrivePassengerApi;
import com.manage.carriveutility.repository.ItineraryRepository;
import com.manage.carriveutility.repository.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrivePassengerImpl implements CarrivePassengerApi {

    private final Logger logger = LoggerFactory.getLogger(CarrivePassengerImpl.class);

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Override
    public ResponseEntity<PassengerResponse> listAllRides() {
        PassengerResponse passengerResponse = new PassengerResponse();
        try {

            List<Itinerary> itineraries = itineraryRepository.findAll();
            if (itineraries.isEmpty()) {
                passengerResponse.setCode(CodeResponseEnum.CODE_NULL.getCode());
                passengerResponse.setData(null);
                passengerResponse.setMessage("list is empty");
            }else {
                passengerResponse.setCode(CodeResponseEnum.CODE_SUCCESS.getCode());
                passengerResponse.setData(itineraries);
                passengerResponse.setMessage("list is ok");
            }
            return new ResponseEntity<>(passengerResponse, HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.getMessage());
            passengerResponse.setCode(CodeResponseEnum.CODE_ERROR.getCode());
            passengerResponse.setMessage(e.getMessage());
            passengerResponse.setData(null);
            return new ResponseEntity<>(passengerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}