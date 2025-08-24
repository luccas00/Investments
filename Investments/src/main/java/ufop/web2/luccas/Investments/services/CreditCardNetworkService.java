package ufop.web2.luccas.Investments.services;

import ufop.web2.luccas.Investments.converters.CreditCardNetworkConverter;
import ufop.web2.luccas.Investments.domains.CreditCardNetworkDomain;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.CreateCreditCardNetworkDTO;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.CreditCardNetworkRecordDTO;
import ufop.web2.luccas.Investments.dtos.creditcardnetwork.DeleteCreditCardNetworkDTO;
import ufop.web2.luccas.Investments.models.CreditCardNetworkModel;
import ufop.web2.luccas.Investments.repositories.ICreditCardNetworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreditCardNetworkService {

    private final ICreditCardNetworkRepository creditCardNetworkRepository;

    // Get all
    public List<CreditCardNetworkRecordDTO> getAll() {

        List<CreditCardNetworkModel> creditCardNetworkModelList
                = creditCardNetworkRepository.findAll();

        return creditCardNetworkModelList
                .stream()
                .map(CreditCardNetworkConverter::toSimpleCreditCardNetworkDTO)
                .toList();

    }

    // Create
    public CreditCardNetworkRecordDTO create(
            CreateCreditCardNetworkDTO createCreditCardNetworkDTO) {

        CreditCardNetworkDomain domain =
                CreditCardNetworkConverter
                        .toCreditCardNetworkDomain(createCreditCardNetworkDTO);

        // Use cases - validações conforme as regras de negócio
        // name não pode ser nulo; name não pode repetir, ...

        CreditCardNetworkModel model =
                CreditCardNetworkConverter.toCreditCardNetworkModel(domain);


        return CreditCardNetworkConverter.toSimpleCreditCardNetworkDTO(
                creditCardNetworkRepository.save(model)
        );

    }

    // Get by id
    public CreditCardNetworkRecordDTO getCNNById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<CreditCardNetworkModel> optionalCNNModel = creditCardNetworkRepository.findById(uuid);

        if (optionalCNNModel.isEmpty()) {
            return null;
        }

        CreditCardNetworkModel cnnModel = optionalCNNModel.get();
        return CreditCardNetworkConverter.toSimpleCreditCardNetworkDTO(cnnModel);

    }

    // Delete
    public void deleteCreditCardNetwork(DeleteCreditCardNetworkDTO dto) {

        Optional<CreditCardNetworkModel> optionalCCNModel = creditCardNetworkRepository
                .findById(dto.id());

        if (optionalCCNModel.isEmpty()) {
            throw new RuntimeException("Credit Card Network not found.");
        }

        creditCardNetworkRepository.delete(optionalCCNModel.get());

    }

}
