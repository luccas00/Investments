package ufop.web2.luccas.Investments.dtos.wallet;

import lombok.Builder;
import ufop.web2.luccas.Investments.dtos.investment.WalletInvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.user.SimpleUserRecordDTO;
import ufop.web2.luccas.Investments.models.InvestmentModel;
import ufop.web2.luccas.Investments.models.UserModel;

import java.util.List;
import java.util.UUID;

@Builder
public record WalletRecordDTO (

    UUID id,
    SimpleUserRecordDTO user,
    List<WalletInvestmentRecordDTO> investments

) {
}
