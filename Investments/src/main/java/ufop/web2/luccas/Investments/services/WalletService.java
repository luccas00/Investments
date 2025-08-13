package ufop.web2.luccas.Investments.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ufop.web2.luccas.Investments.converters.InvestmentConverter;
import ufop.web2.luccas.Investments.converters.WalletConverter;
import ufop.web2.luccas.Investments.domains.InvestmentDomain;
import ufop.web2.luccas.Investments.domains.WalletDomain;
import ufop.web2.luccas.Investments.dtos.investment.CreateInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.DeleteInvestmentDTO;
import ufop.web2.luccas.Investments.dtos.investment.InvestmentRecordDTO;
import ufop.web2.luccas.Investments.dtos.wallet.CreateWalletDTO;
import ufop.web2.luccas.Investments.dtos.wallet.DeleteWalletDTO;
import ufop.web2.luccas.Investments.dtos.wallet.WalletRecordDTO;
import ufop.web2.luccas.Investments.models.InvestmentModel;
import ufop.web2.luccas.Investments.models.UserModel;
import ufop.web2.luccas.Investments.models.WalletModel;
import ufop.web2.luccas.Investments.repositories.IInvestmentRepository;
import ufop.web2.luccas.Investments.repositories.IUserRepository;
import ufop.web2.luccas.Investments.repositories.IWalletRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletService {

    private final IUserRepository userRepository;
    private final IWalletRepository walletRepository;
    private final IInvestmentRepository investmentRepository;

    public List<WalletRecordDTO> getAllWallets() {

        List<WalletModel> wallets = walletRepository.findAll();

        return wallets.stream().map(WalletConverter::toWalletRecordDTO).toList();

    }

    public WalletRecordDTO getWalletById(String id) {

        UUID uuid = UUID.fromString(id);

        Optional<WalletModel> optionalModel = walletRepository.findById(uuid);

        if (optionalModel.isEmpty()) {
            return null;
        }

        WalletModel model = optionalModel.get();

        return WalletConverter.toWalletRecordDTO(model);

    }

    public WalletRecordDTO createWallet(CreateWalletDTO dto) {

        WalletDomain domain = new WalletDomain();

        Optional<UserModel> optionalUserModel = userRepository.findById(dto.getUser());
        if (optionalUserModel.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        UserModel userModel = optionalUserModel.get();

        WalletModel wallet = WalletModel.builder()
                .user(userModel)
                .build();

        userModel.getWallets().add(wallet);

        WalletModel saved = walletRepository.save(wallet);

        return WalletConverter.toWalletRecordDTO(saved);

    }


    public void deleteWallet(DeleteWalletDTO dto) {

        Optional<WalletModel> optionalModel = walletRepository.findById(dto.id());

        if (optionalModel.isEmpty()) {
            throw new RuntimeException("Wallet not found.");
        }

        walletRepository.delete(optionalModel.get());

    }

}
