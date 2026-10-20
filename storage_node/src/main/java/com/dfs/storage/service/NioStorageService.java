package com.dfs.storage.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

@Service
public class NioStorageService {
  private final Path storageDir = Paths.get("./data-chunks");

  public NioStorageService() throws IOException {
    Files.createDirectories(storageDir);
  }
