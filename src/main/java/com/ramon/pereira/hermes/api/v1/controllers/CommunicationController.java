package com.ramon.pereira.hermes.api.v1.controllers;

import com.ramon.pereira.hermes.api.v1.dtos.request.CommunicationCreateRequestDto;
import com.ramon.pereira.hermes.api.v1.dtos.response.CommunicationResponseDto;
import com.ramon.pereira.hermes.api.v1.mapper.CommunicationMapper;
import com.ramon.pereira.hermes.business.CommunicationBusiness;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/hermes/v1/communication")
@Api(value = "Communication Api", tags = {"Communication"})
public class CommunicationController {

    @Autowired
    private CommunicationBusiness communicationBusiness;

    @Autowired
    private CommunicationMapper communicationMapper;

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Create Communication", response = CommunicationResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<CommunicationResponseDto>> create(@RequestBody @Valid final CommunicationCreateRequestDto communicationCreateRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(communicationMapper.serializeToResponseDto(communicationBusiness
                        .create(communicationMapper.serializeRequestCreateToModel(Optional.of(communicationCreateRequestDto)).get())));
    }

    @DeleteMapping("{id}")
    @ResponseBody
    @ApiOperation(value = "Remove Communication", response = CommunicationResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<CommunicationResponseDto>> remove(@PathVariable  @Valid final Integer id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(communicationMapper.serializeToResponseDto(communicationBusiness
                        .remove(id)));
    }

}
