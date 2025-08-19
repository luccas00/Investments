package ufop.web2.luccas.Investments.dtos.investment;

import ufop.web2.luccas.Investments.dtos.wallet.WalletIDRecordDTO;
import ufop.web2.luccas.Investments.enums.EnumInvestmentStatus;
import ufop.web2.luccas.Investments.enums.EnumInvestmentType;

import java.time.LocalDateTime;
import java.util.UUID;

public record InvestmentRecordDTO (

        UUID id,
        WalletIDRecordDTO walletId,
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
