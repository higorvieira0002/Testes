package OpenSKY.opensky;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PUT {

	public static void main(String[] args) {
		try {
            String url = "https://jsonplaceholder.typicode.com/posts/1";
            
            Map<String,Object> params = new LinkedHashMap<String, Object>();
            params.put("userId", 123);
            params.put("id", 1);
            params.put("title", "Fechamento");
            params.put("body", "Hoje vou finalizar a pauta para reunião de amanhã");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }

            conn.disconnect();

            System.out.println("" + params);

        } catch (IOException ex) {
            Logger.getLogger(APIRest.class.getName()).log(Level.SEVERE, null, ex);
        }
    

	}

}
