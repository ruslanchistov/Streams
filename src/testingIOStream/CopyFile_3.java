package testingIOStream;

import java.io.*;
import java.nio.charset.Charset;

public class CopyFile_3 {
    public static void main(String[] args) {
        try {
            String file_source = "C:/Testing/src/1.txt";
            String file_receiver = "C:/Testing/src/4_4.txt";
//            Создаём байтовый поток
            FileInputStream fis = new FileInputStream(file_source);
//            Передаём отот поток в поток символов
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Windows-1251"));
//            Готовый поток символов делим на строки
            BufferedReader br = new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream(file_receiver);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            String line;
            while ((line = br.readLine())!= null){
                bw.write(line);
                System.out.println(line);
            }
            br.close();
            bw.close();
        } catch (IOException ex) {
            System.out.println("bad");
        }
    }
}
