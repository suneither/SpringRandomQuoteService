package demo2;

public class QuoteResponseDTO {
    private String message;
    private Quote quote;

    private QuoteResponseDTO(){}

    QuoteResponseDTO(String message, Quote quote){
        this.message = message;
        this.quote = quote;
    }

    public void setQuote(Quote quote){
        this.quote = quote;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Quote getQuote() {
        return quote;
    }
}
