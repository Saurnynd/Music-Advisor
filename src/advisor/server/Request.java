package advisor.server;
import advisor.server.exception.ClientServerException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static advisor.Config.API_SERVER;
import static advisor.Config.ACCESS_TOKEN;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public  class Request {
    public static JsonObject loadData(String path) throws ClientServerException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", " Bearer " + ACCESS_TOKEN)
                .uri(URI.create(API_SERVER + path))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

            try {
                return JsonParser.parseString(response.body()).getAsJsonObject();
            } catch (NullPointerException npe) {
                String message = JsonParser.parseString(response.body())
                        .getAsJsonObject()
                        .get("error")
                        .getAsJsonObject()
                        .get("message").toString();
                throw new ClientServerException(message);
            }
        } catch (IOException | InterruptedException e) {
            throw new ClientServerException(e.getMessage());
        }
    }
}
