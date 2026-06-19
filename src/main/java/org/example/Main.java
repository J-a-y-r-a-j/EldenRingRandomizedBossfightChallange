package org.example;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        StringBuilder url = new StringBuilder("https://eldenring.fanapis.com/api/weapons?limit=1&page=");

        Random rand = new Random();
        int page = rand.nextInt(307);
        System.out.println(page);
        url.append(Integer.toString(page));
        System.out.println(url);
        URL urlobj =  new URL(url.toString());

        HttpsURLConnection conn = (HttpsURLConnection) urlobj.openConnection();
        conn.setRequestMethod("GET");

        int resposnecodee = conn.getResponseCode();
        System.out.println("resp code"+resposnecodee);

        if(resposnecodee == HttpsURLConnection.HTTP_OK){
            StringBuilder sb =  new StringBuilder();
            Scanner s1 =  new Scanner(conn.getInputStream());

            while(s1.hasNext()){
                sb.append(s1.next());
            }
            System.out.println(sb);
        }else{
            System.out.println("error");
        }
    }
}