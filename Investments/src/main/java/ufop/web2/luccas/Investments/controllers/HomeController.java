package ufop.web2.luccas.Investments.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufop.web2.luccas.Investments.util.Password;

import java.util.Map;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Investments Service is Online");
    }

    @PostMapping("/decript")
    public ResponseEntity<String> decriptCodex(@RequestBody Map<String, String> payload) throws Exception {

        String senha = payload.get("senha");
        UUID key = UUID.fromString(payload.get("key"));

        return ResponseEntity.ok(Password.decrypt(key, senha));
    }

    @PostMapping("/encrypt")
    public ResponseEntity<String> encryptCodex(@RequestBody Map<String, String> payload) throws Exception {

        String senha = payload.get("senha");
        UUID key = UUID.fromString(payload.get("key"));

        return ResponseEntity.ok(Password.encrypt(key, senha));
    }

}
