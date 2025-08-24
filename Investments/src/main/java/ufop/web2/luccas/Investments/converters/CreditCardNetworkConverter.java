package ufop.web2.luccas.Investments.converters;

import ufop.web2.luccas.Investments.domains.CreditCardNetworkDomain;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.CreateCreditCardNetworkDTO;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.CreditCardNetworkRecordDTO;
import ufop.web2.luccas.Investments.models.CreditCardNetworkModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardNetworkConverter {

    // Conversão do modelo (jpa) para o DTO de saída
    public static CreditCardNetworkRecordDTO  toSimpleCreditCardNetworkDTO(CreditCardNetworkModel creditCardNetworkModel) {

        return new CreditCardNetworkRecordDTO(
                creditCardNetworkModel.getId(),
                creditCardNetworkModel.getName()
        );

    }

    // Conversão do DTO de criação para o domínio
    public static CreditCardNetworkDomain toCreditCardNetworkDomain(CreateCreditCardNetworkDTO createCreditCardNetworkDTO) {

        return CreditCardNetworkDomain.builder()
                .name(createCreditCardNetworkDTO.name())
                .build();

    }

    public static CreditCardNetworkDomain toCreditCardNetworkDomain(CreditCardNetworkModel model) {

        return CreditCardNetworkDomain.builder()
                .name(model.getName())
                .id(model.getId())
                .build();

    }

    // Conversão do domínio para o modelo
    public static CreditCardNetworkModel toCreditCardNetworkModel(CreditCardNetworkDomain creditCardNetworkDomain) {

        return CreditCardNetworkModel.builder()
                .id(creditCardNetworkDomain.getId())
                .name(creditCardNetworkDomain.getName())
                .build();

    }

}
