package com.iswarya;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileGenerator {
    private String file;
    private final int BUFFER_LINE_COUNT = 20000; // Rough Buffer size of 2 MB
    private final int CHAR_PER_LINE = 100;

    FileGenerator(String path) {
        File f = new File(path);
        if(f.canWrite()) {
            this.file = path;
        } else {
            System.out.println("Path is not valid. Hence creating rand.txt file in current directory");
            this.file = "rand.txt";
        }
    }

    public void generateFile(long n) throws IOException {
        String content;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for(long i = 0; i < n/BUFFER_LINE_COUNT; i++) {
                content = createFileContent(BUFFER_LINE_COUNT);
                bufferedWriter.write(content);
            }
            content = createFileContent(n % BUFFER_LINE_COUNT);
            bufferedWriter.write(content);
        }
    }


    private String createFileContent(long n) {
        RandomStringGenerator rand = new RandomStringGenerator();
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < n; i++) {
            sb.append(rand.generateRandomString(CHAR_PER_LINE));
            sb.append("\n");
        }
        return sb.toString();
    }

}
