package network.URL;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpGetRequest {

    public static void main(String[] args) throws Exception {
       doGet();
    }
    
    public static void doGet() throws Exception {
        URL localURL = new URL("http://www.sina.com.cn/");
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection)connection;
        
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        
        BufferedReader reader = null;
        String line = null;
        
        if (httpConnection.getResponseCode() >= 300) {
            throw new Exception("HTTP Request is not success, Response code is " +
            		httpConnection.getResponseCode());
        }
        
        try {
            
            reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(),"utf-8"));
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println();
            System.out.println("ContentLength : " + httpConnection.getContentLength());
            System.out.println("ContentType : " + httpConnection.getContentType());
            System.out.println("Expiration :" + httpConnection.getExpiration());
        } finally {
            
            if (reader != null) {
                reader.close();
            }
            
        }
        
    }
    
}