package ufop.web2.luccas.Investments.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufop.web2.luccas.Investments.dtos.address.AddressRecordDTO;
import ufop.web2.luccas.Investments.dtos.address.CreateAddressDTO;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.CreateCreditCardNetworkDTO;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.CreditCardNetworkRecordDTO;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.DeleteCreditCardNetworkDTO;
import ufop.web2.luccas.Investments.dtos.investment.CreateInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.DeleteInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.user.UserRecordDTO;
import ufop.web2.luccas.Investments.services.CreditCardNetworkService;
import ufop.web2.luccas.Investments.services.InvestmentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    @GetMapping("/status")
    public ResponseEntity<String> getUserStatus() {
        return ResponseEntity.ok("Service is running");
    }

    @GetMapping
    public ResponseEntity<List<InvestmentRecordDTO>> getAll() {

        return ResponseEntity.ok(investmentService.getAllInvestments());

    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestmentRecordDTO> getById(@PathVariable(value = "id") String id) {

        InvestmentRecordDTO investmentRecordDTO = investmentService.getInvestmentById(id);

        if (investmentRecordDTO == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(investmentRecordDTO);


    }

    @PostMapping
    public ResponseEntity<InvestmentRecordDTO> createInvestment(@RequestBody CreateInvestmentDTO dto) {

        InvestmentRecordDTO investmentRecordDTO = investmentService.createInvestment(dto);

        if (investmentRecordDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(investmentRecordDTO);

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteInvestment(@RequestBody DeleteInvestmentDTO dto) {

        investmentService.deleteInvestment(dto);
        return ResponseEntity.ok("Investment has been deleted.");

    }
}
