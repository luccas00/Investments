package ufop.web2.luccas.Investments.repositories;

import ufop.web2.luccas.Investments.models.CreditCardModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICreditCardRepository extends JpaRepository<CreditCardModel, UUID> {
}
