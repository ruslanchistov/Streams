package testingSocet;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
//            определяем номер порта локального компьютера
//            на котором будет ожидать сервер
            int num_port = 1777;

//            Создаём строку для обращения к серверу
        String str = "Тестовая строка";

//          Открываем сокет
            Socket socket = new Socket("127.0.0.1",num_port);
            System.out.println("Client is started");

//            Открываем поток сокета
            InputStream in = socket .getInputStream();

//            Преобразуем в поток символов
            InputStreamReader isr = new InputStreamReader(in);

//            Превращаем в поток строк
            BufferedReader br =new BufferedReader(isr);

//            Создаём поток для записи строк в сокет
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

//            Отправляем строку в сокет
                pw.println(str);

//            Входим в цикл чтения ответа от сервера
                while ((str = br.readLine()) != null) {
//                Если пришёл ответ "bye"(сеанс окончен) выходим из цикла
                    if (str.equals("bye")) {
                        break;
                    }
                    System.out.println(str);
//                Отправляем ответ серверу для окончания сеанса связи
                    pw.println("bye");
                }
            br.close();
            pw.close();
            socket.close();
        }catch (IOException  e){
            System.out.println("bad");
        }
    }
}
