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

    private WalletDomain wallet;

    private EnumInvestmentType type;
    private EnumInvestmentStatus status;

    private String symbol;

    private float quantity;

    private float purchasePrice;
    private float currentPrice;

    private float desempenho;

    private float indice;

    private float investedAmount;   // quantity * purchasePrice
    private float marketValue;      // quantity * currentPrice
    private float profit;           // marketValue - investedAmount
    private float profitPercent;    // (profit / investedAmount) * 100
    private float relativePerformance; // desempenho - indice

    private LocalDateTime purchaseDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
