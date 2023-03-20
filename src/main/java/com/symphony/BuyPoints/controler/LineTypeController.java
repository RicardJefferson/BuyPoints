package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.model.LineType;
import com.symphony.BuyPoints.service.LineTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/line-types")
public class LineTypeController {

    private final LineTypeService lineTypeService;

    @GetMapping
    public ResponseEntity<List<LineType>> getChartById() {
        return ResponseEntity.ok(lineTypeService.getAll());
    }
}
