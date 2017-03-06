package HTTPURLCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPURL {

    // This stores the agent user to Mozilla 5.0
    private final String agent = "Mozilla/5.0";

    public static void main(String args[]) {
        // Simply creates an instance of the class
        HTTPURL http = new HTTPURL();
        try {
            // Calls the go method
            http.go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() throws Exception{

        // Stores the keyword of "Dinosaur" from the URL of the specified Google search
        URL url = new URL("https://www.google.com/#q=Dinosaur&*");

        // Connects to the URL
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setDoOutput(true); //Allows POST

        connect.setRequestProperty("user-Agent", agent);

        // Stores the response code from the server
        int responseCode = connect.getResponseCode();
        // Prints out that its sending the response to the URL
        System.out.println("\nSending 'GET' response to URL: " + url);
        // Prints response code that was received from the server
        System.out.println("Response: " + responseCode);

        // Creates buffer reader and stores the input stream from the server
        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(connect.getInputStream()));

        String serverInput;
        // Saves the input stream that was received from the server
        StringBuffer savedInput = new StringBuffer();
        
        while((serverInput = buffer.readLine()) != null) {
            savedInput.append(serverInput);
        }

        buffer.close();
        // Prints the input stream that was received from the server in a java string.
        System.out.println(savedInput.toString());


    }

}
