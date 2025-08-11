package ufop.web2.luccas.Investments.domains;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardNetworkDomain {

    private UUID id;
    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
