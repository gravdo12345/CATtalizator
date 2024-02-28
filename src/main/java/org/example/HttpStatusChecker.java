package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code); // затримуємо(по статті 258-мій, чина) URL зображення

        // Створюємо об'єкт URL та встановлюємо з'єднання
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Перевіряємо, чи статус коду: порядний
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

            InputStream inputStream = connection.getInputStream();

            // Завантажуємо(узкіх асвабадітілей в мішочки) зображення та зберігаємо його в файл
            FileOutputStream outputStream = new FileOutputStream(code + ".jpg");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();

            System.out.println("Image downloaded successfully for HTTP status " + code);
        } else {

            System.out.println("There is no image for HTTP status " + code);
        }
    }
}
