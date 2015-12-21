package com.kevyporter.pixelplus.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 4/12/2015.
 */
public class Util {

    private static Util instance = new Util();

    public static Util getInstance() {
        return instance;
    }

    public List<String> colors;
    public List<String> admins;

    private Util() {
        // colors
        colors = new ArrayList<String>();
        colors.add("§0");
        colors.add("§1");
        colors.add("§2");
        colors.add("§3");
        colors.add("§4");
        colors.add("§5");
        colors.add("§6");
        colors.add("§7");
        colors.add("§8");
        colors.add("§9");
        colors.add("§a");
        colors.add("§b");
        colors.add("§c");
        colors.add("§d");
        colors.add("§e");
        colors.add("§f");
        colors.add("§l");
        colors.add("§k");
        colors.add("§n");
        colors.add("§m");
        colors.add("§o");
        colors.add("§r");
    }

    public String getAdmins()
    {
        String url = "https://raw.githubusercontent.com/KevyPorter/PP/master/admins/admins.txt";
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

    private HttpURLConnection createConnection(String s) throws Exception {
        URL url = new URL(s);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setUseCaches(true);
        connection.addRequestProperty("User-Agent", "Mozilla/4.76");
        connection.setDoOutput(true);
        return connection;
    }

}
