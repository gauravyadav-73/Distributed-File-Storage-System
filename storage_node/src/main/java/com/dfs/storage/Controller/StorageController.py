package com.dfs.storage.controller;

import com.dfs.storage.service.NioStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/storage")
public class StorageController {

  private final NioStorageService storageService;

  public StorageController(NioStorageService storageService) {
    this.storageService = storageService;
   }

  @PostMapping("/chunks/{chunkName}")
  public ResponseEntity<String> uploadChunk(@PathVariable String chunkName, @RequestBody byte[] data) {
    try {
        storageService.saveChunk(chunkName, data);
        return ResponseEntity.ok("Chunk saved successfully: " + chunkName);
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Failed to save chunk: " + e.getMessage());
    }
  }

  @GetMapping("/chunks/{chunkName}")
  public ResponseEntity<byte[]> getChunk(@PathVariable String chunkName) {   

