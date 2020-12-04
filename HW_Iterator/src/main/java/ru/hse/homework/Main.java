package ru.hse.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String path = "./src/main/resources/testIterator";
        for (FileIterator it = new FileIterator(path); it.hasNext(); ) {
            if (getUserWish(sc)) {
                String line = it.next();
                System.out.println(line);
            }

        }
    }
    /**
     * Получить введенную строку пользователем
     *
     * @param sc Сканнер
     * @return true-пользоваиель захотел итерироваться по файлу, false в обратном случае.
     */
    static boolean getUserWish(Scanner sc) {
        System.out.println("Для итерации по файлу нажмите Enter");
        String str = sc.nextLine();
        return str.equals("");
    }
}
