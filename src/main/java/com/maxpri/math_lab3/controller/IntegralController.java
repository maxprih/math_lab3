package com.maxpri.math_lab3.controller;

import com.maxpri.math_lab3.dto.IntegralRequest;
import com.maxpri.math_lab3.dto.IntegralResponse;
import com.maxpri.math_lab3.service.SolveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author max_pri
 */

@RestController
@RequestMapping("/api/integral")
@CrossOrigin(origins = "*")
public class IntegralController {

    private final SolveService solveService;

    public IntegralController(SolveService solveService) {
        this.solveService = solveService;
    }

    @PostMapping
    public ResponseEntity<IntegralResponse> solveIntegral(@RequestBody IntegralRequest integralRequest) {
        return new ResponseEntity<>(solveService.solve(integralRequest), HttpStatus.OK);
    }

}
