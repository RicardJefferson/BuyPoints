package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.service.MenagmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menagment")
public class MenagmentController {

    private final MenagmentService menagmentService;

    @GetMapping
    public ResponseEntity<DefaultStoreSportChartDTO> getActiveCharts(@RequestParam int sportId, @RequestParam int storeId,
                                                                     @RequestParam int lineTypeId, @RequestParam int periodId) {
        return ResponseEntity.ok(menagmentService.getDefaultChart(sportId, storeId, lineTypeId, periodId));
    }

    @PostMapping
    public ResponseEntity createNewChart(@RequestBody DefaultStoreSportChartDTO defaultStoreSportChartDTO) {
        return ResponseEntity.ok(menagmentService.create(defaultStoreSportChartDTO));
    }
}
