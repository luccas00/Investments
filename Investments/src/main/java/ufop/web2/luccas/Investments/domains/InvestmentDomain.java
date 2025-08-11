package ufop.web2.luccas.Investments.domains;

import lombok.*;
import ufop.web2.luccas.Investments.enums.EnumInvestmentType;
import ufop.web2.luccas.Investments.enums.EnumInvestmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentDomain {

    private UUID id;

    private UserDomain user;

    private EnumInvestmentType type;
    private EnumInvestmentStatus status;

    private String symbol;

    private float quantity;
    private float purchasePrice;

    private LocalDateTime purchaseDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
