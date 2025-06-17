package site.currychoco.assetmanager.sync.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.currychoco.assetmanager.sync.service.SynchronizeService;

@RestController
@RequiredArgsConstructor
public class SyncController {

    private final SynchronizeService synchronizeService;

    @GetMapping("/sync/hr")
    public ResponseEntity<Void> syncHr() {
        synchronizeService.synchronizeHR();
        return ResponseEntity.ok(null);
    }

}
