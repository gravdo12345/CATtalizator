package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws IOException {
        // URL для запиту статусу HTTP(статус: лепавий)
        String imageUrl = "https://http.cat/" + code + ".jpg";

        // чиниме URL з'єднання
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Перевіряємо, чи усьо гі то має бути
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return imageUrl; // Повертаємо(на границі) URL зображення
        } else {
            throw new IOException("There is no image for HTTP status " + code);
        }
    }
}
