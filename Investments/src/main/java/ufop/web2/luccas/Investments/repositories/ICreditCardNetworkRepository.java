package ufop.web2.luccas.Investments.repositories;

import ufop.web2.luccas.Investments.models.CreditCardNetworkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICreditCardNetworkRepository extends JpaRepository<CreditCardNetworkModel, UUID> {


}
