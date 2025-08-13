package ufop.web2.luccas.Investments.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufop.web2.luccas.Investments.dtos.investment.CreateInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.DeleteInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.wallet.CreateWalletDTO;
import ufop.web2.luccas.Investments.dtos.wallet.DeleteWalletDTO;
import ufop.web2.luccas.Investments.dtos.wallet.WalletRecordDTO;
import ufop.web2.luccas.Investments.services.InvestmentService;
import ufop.web2.luccas.Investments.services.WalletService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/wallets")
public class WalletController {

    private final InvestmentService investmentService;
    private final WalletService walletService;

    @GetMapping("/status")
    public ResponseEntity<String> getUserStatus() {
        return ResponseEntity.ok("Service is running");
    }

    @GetMapping
    public ResponseEntity<List<WalletRecordDTO>> getAll() {

        return ResponseEntity.ok(walletService.getAllWallets());

    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletRecordDTO> getById(@PathVariable(value = "id") String id) {

        WalletRecordDTO walletRecordDTO = walletService.getWalletById(id);

        if (walletRecordDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(walletRecordDTO);
    }

    @PostMapping
    public ResponseEntity<WalletRecordDTO> createWallet(@RequestBody CreateWalletDTO dto) {

        WalletRecordDTO walletRecordDTO = walletService.createWallet(dto);

        if (walletRecordDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(walletRecordDTO);

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteWallet(@RequestBody DeleteWalletDTO dto) {

        walletService.deleteWallet(dto);
        return ResponseEntity.ok("Wallet has been deleted.");

    }

}
