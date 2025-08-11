package ufop.web2.luccas.Investments.services;

import ufop.web2.luccas.Investments.converters.AddressConverter;
import ufop.web2.luccas.Investments.converters.UserConverter;
import ufop.web2.luccas.Investments.domains.AddressDomain;
import ufop.web2.luccas.Investments.dtos.address.AddressRecordDTO;
import ufop.web2.luccas.Investments.dtos.address.CreateAddressDTO;
import ufop.web2.luccas.Investments.dtos.address.DeleteAddressDTO;
import ufop.web2.luccas.Investments.models.AddressModel;
import ufop.web2.luccas.Investments.models.UserModel;
import ufop.web2.luccas.Investments.repositories.IAddressRepository;
import ufop.web2.luccas.Investments.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService {

    private final IAddressRepository addressRepository;
    private final IUserRepository userRepository;

    public List<AddressRecordDTO> getAllAddresses() {

        List<AddressModel> result = addressRepository.findAll();

        return result.stream().map(AddressConverter::toAddressRecordDTO).toList();

    }

    public AddressRecordDTO createAddress(CreateAddressDTO dto) {

        AddressDomain domain = AddressConverter.toAddresDomain(dto);

        UserModel userModel = userRepository
                .findById(dto.getUser())
                .orElseThrow(() -> new RuntimeException("Credit Card Network não encontrado"));

        domain.setUser(UserConverter.toUserDomain(userModel));

        AddressModel model = AddressConverter.toAddresModel(domain);

        model.setUser(userModel);

        return AddressConverter.toAddressRecordDTO(addressRepository.save(model));

    }

    public void deleteAddress(DeleteAddressDTO dto) {

        Optional<AddressModel> optionalModel = addressRepository.findById(dto.id());

        if (optionalModel.isEmpty()) {
            throw new RuntimeException("Address not found.");
        }

        addressRepository.delete(optionalModel.get());

    }

}
