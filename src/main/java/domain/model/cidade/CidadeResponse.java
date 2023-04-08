package domain.model.cidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CidadeResponse {
    private String id;
    private String nome;
    private String sigla;
    private Boolean situacao;
}
