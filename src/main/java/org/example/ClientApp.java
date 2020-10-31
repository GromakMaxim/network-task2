package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This is a client!
 */
public class ClientApp {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8888;
        Socket clientSocket = new Socket(host, port);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line;

        System.out.println("Напишите что-нибудь и нажмите enter. Мы отправим это на сервер и узнаем что он думает :) .");
        System.out.println();
        while (true) {
            line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
            System.out.println("Отправка...");
            out.println(line); // отсылаем введенную строку текста серверу.
            line = in.readLine(); // ждем пока сервер отошлет строку текста.
            System.out.println("Сервер любезно прислал нам: " + line);
            System.out.println("Похоже, сервер рад нашему общению. Продолжайте вводить новые сообщения.");
            System.out.println();
        }
    }
}
