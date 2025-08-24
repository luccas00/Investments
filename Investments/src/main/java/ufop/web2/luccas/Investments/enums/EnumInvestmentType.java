package ufop.web2.luccas.Investments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumInvestmentType {

    ACAO(1, "Ação"),
    CRIPTO(2, "Cripto"),
    FUNDO(3, "Fundo"),
    RENDA_FIXA(4, "Renda Fixa"),
    OUTRO(5, "Outro");

    private Integer id;
    private String description;

}
