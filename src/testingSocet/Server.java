package testingSocet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
//            определяем номер порта локального компьютера
//            который будет слушать сервер
        int num_port = 1777;
        try {
//            Открываем серверный сокет
            ServerSocket serv_socket = new ServerSocket(num_port);
            String waiting;
            Scanner sc = new Scanner(System.in);


//            Входим в бесконечный цикл ожидания соединения
            do {
                System.out.println("Ждать соединения? :y/n");
                waiting = sc.next();
                if (!waiting.equals("y")) {
                    break;
                } else {
                    System.out.println("waiting for connection on port " + num_port);

//                Получив соединение работаем с сокетом
                    Socket client_server = serv_socket.accept();

//                Работаем с потоками ввода-вывода
                    try {
                        PrintWriter pw = new PrintWriter(client_server.getOutputStream(), true);
                        InputStream in = client_server.getInputStream();
                        InputStreamReader isr = new InputStreamReader(in);
                        BufferedReader br = new BufferedReader(isr);

//                    Читаем сообщения от клиента, пока он не скажет "bye"
                        String str;
                        while ((str = br.readLine()) != null) {
                            System.out.println("message: " + str);
//                        Если клиент отправил "bye" ,тоже отправляем "bye" и выходим из цикла
                            if (str.equals("bye")) {
                                pw.println("bye");
                                break;
                            } else {
//                            Посылаем клиенту ответ
                                pw.println("Server returns: " + str);
                            }
                        }
                        br.close();
                        pw.close();
                    } catch (IOException e) {
                        System.out.println("bad");
                    }
                }
            }
            while (true);
        } catch (IOException e) {
            System.out.println("bad");
        }
    }
}
