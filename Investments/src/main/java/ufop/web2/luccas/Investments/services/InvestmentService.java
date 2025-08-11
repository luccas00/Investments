package ufop.web2.luccas.Investments.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ufop.web2.luccas.Investments.converters.AddressConverter;
import ufop.web2.luccas.Investments.converters.CreditCardConverter;
import ufop.web2.luccas.Investments.converters.InvestmentConverter;
import ufop.web2.luccas.Investments.converters.UserConverter;
import ufop.web2.luccas.Investments.domains.AddressDomain;
import ufop.web2.luccas.Investments.domains.CreditCardDomain;
import ufop.web2.luccas.Investments.domains.InvestmentDomain;
import ufop.web2.luccas.Investments.domains.UserDomain;
import ufop.web2.luccas.Investments.dtos.address.AddressRecordDTO;
import ufop.web2.luccas.Investments.dtos.address.CreateAddressDTO;
import ufop.web2.luccas.Investments.dtos.address.DeleteAddressDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.CreateCreditCardDTO;
import ufop.web2.luccas.Investments.dtos.creditcard.CreditCardRecordDTO;
import ufop.web2.luccas.Investments.dtos.investment.CreateInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.DeleteInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.user.UserRecordDTO;
import ufop.web2.luccas.Investments.models.*;
import ufop.web2.luccas.Investments.repositories.IInvestmentRepository;
import ufop.web2.luccas.Investments.repositories.IUserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InvestmentService {

    private final IUserRepository userRepository;
    private final IInvestmentRepository investmentRepository;

    public List<InvestmentRecordDTO> getAllInvestments() {

        List<InvestmentModel> result = investmentRepository.findAll();

        return result.stream().map(InvestmentConverter::toInvestmentRecordDTO).toList();

    }

    public InvestmentRecordDTO getInvestmentById(String id) {

        UUID uuid = UUID.fromString(id);

        Optional<InvestmentModel> optionalModel = investmentRepository.findById(uuid);

        if (optionalModel.isEmpty()) {
            return null;
        }

        InvestmentModel model = optionalModel.get();

        return InvestmentConverter.toInvestmentRecordDTO(model);

    }

    public InvestmentRecordDTO createInvestment(CreateInvestmentDTO dto) {

        InvestmentDomain domain = InvestmentConverter.toInvestmentDomain(dto);

        Optional<UserModel> optionalUserModel = userRepository.findById(dto.getUser());
        if (optionalUserModel.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        UserModel userModel = optionalUserModel.get();

        InvestmentModel model = InvestmentModel.builder()
                .user(userModel)
                .type(dto.getType())
                .status(dto.getStatus())
                .symbol(dto.getSymbol())
                .quantity(dto.getQuantity())
                .purchasePrice(dto.getPurchasePrice())
                .purchaseDate(LocalDateTime.now())
                .build();

        userModel.getInvestments().add(model);

        InvestmentModel saved = investmentRepository.save(model);

        return InvestmentConverter.toInvestmentRecordDTO(saved);

    }


    public void deleteInvestment(DeleteInvestmentDTO dto) {

        Optional<InvestmentModel> optionalModel = investmentRepository.findById(dto.id());

        if (optionalModel.isEmpty()) {
            throw new RuntimeException("Investment not found.");
        }

        investmentRepository.delete(optionalModel.get());

    }
}
