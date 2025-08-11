package ufop.web2.luccas.Investments.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "credit_card")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "credit_card_network_id")
    private CreditCardNetworkModel creditCardNetworkModel;

    private String creditCardNumber;
    private int cvc;
    private String owner;
    private Date expiryDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void antesGravar() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void antesAtualizar() {
        this.updatedAt = LocalDateTime.now();
    }

}
