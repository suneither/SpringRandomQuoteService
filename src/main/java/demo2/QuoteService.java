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
                .orElseThrow(() -> new EntityNotFoundException("We are out of quotes!"));
    }

    public QuoteResponseDTO deleteById(Long id){
        String message;

        Optional<Quote> quoteOptional = repository.findById(id);
        if(quoteOptional.isPresent()){
            repository.deleteById(id);
            message = "Quote #" + id + " was successfully deleted.";
            return new QuoteResponseDTO(message, quoteOptional.get());
        }

        message = "Quote #" + id + " was not found.";
        throw new EntityNotFoundException(message);
    }
}
