package ufop.web2.luccas.Investments.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ufop.web2.luccas.Investments.domains.InvestmentDomain;
import ufop.web2.luccas.Investments.dtos.investment.CreateInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.investment.WalletInvestmentRecordDTO;
import ufop.web2.luccas.Investments.models.InvestmentModel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvestmentConverter {

    public static InvestmentRecordDTO toInvestmentRecordDTO(InvestmentModel model)
    {
        return new InvestmentRecordDTO(
                model.getId(),
                WalletConverter.toWalletIDRecordDTO(model.getWallet()),
                model.getType(),
                model.getStatus(),
                model.getSymbol(),
                model.getQuantity(),
                model.getPurchasePrice(),
                model.getCurrentPrice(),
                model.getDesempenho(),
                model.getIndice(),
                model.getMarketValue(),
                model.getProfit(),
                model.getProfitPercent(),
                model.getRelativePerformance(),
                model.getInvestedAmount(),
                model.getPurchaseDate()
        );
    }

    public static WalletInvestmentRecordDTO toWalletInvestmentRecordDTO(InvestmentModel model)
    {
        return new WalletInvestmentRecordDTO(
                model.getType(),
                model.getStatus(),
                model.getSymbol(),
                model.getQuantity(),
                model.getPurchasePrice(),
                model.getCurrentPrice(),
                model.getDesempenho(),
                model.getIndice(),
                model.getMarketValue(),
                model.getProfit(),
                model.getProfitPercent(),
                model.getRelativePerformance(),
                model.getInvestedAmount(),
                model.getPurchaseDate()
        );
    }

    public static InvestmentDomain toInvestmentDomain(CreateInvestmentDTO dto) {
        return InvestmentDomain.builder()
                .symbol(dto.getSymbol())
                .purchasePrice(dto.getPurchasePrice())
                .currentPrice(dto.getCurrentPrice())
                .indice(dto.getIndice())
                .quantity(dto.getQuantity())
                .type(dto.getType())
                .status(dto.getStatus())
                .build();
    }

    public static InvestmentModel toInvestmentModel(InvestmentDomain domain) {
        return InvestmentModel.builder()
                .wallet(WalletConverter.toWalletModel(domain.getWallet()))
                .id(domain.getId())
                .type(domain.getType())
                .status(domain.getStatus())
                .symbol(domain.getSymbol())
                .purchasePrice(domain.getPurchasePrice())
                .currentPrice(domain.getCurrentPrice())
                .desempenho(domain.getDesempenho())
                .indice(domain.getIndice())
                .quantity(domain.getQuantity())
                .investedAmount(domain.getInvestedAmount())
                .relativePerformance(domain.getRelativePerformance())
                .marketValue(domain.getMarketValue())
                .profit(domain.getProfit())
                .profitPercent(domain.getProfitPercent())
                .purchaseDate(domain.getPurchaseDate())
                .build();
    }

}
