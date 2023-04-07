package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sports")
public class SportController {

    private final SportService sportService;

    @GetMapping("/{id}")
    public ResponseEntity<SportDTO> getSportById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(sportService.getSport(id));
    }

    @GetMapping
    public ResponseEntity<List<SportDTO>> getAll() {
        return ResponseEntity.ok(sportService.getAllSports());
    }

}
