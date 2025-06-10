package demo2;

public class QuoteCreateDTO {
    private String quote;
    private Author author;

    private QuoteCreateDTO(){
    }

    QuoteCreateDTO(String quote){
        this.quote = quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuote(){
        return quote;
    }
}

