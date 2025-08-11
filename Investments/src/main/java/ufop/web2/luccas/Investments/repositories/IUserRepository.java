package ufop.web2.luccas.Investments.repositories;

import ufop.web2.luccas.Investments.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    List<UserModel> findByName(String name);
    List<UserModel> findByEmail(String email);
    List<UserModel> findAllByNameContainsIgnoreCase(String name);
}
