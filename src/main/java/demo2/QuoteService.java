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
            return new QuoteResponseDTO.Builder()
                    .addQuote(quoteOptional.get())
                    .setMessage(message)
                    .build();
        }

        message = "Quote #" + id + " was not found.";
        throw new EntityNotFoundException(message);
    }

    public QuoteResponseDTO saveQuote(Quote quote) {
        Optional<Quote> quoteOptional = Optional.of(repository.save(quote));
        return new QuoteResponseDTO.Builder()
                .addQuote(quoteOptional.get())
                .setMessage("Quote successfully saved.")
                .build();
    }

    // save quote without allowing id as an input

    // create PutMapping for fully updatable entity letting enter id as an PathVaraible

    // create QuoteCreateDTO
    // create QuoteUpdateDTO

    // change All endpoints that send Quote object to DTO's

    public QuoteResponseDTO findAll() {
        return new QuoteResponseDTO.Builder()
                .setMessage("All found quotes.")
                .addQuotes(repository.findAll())
                .build();
    }
}
