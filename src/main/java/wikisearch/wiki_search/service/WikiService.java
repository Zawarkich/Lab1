package wikisearch.wiki_search.service;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WikiService {
    

    public String searchInWikipedia(String term) {
        String apiUrl = "https://ru.wikipedia.org/w/api.php?" +
                "action=query&list=search&srsearch=" + term + "&format=json";
    
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
    
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            
            // Преобразуем Unicode-символы в читаемый текст
            String decodedResponse = StringEscapeUtils.unescapeJson(jsonResponse);
            return decodedResponse;
        } catch (IOException | InterruptedException e) {
            return "{\"error\":\"Failed to fetch data\"}";
        }
    }
}