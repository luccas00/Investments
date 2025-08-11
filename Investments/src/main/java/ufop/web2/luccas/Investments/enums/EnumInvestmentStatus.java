package ufop.web2.luccas.Investments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumInvestmentStatus {

    EM_ABERTO(1, "Em aberto"),
    EXECUTADO(2, "Executado"),
    PAGO(3, "Pago"),
    CANCELADO(4, "Cancelado"),
    ESTORNADO(5, "Estornado");

    private Integer id;
    private String description;

}
