package com.javarush.task.task40.task4002;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* 
Опять POST, а не GET
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost("http://requestb.in/1h4qhvv1", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        org.apache.http.client.HttpClient client = getHttpClient();
        HttpPost request = new HttpPost(url);
        request.addHeader("User-Agent", "Mozilla/5.0");


        List<NameValuePair> pairList = new ArrayList<>();
        String[] s = urlParameters.split("&");
        for (int i = 0; i < s.length ; i++) {
            String g = s[i];
            pairList.add(new BasicNameValuePair(g.substring(0, g.indexOf("=")), g.substring(g.indexOf("=")+1)));
        }
        request.setEntity(new UrlEncodedFormEntity(pairList));
        HttpResponse response = client.execute(request);
        System.out.println("Response code" + response.getStatusLine().getStatusCode());


        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result.toString());
    }

    protected org.apache.http.client.HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
}
