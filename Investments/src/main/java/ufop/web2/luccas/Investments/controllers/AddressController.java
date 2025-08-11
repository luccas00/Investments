package ufop.web2.luccas.Investments.controllers;

import ufop.web2.luccas.Investments.dtos.address.AddressRecordDTO;
import ufop.web2.luccas.Investments.dtos.address.CreateAddressDTO;
import ufop.web2.luccas.Investments.dtos.address.DeleteAddressDTO;
import ufop.web2.luccas.Investments.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/status")
    public ResponseEntity<String> getUserStatus() {
        return ResponseEntity.ok("Hello There - Service is running");
    }

    @GetMapping
    public ResponseEntity<List<AddressRecordDTO>> getAll() {

        return ResponseEntity.ok(
                addressService.getAllAddresses()
        );

    }

    @PostMapping
    public ResponseEntity<AddressRecordDTO> create(@RequestBody CreateAddressDTO dto) {

        AddressRecordDTO addressRecordDTO = addressService.createAddress(dto);

        if (addressRecordDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(addressRecordDTO);

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteAddress(@RequestBody DeleteAddressDTO dto) {

        addressService.deleteAddress(dto);
        return ResponseEntity.ok("Address has been deleted.");

    }
}
