package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.ManagementOutputDTO;
import com.symphony.BuyPoints.dto.MatchDTO;
import com.symphony.BuyPoints.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public ResponseEntity<List<MatchDTO>>getMatches(@RequestParam(required = true) int matchId) {
        return ResponseEntity.ok(matchService.getMatchesByRotatingNumber(matchId));
    }
}
