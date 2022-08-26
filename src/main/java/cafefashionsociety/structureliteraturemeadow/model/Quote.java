package cafefashionsociety.structureliteraturemeadow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Quote {

    @Id
    private String quoteid;
    private String quotetext;
    private String quoteauthor;

    public Quote() {
    }

    public Quote(String quotetext, String quoteauthor) {
        this.quotetext = quotetext;
        this.quoteauthor = quoteauthor;
    }

    public String getQuoteid() {
        return quoteid;
    }

    public void setQuoteid(String quoteid) {
        this.quoteid = quoteid;
    }

    public String getQuotetext() {
        return quotetext;
    }

    public void setQuotetext(String quotetext) {
        this.quotetext = quotetext;
    }

    public String getQuoteauthor() {
        return quoteauthor;
    }

    public void setQuoteauthor(String quoteauthor) {
        this.quoteauthor = quoteauthor;
    }
}
