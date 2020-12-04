package ru.hse.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class FileIterator implements Iterator<String> {

    private final BufferedReader reader;
    private String line;

    FileIterator(String path) {
        try {
            reader = new BufferedReader(new FileReader(path));
            line = reader.readLine();
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }

    }

    /**
     * Проверка есть ли следующая строка в файле
     *
     * @return true-есть, false в обратном случае
     */
    @Override
    public boolean hasNext() {
        return line != null;
    }

    /**
     * Возвращаем следующую строку из файла
     *
     * @return Прочитанная строка
     */
    @Override
    public String next() {
        try {
            String resultLine = line;
            if (hasNext()) {
                line = reader.readLine();
                if (!hasNext()) {
                    reader.close();
                }
            }
            return resultLine;
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * Требовалось в стандартной реализации
     */
    @Override
    public void remove() {
    }

    /**
     * Получить введенную строку пользователем
     *
     * @param sc Сканнер
     * @return true-пользоваиель захотел итерироваться по файлу, false в обратном случае
     */
    public boolean getUserWish(Scanner sc) {
        System.out.println("Для итерации по файлу нажмите Enter");
        String str = sc.nextLine();
        return str.equals("");
    }

}
