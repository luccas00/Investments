package ufop.web2.luccas.Investments.dtos.investment;

import ufop.web2.luccas.Investments.dtos.user.SimpleUserRecordDTO;
import ufop.web2.luccas.Investments.enums.EnumInvestmentStatus;
import ufop.web2.luccas.Investments.enums.EnumInvestmentType;

import java.time.LocalDateTime;
import java.util.UUID;

public record InvestmentRecordDTO (

        UUID id,
        SimpleUserRecordDTO user,
        EnumInvestmentType type,
        EnumInvestmentStatus status,
        String symbol,
        float quantity,
        float purchasePrice,
        LocalDateTime purchaseDate

) {
}
