package demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository repository;

    public QuoteResponseDTO getRandomQuote(){
        return repository.findAll().stream()
                .findAny()
                .map(quote -> new QuoteResponseDTO.Builder()
                        .addQuote(quote)
                        .setMessage("Successfully generated a quote.")
                        .build())
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

    public QuoteResponseDTO saveQuote(QuoteCreateDTO quoteCreateDTO) {
        Optional<Quote> quoteOptional = Optional.of(repository.save(new Quote(quoteCreateDTO)));
        return new QuoteResponseDTO.Builder()
                .addQuote(quoteOptional.get())
                .setMessage("Quote successfully saved.")
                .build();
    }

    // create PutMapping for fully updatable entity letting enter id as an PathVaraible

    // create QuoteUpdateDTO

    public QuoteResponseDTO findAll() {
        return new QuoteResponseDTO.Builder()
                .addQuotes(repository.findAll())
                .build();
    }
}
