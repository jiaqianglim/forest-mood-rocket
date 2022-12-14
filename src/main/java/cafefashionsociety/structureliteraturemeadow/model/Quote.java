package cafefashionsociety.structureliteraturemeadow.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Quote implements Serializable {

    @Id
    private String quoteid;
    private String quotetext;
    private String quoteauthor;

    public Quote(String quoteid, String quotetext, String quoteauthor) {
        this.quoteid = quoteid;
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
