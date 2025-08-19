package ufop.web2.luccas.Investments.dtos.wallet;

import lombok.Builder;
import ufop.web2.luccas.Investments.dtos.investment.WalletInvestmentRecordDTO;
import ufop.web2.luccas.Investments.models.InvestmentModel;

import java.util.List;
import java.util.UUID;

@Builder
public record UserWalletRecordDTO(

    UUID id,
    float amount,
    float balance,
    float desempenho,
    float totalQuantity,
    float totalInvested,
    float totalMarketValue,
    float totalProfit,
    float totalProfitPercent,
    List<WalletInvestmentRecordDTO> investments

) {
}
