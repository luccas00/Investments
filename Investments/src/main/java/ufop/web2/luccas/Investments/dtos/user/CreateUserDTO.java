package ufop.web2.luccas.Investments.dtos.user;

import ufop.web2.luccas.Investments.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    private String name;
    private EnumUserStatus status;
    private EnumUserType userType;
    private String email;
    private String password;
    private String cpf;
    private String cep;
    private String phone;
    private LocalDateTime dateOfBirth;

}
