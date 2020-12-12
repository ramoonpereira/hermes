package com.ramon.pereira.hermes.api.v1.controllers;

import com.ramon.pereira.hermes.business.CommunicationBusiness;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hermes/v1/communication")
@Api(value = "Communication Api", tags = {"Communication"})
public class CommunicationController {

    @Autowired
    private CommunicationBusiness communicationBusiness;

}
