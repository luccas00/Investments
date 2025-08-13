package ufop.web2.luccas.Investments.domains;

import jakarta.persistence.*;
import lombok.*;
import ufop.web2.luccas.Investments.models.InvestmentModel;
import ufop.web2.luccas.Investments.models.UserModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDomain {

    private UUID id;
    private UserDomain user;
    private List<InvestmentDomain> investments = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
