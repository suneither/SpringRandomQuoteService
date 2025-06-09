package demo2;

import java.util.ArrayList;
import java.util.List;

public class QuoteResponseDTO {
    private String message;
    private final List<Quote> quotes = new ArrayList<>();

    private QuoteResponseDTO(){}

    QuoteResponseDTO(String message, List<Quote> quotes){
        this.message = message;
        this.quotes.addAll(quotes);
    }

    QuoteResponseDTO(Builder builder){
        this.message = builder.message;
        this.quotes.addAll(builder.quotes);
    }

    public void addQuote(Quote quote){
        this.quotes.add(quote);
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public static class Builder {
        private String message;
        private final List<Quote> quotes = new ArrayList<>();

        public Builder setMessage(String message){
            this.message = message;
            return this;
        }

        public Builder addQuote(Quote quote){
            this.quotes.add(quote);
            return this;
        }

        public Builder addQuotes(List<Quote> quotes){
            this.quotes.addAll(quotes);
            return this;
        }

        public QuoteResponseDTO build(){
            return new QuoteResponseDTO(this);
        }
    }
}
