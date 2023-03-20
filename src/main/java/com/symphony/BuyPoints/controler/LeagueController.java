package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.LeagueDTO;
import com.symphony.BuyPoints.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/leagues")
public class LeagueController {

    private final LeagueService leagueService;

    @GetMapping
    public ResponseEntity<List<LeagueDTO>> getLeague(@RequestParam(required = false) String name,
                                                     @RequestParam(required = false) String countryName,
                                                     @RequestParam int sportId) {

        return ResponseEntity.ok(leagueService.search(name, countryName, sportId));
    }

}
