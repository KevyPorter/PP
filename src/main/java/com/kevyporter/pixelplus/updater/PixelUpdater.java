package com.kevyporter.pixelplus.updater;

import com.kevyporter.pixelplus.PixelPlusMod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kevy on 12/08/2015.
 */
public class PixelUpdater {

    public static boolean isUpdate = false;

    public static void checkForUpdate() {
        // https://raw.githubusercontent.com/KevyPorter/PP/master/update/version.txt
        String url = "https://raw.githubusercontent.com/KevyPorter/PP/master/update/version.txt";
        String content = "";
        try

        {
            HttpURLConnection con = createConnection(url);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                content = content + input;
            }
            br.close();
        } catch (
                Exception e
                )

        {
            e.printStackTrace();
        }

        Integer version = Integer.parseInt(PixelPlusMod.VERSION.replace(".", ""));
        Integer update = Integer.parseInt(content.replace(".", ""));
        if (update > version)

        {
            isUpdate = true;
        }
    }

    private static HttpURLConnection createConnection(String s) throws Exception {
        URL url = new URL(s);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setUseCaches(true);
        connection.addRequestProperty("User-Agent", "Mozilla/4.76");
        connection.setDoOutput(true);
        return connection;
    }

}
