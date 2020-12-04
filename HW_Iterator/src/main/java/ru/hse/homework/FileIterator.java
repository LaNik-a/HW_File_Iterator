package ru.hse.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<String>,AutoCloseable {

    private final BufferedReader reader;
    private String line;
    FileIterator(String path){
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
            }
            return resultLine;
        } catch (IOException ex) {
            return "Ошибка при итерации";
        }
        finally {
            if(!hasNext())
            {
                try {
                    close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Закрытие итератора
     * @throws IOException возможное исключение
     */
    @Override
    public void close() throws IOException {
        reader.close();
    }
}
