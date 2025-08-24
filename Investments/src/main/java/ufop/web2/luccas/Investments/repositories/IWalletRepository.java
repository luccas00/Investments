package ufop.web2.luccas.Investments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ufop.web2.luccas.Investments.models.WalletModel;

import java.util.UUID;

public interface IWalletRepository extends JpaRepository<WalletModel, UUID> { }
