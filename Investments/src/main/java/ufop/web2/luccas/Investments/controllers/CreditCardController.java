package ufop.web2.luccas.Investments.controllers;

import ufop.web2.luccas.Investments.dtos.creditcard.CreateCreditCardDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.CreditCardRecordDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.DeleteCreditCardDTO;
import ufop.web2.luccas.Investments.services.CreditCardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cc")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @GetMapping("/status")
    public ResponseEntity<String> getUserStatus() {
        return ResponseEntity.ok("Hello There - Service is running");
    }

    @GetMapping
    public ResponseEntity<List<CreditCardRecordDTO>> getAll() {

        return ResponseEntity.ok(
                creditCardService.getAll()
        );

    }

    @PostMapping
    public ResponseEntity<CreditCardRecordDTO> create(@RequestBody CreateCreditCardDTO createCreditCardDTO) {

        CreditCardRecordDTO simpleCreditCardDTO
                = creditCardService.create(createCreditCardDTO);

        if (simpleCreditCardDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(simpleCreditCardDTO);

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteCreditCard(@RequestBody DeleteCreditCardDTO dto) {

        creditCardService.deleteCreditCard(dto);
        return ResponseEntity.ok("Credit Card has been deleted.");

    }
}
