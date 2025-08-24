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
    @JoinColumn(name = "wallet_id")
    private WalletModel wallet;

    private EnumInvestmentType type;
    private EnumInvestmentStatus status;

    private String symbol;

    private float quantity;

    private float purchasePrice;
    private float currentPrice;

    private float desempenho;

    private float indice;

    // --- Novos campos derivados (autocalculados) ---
    private float investedAmount;   // quantity * purchasePrice
    private float marketValue;      // quantity * currentPrice
    private float profit;           // marketValue - investedAmount
    private float profitPercent;    // (profit / investedAmount) * 100
    private float relativePerformance; // desempenho - indice

    private LocalDateTime purchaseDate = LocalDateTime.now();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static float nz(Float v){ return v == null ? 0f : v; }
    private static float round2(float v){ return (float)Math.round(v * 100.0f)/100.0f; }

    private void recalc() {
        float q  = nz(quantity);
        float pp = nz(purchasePrice);
        float cp = nz(currentPrice);

        investedAmount = round2(q * pp);
        marketValue    = round2(q * cp);
        profit         = round2(marketValue - investedAmount);

        profitPercent = investedAmount > 0f ? round2((profit / investedAmount) * 100f) : 0f;

        desempenho = profitPercent;
        relativePerformance = round2(desempenho - nz(indice));
    }

    @PrePersist
    public void prePersist() {
        recalc();
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        recalc();
        updatedAt = LocalDateTime.now();
    }


}
