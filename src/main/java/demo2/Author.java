package demo2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "author")
    private final List<Quote> quotes = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addQuote(Quote quote) {
        this.quotes.add(quote);
        quote.setAuthor(this);
    }

    public void removeQuote(Quote quote){
        this.quotes.remove(quote);
        quote.setAuthor(null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
