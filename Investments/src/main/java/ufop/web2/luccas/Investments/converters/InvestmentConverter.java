package ufop.web2.luccas.Investments.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ufop.web2.luccas.Investments.domains.AddressDomain;
import ufop.web2.luccas.Investments.domains.InvestmentDomain;
import ufop.web2.luccas.Investments.dtos.address.AddressRecordDTO;
import ufop.web2.luccas.Investments.dtos.address.CreateAddressDTO;
import ufop.web2.luccas.Investments.dtos.investment.CreateInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.investment.UserInvestmentRecordDTO;
import ufop.web2.luccas.Investments.models.AddressModel;
import ufop.web2.luccas.Investments.models.InvestmentModel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvestmentConverter {

    public static InvestmentRecordDTO toInvestmentRecordDTO(InvestmentModel model)
    {
        return new InvestmentRecordDTO(
                model.getId(),
                UserConverter.toSimpleUserRecordDTO(model.getUser()),
                model.getType(),
                model.getStatus(),
                model.getSymbol(),
                model.getQuantity(),
                model.getPurchasePrice(),
                model.getPurchaseDate()
        );
    }

    public static UserInvestmentRecordDTO toUserInvestmentRecordDTO(InvestmentModel model)
    {
        return new UserInvestmentRecordDTO(
                model.getType(),
                model.getStatus(),
                model.getSymbol(),
                model.getQuantity(),
                model.getPurchasePrice(),
                model.getPurchaseDate()
        );
    }

    public static InvestmentDomain toInvestmentDomain(CreateInvestmentDTO dto) {
        return InvestmentDomain.builder()
                .symbol(dto.getSymbol())
                .purchasePrice(dto.getPurchasePrice())
                .quantity(dto.getQuantity())
                .type(dto.getType())
                .status(dto.getStatus())
                .build();
    }

    public static InvestmentModel toInvestmentModel(InvestmentDomain domain) {
        return InvestmentModel.builder()
                .user(UserConverter.toUserModel(domain.getUser()))
                .id(domain.getId())
                .type(domain.getType())
                .status(domain.getStatus())
                .symbol(domain.getSymbol())
                .purchasePrice(domain.getPurchasePrice())
                .quantity(domain.getQuantity())
                .purchaseDate(domain.getPurchaseDate())
                .build();
    }

}
