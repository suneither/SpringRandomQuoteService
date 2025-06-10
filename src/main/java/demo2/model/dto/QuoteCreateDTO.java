package demo2.model.dto;

public class QuoteCreateDTO {
    private String quote;

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

