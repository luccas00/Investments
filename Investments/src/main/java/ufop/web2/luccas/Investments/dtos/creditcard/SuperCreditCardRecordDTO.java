package ufop.web2.luccas.Investments.dtos.creditcard;

import ufop.web2.luccas.Investments.dtos.creditcardnetwork.CreditCardNetworkRecordDTO;
import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record SuperCreditCardRecordDTO (
        UUID id,
        String owner,
        String creditCardNumber,
        int cvc,
        Date expiryDate,
        CreditCardNetworkRecordDTO creditCardNetwork
) { }
