package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.PeriodDTO;
import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.service.PeriodService;
import com.symphony.BuyPoints.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/periods")
public class PeriodsController {

    private final PeriodService periodService;
    private final SportService sportService;

    @GetMapping
    public ResponseEntity<List<PeriodDTO>> getPeriods() {
        return ResponseEntity.ok(periodService.getPeriods());
    }

    @PutMapping
    public ResponseEntity<List<SportDTO>> updateSportPeriods(@RequestBody SportDTO sportDTO) {
        return ResponseEntity.ok(sportService.updateSportPeriods(sportDTO));
    }

}
