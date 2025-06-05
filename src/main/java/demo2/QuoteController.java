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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<QuoteResponseDTO> deleteById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quoteService.deleteById(id));
    }



}
