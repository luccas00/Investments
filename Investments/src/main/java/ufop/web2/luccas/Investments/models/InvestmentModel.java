package ufop.web2.luccas.Investments.models;

import jakarta.persistence.*;
import lombok.*;
import ufop.web2.luccas.Investments.enums.EnumInvestmentType;
import ufop.web2.luccas.Investments.enums.EnumInvestmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "investments")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    private EnumInvestmentType type;
    private EnumInvestmentStatus status;

    private String symbol;

    private float quantity;
    private float purchasePrice;

    private LocalDateTime purchaseDate = LocalDateTime.now();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void antesGravar() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void antesAtualizar(){
        this.updatedAt = LocalDateTime.now();
    }


}
