package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.EntityInputDto;
import com.symphony.BuyPoints.dto.TableOutputDTO;
import com.symphony.BuyPoints.service.ManagementEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/entity")
public class EntityController {

    private final ManagementEntityService entityService;

    @GetMapping
    public ResponseEntity<TableOutputDTO> getEntity(@RequestParam(required = true) int sportId, @RequestParam(required = true) int storeId,
                                                    @RequestParam(required = true) int lineTypeId, @RequestParam(required = true) int periodId) {
        return ResponseEntity.ok(entityService.getEntities(sportId, storeId, periodId, lineTypeId));
    }

    @PostMapping
    public ResponseEntity saveEntityChart(@RequestBody List<EntityInputDto> entityInputDto) {
        return ResponseEntity.ok(entityService.createEntity(entityInputDto));
    }
    
}
