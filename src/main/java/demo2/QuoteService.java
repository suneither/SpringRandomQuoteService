package demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository repository;

    public Quote getRandomQuote(){
        return repository.findAll().stream()
                .findAny()
                .orElse(new Quote("No Quotes were found"));

        // Make it to return custom error message related to not found quote
    }

    public QuoteResponseDTO deleteById(Long id) {
        StringBuilder sb = new StringBuilder();
        String message;
        Optional<Quote> quoteOptional = repository.findById(id);
        if(quoteOptional.isPresent()){
            repository.deleteById(id);
            message = sb.append("Quote by ").append(id).append(" was successfully deleted.").toString();
            return new QuoteResponseDTO(message, quoteOptional.get());
        }

        message = sb.append("Quote by ").append(id).append("was not found.").toString();
        return new QuoteResponseDTO(message, null);

        // is it OK to send ResponseEntity with status 200 if quote was not found nor deleted?
    }
}
