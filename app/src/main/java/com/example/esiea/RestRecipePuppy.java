package com.example.esiea;

import java.util.List;

public class RestRecipePuppy
{
    private String title;
    private Integer count;
    private String previous;
    private List<RecipePuppy> results;

    public String getTitle() {
        return title;
    }

    public Integer getCount() {
        return count;
    }

    public String getPrevious() {
        return previous;
    }

    public List<RecipePuppy> getResults() {
        return results;
    }
}
