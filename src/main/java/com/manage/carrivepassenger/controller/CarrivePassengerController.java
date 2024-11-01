package com.manage.carrivepassenger.controller;

import com.manage.carrive.dto.MessageDto;
import com.manage.carrive.response.MessageResponse;
import com.manage.carrive.response.PassengerResponse;
import com.manage.carrivepassenger.feignclient.MessageFeignClient;
import com.manage.carrivepassenger.service.impl.CarrivePassengerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("passenger")
public class CarrivePassengerController {

    @Autowired
    private CarrivePassengerImpl service;

    @Autowired
    private MessageFeignClient messageFeignClient;

    @PostMapping("init-conversation")
    public ResponseEntity<MessageResponse> initConversation(@RequestParam("id_receiver") String idReceiver) {
        return messageFeignClient.initConversation(idReceiver);
    }

    @PostMapping("list-conversations")
    public ResponseEntity<MessageResponse> listConversations() {
        return messageFeignClient.listConversationsByUser();
    }

    @PostMapping("send-message")
    ResponseEntity<MessageResponse> sendMessage(@RequestParam("id_conversation") String idConversation, @RequestBody MessageDto message){
        return messageFeignClient.sendMessage(idConversation, message);
    }

    @PostMapping("list-rides")
    public ResponseEntity<PassengerResponse> listAllRides() {
        return service.listAllRides();
    }

    @PostMapping("logout")
    public ResponseEntity<PassengerResponse> logout() {
        return service.logout();
    }
}
