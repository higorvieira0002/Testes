package OpenSKY.opensky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

public class Get {

	public static void main(String[] args) {
		try {
            String url = "https://jsonplaceholder.typicode.com/posts/1";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }

            conn.disconnect();

            Gson gson = new Gson();
            Dados dados = gson.fromJson(new String(output.getBytes()), Dados.class);

            System.out.println("userId: " + dados.getUserId());
            System.out.println("id: "  + dados.getId());
            System.out.println("title: " + dados.getTitle());
            System.out.println("body: " + dados.getBody());

        } catch (IOException ex) {
            Logger.getLogger(APIRest.class.getName()).log(Level.SEVERE, null, ex);
        }
    

	}

}
