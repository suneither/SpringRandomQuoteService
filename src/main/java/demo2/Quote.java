package demo2;

import jakarta.persistence.*;

@Entity
public class Quote {

    @Id @GeneratedValue
    private Long id;
    private String quote;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    private Quote(){}

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

    public Author getAuthor() {
        return author;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
