package ufop.web2.luccas.Investments.dtos.user;

import lombok.Builder;
import java.util.UUID;

@Builder
public record SimpleUserRecordDTO(
        UUID id,
        String name,
        String email,
        String phone
) {

}
