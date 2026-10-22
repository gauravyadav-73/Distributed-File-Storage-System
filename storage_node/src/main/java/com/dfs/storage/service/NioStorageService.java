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

    public void saveChunk(String chunkName, byte[] data) throws IOException {
        Path filePath = storageDir.resolve(chunkName);
        try (FileChannel fileChannel = FileChannel.open(filePath,
            StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
