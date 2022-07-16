package cf.mindaugas._03_patterns._02_Structural;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class _03_FacadeUsage {
    public static void main(String args[]) throws Exception {
        // ... URL hides a lot behind it, but we just interact with a nice facade ...
        URL url = new URL("https", "www.delfi.ee", 443, "/"); // facade
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); // decorator
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
    }
}