package cafefashionsociety.structureliteraturemeadow.model;

public class Quote {
    private String quotetext;
    private String quoteauthor;

    public Quote() {
    }

    public Quote(String quotetext, String quoteauthor) {
        this.quotetext = quotetext;
        this.quoteauthor = quoteauthor;
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
