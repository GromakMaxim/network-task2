package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a server!
 */
public class ServerApp {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String line;

        while(true) {
            line = in.readLine(); // ожидаем пока клиент пришлет строку текста.
            System.out.println("Глупый клиент только что прислал мне это : " + line);
            System.out.println("Отправляю обратно...");
            out.println(line); // отсылаем клиенту обратно ту самую строку текста.
            System.out.println("Ожидаю следующего сообщения...");
            System.out.println();
        }
    }
}
