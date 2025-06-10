package demo2.service;

import demo2.exception.EntityNotFoundException;
import demo2.repository.QuoteRepository;
import demo2.model.dto.QuoteCreateDTO;
import demo2.model.dto.QuoteResponseDTO;
import demo2.model.entity.Quote;
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

   //TODO // create PutMapping for fully updatable entity letting enter id as an PathVaraible
    // create QuoteUpdateDTO
    // add author field to model as a new DB Entity
    // research how they can be linked
    // make neccessary variable only quote author optional


    // TODO: to saveQuote and updateQuote First I need to configure authorization
    // use that authorization name and surname as a author data
    // and then go to authorization level when save, update and quote/author repository works without circular infinite information pulling
    // (I remember that there was a problem when one model has a lot of other model stuff and that goes both ways circular depenndencies)


    // add authorization to 3 levels
    // admin can do everything
    // moderator can modify but not delete
    // guest(without authorization) can get one or all quotes


    // organize folder structure

    // create tests for each endpoint
    // check if when endpoint get wrong data is going to throw random things and crash?

    // create tests for each service layer method

    public QuoteResponseDTO findAll() {
        return new QuoteResponseDTO.Builder()
                .addQuotes(repository.findAll())
                .build();
    }

    public QuoteResponseDTO updateQuote() {
        return new QuoteResponseDTO.Builder().build();
    }
}
