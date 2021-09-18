import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

import com.google.gson.*;


public class getListFromUrl {

    private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
    public static void main(String[] args) {
        try{
            Gson gson = new Gson();
            List<String>movies = new ArrayList<>();
            String title = "Spiderman";
            int page=1;
            String data = getData(BASE_URL+title+"&page="+page);
            JsonObject jo = gson.fromJson(data,JsonObject.class);
            int TotalPages = Integer.parseInt(jo.get("total_pages").toString());
            JsonArray ja = jo.getAsJsonArray("data");
            for(int i=0;i<ja.size();i++){
                jo = ja.get(i).getAsJsonObject();
                movies.add(jo.get("Title").toString());
            }
            while(page!=TotalPages){
                page++;
                data = getData(BASE_URL+title+"&page="+page);
                jo = gson.fromJson(data,JsonObject.class);
                ja = jo.getAsJsonArray("data");
                for(int i=0;i<ja.size();i++){
                    jo = ja.get(i).getAsJsonObject();
                    movies.add(jo.get("Title").toString());
                }
            }
            System.out.println("size="+movies.size());
        }catch(Exception e){

        }
    }

    public static String getData(String url) throws Exception{
        String result;
        System.out.println(url);
        try{
            URL conUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)conUrl.openConnection();
            connection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();

        }catch(Exception e){
            throw new Exception("error while connecting...");
        }

    }
}
