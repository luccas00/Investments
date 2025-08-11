package ufop.web2.luccas.Investments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ufop.web2.luccas.Investments.enums.EnumInvestmentStatus;
import ufop.web2.luccas.Investments.enums.EnumInvestmentType;
import ufop.web2.luccas.Investments.models.InvestmentModel;

import java.util.List;
import java.util.UUID;

public interface IInvestmentRepository extends JpaRepository<InvestmentModel, UUID> {

    List<InvestmentModel> findByType(EnumInvestmentType type);
    List<InvestmentModel> findByStatus(EnumInvestmentStatus status);
}