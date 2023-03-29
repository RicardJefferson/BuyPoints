package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.EntityInputDto;
import com.symphony.BuyPoints.dto.MatchDTO;
import com.symphony.BuyPoints.dto.MatchOutputDTO;
import com.symphony.BuyPoints.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public ResponseEntity<MatchOutputDTO> getMatches(@RequestParam(required = true) int matchId,
                                                     @RequestParam(required = true) int sportId,
                                                     @RequestParam(required = true) int storeId,
                                                     @RequestParam(required = true) int lineTypeId,
                                                     @RequestParam(required = true) int periodId) {
        return ResponseEntity.ok(matchService.getMatch(matchId, sportId,
                storeId, periodId, lineTypeId));
    }

    @PostMapping
    public ResponseEntity saveEntityChart(@RequestBody MatchOutputDTO matchOutputDTO) {
        return ResponseEntity.ok(matchService.createMatch(matchOutputDTO));
    }
}
