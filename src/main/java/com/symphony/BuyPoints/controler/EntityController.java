package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.EntityInputDto;
import com.symphony.BuyPoints.dto.EntityOutputDTO;
import com.symphony.BuyPoints.dto.TableOutputDTO;
import com.symphony.BuyPoints.service.ManagementEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/entity")
public class EntityController {

    private final ManagementEntityService entityService;

    @GetMapping
    public ResponseEntity<TableOutputDTO> getEntity(@RequestParam(required = true) long sportId, @RequestParam(required = true) long storeId,
                                                    @RequestParam(required = true) long lineTypeId, @RequestParam(required = true) long periodId) {
        return ResponseEntity.ok(entityService.getEntities(sportId, storeId, periodId, lineTypeId));
    }

    @PostMapping
    public ResponseEntity saveEntityChart(@RequestBody List<EntityInputDto> entityInputDto) {
        return ResponseEntity.ok(entityService.createEntity(entityInputDto));
    }

    @GetMapping("/search")
    public ResponseEntity<PageImpl<EntityOutputDTO>> searchLeague(@RequestParam long sportId,
                                                                  @RequestParam long storeId,
                                                                  @RequestParam long lineTypeId,
                                                                  @RequestParam long periodId,
                                                                  @RequestParam(required = false) String displayName,
                                                                  @RequestParam(required = false) String organizationName,
                                                                  Pageable pageable) {
        return ResponseEntity.ok(entityService.searchLeague(sportId, storeId,
                lineTypeId, periodId, displayName, organizationName, pageable));
    }

    @CacheEvict(value = "entities", allEntries = true)
    @GetMapping("/evict-cache")
    public ResponseEntity<TableOutputDTO> evictCache() {
        return ResponseEntity.ok(null);
    }

}
