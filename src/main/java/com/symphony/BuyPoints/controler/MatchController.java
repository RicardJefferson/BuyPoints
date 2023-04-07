package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.MatchOutputDTO;
import com.symphony.BuyPoints.dto.MatchTableDTO;
import com.symphony.BuyPoints.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public ResponseEntity<MatchTableDTO> getMatches(
            @RequestParam long entityId,
            @RequestParam long matchId,
            @RequestParam long sportId,
            @RequestParam long storeId,
            @RequestParam long lineTypeId,
            @RequestParam long periodId) {

        return ResponseEntity.ok(matchService.getMatch(entityId, matchId, sportId,
                storeId, periodId, lineTypeId));
    }

    @PostMapping
    public ResponseEntity<MatchTableDTO> saveEntityChart(@RequestBody MatchOutputDTO matchOutputDTO) {
        return ResponseEntity.ok(matchService.createMatch(matchOutputDTO));
    }
}
