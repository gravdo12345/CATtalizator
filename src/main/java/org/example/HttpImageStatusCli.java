package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {

    public void askStatus() {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter HTTP status code: ");
            String input = reader.readLine(); // Отримуємо введення користувача

            try {
                int code = Integer.parseInt(input);
                downloader.downloadStatusImage(code); // Спробуємо завантажити зображення, хто знаэ чи получиться
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number."); // Обробляємо помилку невірного формату числа
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage()); // Обробляємо помилку вводу-виводу
        } finally {
            try {
                reader.close(); // Закриваємо потік(потук, звур)
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus(); // Викликаємо метод для взаємодії з користувачем, метод - "сбу"
    }
}
