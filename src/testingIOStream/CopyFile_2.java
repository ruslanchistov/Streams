package testingIOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile_2 {
    public static void main(String[] args) {
        try {
            String file_source = "C:/Testing/src/2.png";
            String file_receiver = "C:/Testing/src/2_2.png";

//        Открываем поток на чтение из файла и запись в файл
            FileInputStream in = new FileInputStream(file_source);
            FileOutputStream out = new FileOutputStream(file_receiver);

//            Создаём буфер для обмена данными
            byte[] buffer = new byte[16384];

            int size;
            while ((size = in.read(buffer)) > 0) {
                out.write(buffer, 0, size);
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            System.out.println("bad");
        }
    }
}
