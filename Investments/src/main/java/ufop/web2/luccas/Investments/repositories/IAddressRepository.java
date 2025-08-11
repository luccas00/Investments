package ufop.web2.luccas.Investments.repositories;

import ufop.web2.luccas.Investments.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAddressRepository extends JpaRepository<AddressModel, UUID> {

}
