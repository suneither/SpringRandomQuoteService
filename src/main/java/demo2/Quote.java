package demo2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Quote {

    @Id @GeneratedValue
    private Long id;
    private String quote;

    Quote(){}

    Quote(String quote) {
        this.quote = quote;
    }

    Quote(QuoteCreateDTO quoteCreateDTO){
        this.quote = quoteCreateDTO.getQuote();
    }

    public Long getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
