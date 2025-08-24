package ufop.web2.luccas.Investments.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ufop.web2.luccas.Investments.domains.InvestmentDomain;
import ufop.web2.luccas.Investments.domains.WalletDomain;
import ufop.web2.luccas.Investments.dtos.investment.CreateInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.investment.WalletInvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.wallet.CreateWalletDTO;
import ufop.web2.luccas.Investments.dtos.wallet.UserWalletRecordDTO;
import ufop.web2.luccas.Investments.dtos.wallet.WalletIDRecordDTO;
import ufop.web2.luccas.Investments.dtos.wallet.WalletRecordDTO;
import ufop.web2.luccas.Investments.models.InvestmentModel;
import ufop.web2.luccas.Investments.models.WalletModel;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WalletConverter {

    public static WalletRecordDTO toWalletRecordDTO(WalletModel model)
    {
        return WalletRecordDTO.builder()
                .id(model.getId())
                .user(UserConverter.toSimpleUserRecordDTO(model.getUser()))
                .desempenho(model.getDesempenho())
                .amount(model.getAmount())
                .balance(model.getBalance())
                .investments(model.getInvestments() != null
                        ? model.getInvestments().stream()
                        .map(InvestmentConverter::toWalletInvestmentRecordDTO)
                        .toList()
                        : new ArrayList<>())
                .build();
    }

    public static WalletIDRecordDTO toWalletIDRecordDTO(WalletModel model)
    {
        return new WalletIDRecordDTO(
                model.getId(),
                model.getAmount(),
                model.getBalance(),
                model.getDesempenho(),
                model.getTotalQuantity(),
                model.getTotalInvested(),
                model.getTotalMarketValue(),
                model.getTotalProfit(),
                model.getTotalProfitPercent()
        );
    }

    public static UserWalletRecordDTO toUserWalletRecordDTO(WalletModel model)
    {
        return UserWalletRecordDTO.builder()
                .id(model.getId())
                .desempenho(model.getDesempenho())
                .amount(model.getAmount())
                .balance(model.getBalance())
                .investments(model.getInvestments() != null
                        ? model.getInvestments().stream()
                        .map(InvestmentConverter::toWalletInvestmentRecordDTO)
                        .toList()
                        : new ArrayList<>())
                .build();

    }

    public static WalletModel toWalletModel(WalletDomain domain) {
        return WalletModel.builder()
                .user(UserConverter.toUserModel(domain.getUser()))
                .desempenho(domain.getDesempenho())
                .amount(domain.getAmount())
                .balance(domain.getBalance())
                .investments(domain.getInvestments() != null
                        ? domain.getInvestments().stream()
                        .map(InvestmentConverter::toInvestmentModel)
                        .toList()
                        : new ArrayList<>())
                .id(domain.getId())
                .build();
    }

}
