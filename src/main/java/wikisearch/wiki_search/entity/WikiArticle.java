package wikisearch.wiki_search.entity;

import lombok.Data;

@Data
public class WikiArticle {
    private String title;
    private String content;
    
    public WikiArticle(String title, String content) {
        this.title = title;
        this.content = content;
    }
}