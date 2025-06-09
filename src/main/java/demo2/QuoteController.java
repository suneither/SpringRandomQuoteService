package demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/getRandomQuote")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/findAll")
    public ResponseEntity<QuoteResponseDTO> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quoteService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<QuoteResponseDTO> deleteById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quoteService.deleteById(id));
    }

    @PostMapping("/saveQuote")
    public ResponseEntity<QuoteResponseDTO> saveQuote(@RequestBody Quote quote){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quoteService.saveQuote(quote));
    }



}
