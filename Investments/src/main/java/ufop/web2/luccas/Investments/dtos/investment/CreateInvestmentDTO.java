package ufop.web2.luccas.Investments.dtos.investment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufop.web2.luccas.Investments.enums.EnumInvestmentStatus;
import ufop.web2.luccas.Investments.enums.EnumInvestmentType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvestmentDTO {

    private UUID wallet;
    private EnumInvestmentType type;
    private EnumInvestmentStatus status;
    private String symbol;
    private float quantity;
    private float purchasePrice;
    private float currentPrice;
    private float indice;
    private float desempenho;

}