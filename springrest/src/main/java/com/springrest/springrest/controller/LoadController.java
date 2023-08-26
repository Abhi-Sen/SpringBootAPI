package com.springrest.springrest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Load;
import com.springrest.springrest.services.LoadService;
 

@RestController
public class LoadController {
    @Autowired
    private LoadService loadService;

    @PostMapping("/load")
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        loadService.addLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping("/load")
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);
        return ResponseEntity.ok(loads);
    }

    @GetMapping("/load/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        return load.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/load/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable Long loadId, @RequestBody Load updatedLoad) {
        loadService.updateLoad(loadId, updatedLoad);
        return ResponseEntity.ok("Load updated successfully");
    }

    @DeleteMapping("/load/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}
