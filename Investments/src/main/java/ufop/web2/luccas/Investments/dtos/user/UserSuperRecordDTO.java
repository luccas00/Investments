package ufop.web2.luccas.Investments.dtos.user;


import ufop.web2.luccas.Investments.dtos.address.AddressRecordDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.SuperCreditCardRecordDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.wallet.UserWalletRecordDTO;
import ufop.web2.luccas.Investments.enums.EnumUserStatus;
import ufop.web2.luccas.Investments.enums.EnumUserType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSuperRecordDTO {

    private UUID id;
    private UUID key;
    private String name;
    private String email;
    private String password;
    private EnumUserType userType;
    private EnumUserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String cpf;
    private String phone;
    private LocalDateTime dateOfBirth;
    private List<SuperCreditCardRecordDTO> creditCards;
    private List<AddressRecordDTO> addresses;
    private List<UserWalletRecordDTO> wallets;

}