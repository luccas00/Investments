package ufop.web2.luccas.Investments.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "wallet")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    private float amount;
    private float balance;
    private float desempenho;

    // --- Novos agregados derivados (autocalculados) ---
    private float totalQuantity;      // soma das quantities
    private float totalInvested;      // soma investedAmount
    private float totalMarketValue;   // soma marketValue
    private float totalProfit;        // soma profit
    private float totalProfitPercent; // (totalProfit / totalInvested)*100

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvestmentModel> investments = new ArrayList<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    private static float nz(Float v){ return v == null ? 0f : v; }
    private static float round2(float v){ return (float)Math.round(v * 100.0f)/100.0f; }

    /** Recalcula agregados com base nos filhos. Chame antes de salvar a Wallet. */
    public void recalcAggregates() {
        float q=0f, inv=0f, mkt=0f, pl=0f;
        if (investments != null) {
            for (InvestmentModel it : investments) {
                if (it == null) continue;
                // Usa valores já recalculados pelos callbacks do filho
                q   += nz(it.getQuantity());
                inv += nz(it.getInvestedAmount());
                mkt += nz(it.getMarketValue());
                pl  += nz(it.getProfit());
            }
        }
        totalQuantity    = round2(q);
        totalInvested    = round2(inv);
        totalMarketValue = round2(mkt);
        totalProfit      = round2(pl);
        totalProfitPercent = totalInvested > 0f ? round2((totalProfit / totalInvested) * 100f) : 0f;

        desempenho = totalProfitPercent; // mantém compatibilidade com seu campo
    }

    @PrePersist
    public void prePersist() {
        recalcAggregates();
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        recalcAggregates();
        updatedAt = LocalDateTime.now();
    }
}
