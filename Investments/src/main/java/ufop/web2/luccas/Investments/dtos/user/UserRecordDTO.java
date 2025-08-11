package ufop.web2.luccas.Investments.dtos.user;

import ufop.web2.luccas.Investments.dtos.address.AddressRecordDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.CreditCardRecordDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.investment.UserInvestmentRecordDTO;
import ufop.web2.luccas.Investments.enums.EnumUserStatus;
import ufop.web2.luccas.Investments.enums.EnumUserType;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record UserRecordDTO(
        UUID id,
        String name,
        String email,
        EnumUserStatus status,
        EnumUserType userType,
        String cpf,
        String phone,
        LocalDateTime dateOfBirth,
        List<CreditCardRecordDTO> creditCards,
        List<AddressRecordDTO> addresses,
        List<UserInvestmentRecordDTO> investments
) {

}
