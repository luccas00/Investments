package ufop.web2.luccas.Investments.dtos.wallet;

import java.util.UUID;

public record WalletIDRecordDTO (

        UUID id,
        float amount,
        float balance,
        float desempenho,
        float totalQuantity,
        float totalInvested,
        float totalMarketValue,
        float totalProfit,
        float totalProfitPercent
) {
}
