package com.kevyporter.pixelplus.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kevy on 25/11/2015.
 */
public class PlanckeAPI {

    private static PlanckeAPI instance = new PlanckeAPI();

    private static String BASE_URL = "http://plancke.nl/hypixel/api.php?request=";

    public static String getPlayer(final String name) {
        // http://plancke.nl/hypixel/api.php?request=player&player=<name>
        String url = BASE_URL + "player&player=" + name;
        String content = "";
        try {
            HttpURLConnection con = createConnection(url);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                content = content + input;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getGuild(String name)
    {
        // http://plancke.nl/hypixel/api.php?request=guild&player=Kevy
        String url = BASE_URL + "guild&player=" + name;
        String content = "";
        try {
            HttpURLConnection con = createConnection(url);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                content = content + input;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getBoosters()
    {
        // http://plancke.nl/hypixel/api.php?request=boosters
        String url = BASE_URL + "boosters";
        String content = "";
        try {
            HttpURLConnection con = createConnection(url);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                content = content + input;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
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
