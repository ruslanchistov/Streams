package testingSocet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SimpleClient {
    public static void main(String[] args) {
        try {
//            Открываем сокет для доступа к компьютеру
//            по адресу java-course.ru", 80
            Socket s = new Socket("java-course.ru", 80);

//            Открываем поток для чтения из сокета
//            (информация будет поступать с удалённого компьютера)
            InputStream in = s.getInputStream();

//            Открываем поток для записи в сокет
//            (информация будет поступать с нашего компьютера)
            OutputStream out = s.getOutputStream();

//            Готовим строку с данными для обращения к серверу
            String str = "GET /network.txt HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";

//            Превращаем их в массив байт для передачи
            byte[] buffer = str.getBytes();

//            Записываем его в поток
            out.write(buffer);

//            Читаем данные
            byte[] buffer_out = new byte[1024];
            int size;
            while ((size = in.read(buffer_out)) != -1) {
                System.out.println(new String(buffer_out, 0, size));
            }
            s.close();
        } catch (IOException e) {
            System.out.println("bad");
        }
    }
}
