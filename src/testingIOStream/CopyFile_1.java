package testingIOStream;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile_1 {
    public static void main(String[] args){
        try{
        String file_source = "C:/Testing/src/1.txt";
        String file_receiver = "C:/Testing/src/1_1.txt";

//        Открываем поток на чтение из файла и запись в файл
        FileInputStream in = new FileInputStream(file_source);
            FileOutputStream out = new FileOutputStream(file_receiver);

//        Пока в потоке есть данные читаем их и сразу пишем
            while (in.available()>0){
                int data = in.read();
                out.write(data);
            }
            in.close();
            out.close();
        }
        catch (IOException e){
            System.out.println("bad");
        }
    }
}
