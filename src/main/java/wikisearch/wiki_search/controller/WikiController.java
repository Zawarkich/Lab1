package wikisearch.wiki_search.controller;

import wikisearch.wiki_search.service.WikiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WikiController {

    private final WikiService wikiService;

    public WikiController(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping("/api/search")
    public String searchWiki(@RequestParam String term) {
        return wikiService.searchInWikipedia(term);
    }
}