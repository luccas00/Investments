package ufop.web2.luccas.Investments.domains;

import ufop.web2.luccas.Investments.enums.EnumUserStatus;
import ufop.web2.luccas.Investments.enums.EnumUserType;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDomain {

    private UUID id;
    private UUID key;
    private String name;

    private List<CreditCardDomain> creditCards = new ArrayList<>();

    private List<AddressDomain> addresses = new ArrayList<>();

    private List<WalletDomain> wallets = new ArrayList<>();

    private EnumUserType userType;
    private EnumUserStatus status;

    private String email;
    private String password;

    private String cpf;

    private String phone;

    private LocalDateTime dateOfBirth;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
