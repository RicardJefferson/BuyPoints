package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.ChartDTO;
import com.symphony.BuyPoints.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/charts")
public class ChartController {

    private final ChartService chartService;

    @GetMapping("/{id}")
    public ResponseEntity<ChartDTO> getChartById(@PathVariable(value = "id", required = true) Integer id) {
        return ResponseEntity.ok(chartService.getChart(id));
    }

    @GetMapping
    public ResponseEntity<List<ChartDTO>> getActiveCharts() {
        return ResponseEntity.ok(chartService.getAllActiveCharts());
    }

    @PostMapping
    public ResponseEntity createNewChart(@RequestBody ChartDTO chartDTO) {
        return ResponseEntity.ok(chartService.createChart(chartDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity editChart(@RequestBody ChartDTO chartDTO, @PathVariable Integer id) {

        return ResponseEntity.ok(chartService.updateChart(chartDTO, id));
    }


}
