package ru.hse.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "./src/main/resources/testIterator";
        for (FileIterator it = new FileIterator(path); it.hasNext(); ) {
            if (it.getUserWish(sc)) {
                String line = it.next();
                System.out.println(line);
            }
        }
    }
}
