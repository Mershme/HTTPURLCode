package HTTPURLCode;

import java.net.*;
import java.io.*;

// shows you how to upload content from a specific URL address
public class HTTPURL {

    private final String uAgent = "Mozilla/5.0";

    public static void main(String[] args) {

    	HTTPURL conn = new HTTPURL();

        try {
            conn.run();
            conn.testUrl();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void run() throws Exception {

        URL myUrl = new URL("https://www.lds.org/?lang=eng");
        HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
        conn.setDoOutput(true);

        conn.setRequestProperty("agent", uAgent);

        int rc = conn.getResponseCode();
        System.out.println("\nSending the response to the specified URL: " + myUrl);
        System.out.println("Response Code = " + rc);
        System.out.println();
    }

    private void testUrl(){

        String myUrl = "https://www.lds.org/?lang=eng";
        URL byuiUrl;

        try {
            byuiUrl = new URL(myUrl);
            HttpURLConnection httpConn = (HttpURLConnection)byuiUrl.openConnection();

            print(httpConn);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void print(HttpURLConnection httpConnection){
        if(httpConnection != null){

            try {
                System.out.println("URL Content of https://www.lds.org/?lang=eng:");
                BufferedReader buffer = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

                String s;

                while ((s = buffer.readLine()) != null){
                    System.out.println(s);
                }
                buffer.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}