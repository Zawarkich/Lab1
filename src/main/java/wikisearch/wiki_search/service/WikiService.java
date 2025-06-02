package wikisearch.wiki_search.service;

import wikisearch.wiki_search.entity.WikiArticle;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WikiService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String WIKI_API_URL = 
        "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&explaintext=true&titles=";

    public WikiArticle search(String term) {
        String url = WIKI_API_URL + term;
        String response = restTemplate.getForObject(url, String.class);

        String title = term;
        String extract = response.contains("extract") ? 
            response.split("\"extract\":\"")[1].split("\"")[0] : 
            "No results found";

        return new WikiArticle(title, extract);
    }
}