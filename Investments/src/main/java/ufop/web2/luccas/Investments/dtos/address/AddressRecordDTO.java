package ufop.web2.luccas.Investments.dtos.address;

import java.util.UUID;

public record AddressRecordDTO (
    UUID id,
    String street,
    String complement,
    String neighborhood,
    String city,
    String state,
    String region,
    String uf,
    String ddd
) {
}
