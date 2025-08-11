package ufop.web2.luccas.Investments.converters;

import ufop.web2.luccas.Investments.domains.CreditCardDomain;
import ufop.web2.luccas.Investments.dtos.creditcard.CreateCreditCardDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.CreditCardRecordDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.SuperCreditCardRecordDTO;
import ufop.web2.luccas.Investments.models.CreditCardModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardConverter {

    // Conversão do modelo (jpa) para o DTO de saída
    public static CreditCardRecordDTO toCreditCardRecordDTO(CreditCardModel model) {
        return new CreditCardRecordDTO(
                model.getId(),
                model.getOwner(),
                model.getCreditCardNetworkModel().getName(),
                model.getCreditCardNumber(),
                model.getCvc(),
                model.getExpiryDate()
        );
    }

    // Conversão do DTO de criação para o domínio
    public static CreditCardDomain toCreditCardDomain(CreateCreditCardDTO dto) {

        return CreditCardDomain.builder()
                .owner(dto.getOwner())
                .creditCardNumber(dto.getCreditCardNumber())
                .cvc(dto.getCvc())
                .expiryDate(dto.getExpiryDate())
                .build();

    }

    public static CreditCardModel toCreditCardModel(CreditCardDomain domain) {
        return CreditCardModel.builder()
                .id(domain.getId())
                // Não atribua o usuário para evitar loop
                //.user(UserConverter.toUserModel(domain.getUser()))
                .creditCardNetworkModel(CreditCardNetworkConverter.toCreditCardNetworkModel(domain.getCreditCardNetworkDomain()))
                .creditCardNumber(domain.getCreditCardNumber())
                .cvc(domain.getCvc())
                .owner(domain.getOwner())
                .expiryDate(domain.getExpiryDate())
                .build();
    }

    public static SuperCreditCardRecordDTO toSuperCreditCardRecordDTO(CreditCardModel model) {
        return SuperCreditCardRecordDTO.builder()
                .id(model.getId())
                .owner(model.getOwner())
                .creditCardNumber(model.getCreditCardNumber())
                .cvc(model.getCvc())
                .expiryDate(model.getExpiryDate())
                .creditCardNetwork(CreditCardNetworkConverter.toSimpleCreditCardNetworkDTO(model.getCreditCardNetworkModel()))
                .build();
    }

}
