package com.iswarya;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileGeneratorTest {
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void generateFile() throws IOException {
        final File tempFile = folder.newFile("tempFile.txt");
        FileGenerator fileGenerator = new FileGenerator(tempFile.getAbsolutePath());
        fileGenerator.generateFile(5);
        assertEquals(5 * 101, tempFile.length());// 100 character per line + new line char
    }
}