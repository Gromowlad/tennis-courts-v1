package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api("Entry Point")
@AllArgsConstructor
@RestController
@RequestMapping("/tennis-court")
public class TennisCourtController extends BaseRestController {

    private final TennisCourtService tennisCourtService;

    @PostMapping(value = "/add")
    @ApiOperation(value="Add Tennis Court")
    @ApiResponse(code = 201, message = "Tennis Court created")
    public ResponseEntity<Void> addTennisCourt(@Valid TennisCourtDTO tennisCourtDTO) {
        return ResponseEntity.created(locationByEntity(tennisCourtService.addTennisCourt(tennisCourtDTO).getId())).build();
    }

    @GetMapping(value = "/find", params = "tennisCourtId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Find Tennis Court by ID")
    @ApiResponse(code = 200, message = "Tennis Court found")
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtById(tennisCourtId));
    }

    @GetMapping(value = "/find-with-schedule", params = "tennisCourtId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Find with schedule")
    @ApiResponse(code = 200, message = "Tennis Court with schedule found")
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtId));
    }
}
