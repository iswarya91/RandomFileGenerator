package com.iswarya;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of line to be created in the file");
        long n = scanner.nextLong();

        scanner.nextLine();
        System.out.println("Enter the full path of file be created");
        String file = scanner.nextLine();
        FileGenerator fileGenerator = new FileGenerator(file);
        try {
            fileGenerator.generateFile(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
