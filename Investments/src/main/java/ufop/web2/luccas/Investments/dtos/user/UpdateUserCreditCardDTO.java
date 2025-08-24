package ufop.web2.luccas.Investments.dtos.user;

import java.util.UUID;

public record UpdateUserCreditCardDTO (

    UUID id,
    String creditCardNumber,
    UUID creditCardNetworkId

) {
}
