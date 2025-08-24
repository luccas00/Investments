package ufop.web2.luccas.Investments.dtos.investment;

import ufop.web2.luccas.Investments.enums.EnumInvestmentStatus;
import ufop.web2.luccas.Investments.enums.EnumInvestmentType;

import java.time.LocalDateTime;

public record WalletInvestmentRecordDTO(

        EnumInvestmentType type,
        EnumInvestmentStatus status,
        String symbol,
        float quantity,
        float purchasePrice,
        float currentPrice,
        float desempenho,
        float indice,
        float investedAmount,
        float marketValue,
        float profit,
        float profitPercent,
        float relativePerformance,
        LocalDateTime purchaseDate

) {
}
