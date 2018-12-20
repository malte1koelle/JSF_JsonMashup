package com.journaldev.jsf.helloworld;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
public class API {

    String key;
    public API(){
        this.key = "8NuHklPIzs67Nl8PmsrsayNtHGTFNkxq";
    }
    public GifDAO getRandomGif(){

        JSONObject obj = new JSONObject(this.getRequest("http://api.giphy.com/v1/gifs/random?api_key=" + key));

        String url = obj.getJSONObject("data").getString("embed_url");

        GifDAO gif = new GifDAO(url);
        return gif;
    }

    private String getRequest(String urlString) {
        try {

            URL url = new URL(urlString);

            String readLine = null;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            int status = connection.getResponseCode();

            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

                StringBuffer response = new StringBuffer();

                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();
                return response.toString();
            } else {
                System.out.println("GET NOT WORKED");
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return "AN ERROR OCCURRED";
    }
}
