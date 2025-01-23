package guru.microservices.mssc_brewery.web.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private UUID id;
    @NotBlank
    @Range(min = 3, max = 100, message = "Name must have between 3 and 100 characters")
    private String name;
}
