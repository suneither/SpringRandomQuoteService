package demo2.controller;

import demo2.model.dto.QuoteCreateDTO;
import demo2.model.dto.QuoteResponseDTO;
import demo2.model.dto.QuoteUpdateDTO;
import demo2.service.QuoteService;
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
    public ResponseEntity<QuoteResponseDTO> getRandomQuote() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quoteService.getRandomQuote());
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
    public ResponseEntity<QuoteResponseDTO> saveQuote(@RequestBody QuoteCreateDTO quoteCreateDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quoteService.saveQuote(quoteCreateDTO));
    }

    @PutMapping("/updateQuote")
    public ResponseEntity<QuoteResponseDTO> updateQuote(@RequestBody QuoteUpdateDTO quoteUpdateDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quoteService.updateQuote());
    }

}
