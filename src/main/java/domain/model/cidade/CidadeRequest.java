package domain.model.cidade;

import domain.shared.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CidadeRequest {
    @Required
    private String nome;
    @Required
    private String sigla;
    @Builder.Default
    private Boolean situacao = Boolean.TRUE;
}
