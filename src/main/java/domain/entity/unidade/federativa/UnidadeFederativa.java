package domain.entity.unidade.federativa;

import domain.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeFederativa extends BaseEntity {
    @Id
    @Column(name = "ID_UNIDADE_FEDERATIVA", nullable = false, length = 36)
    private String id;
    @Column(name = "NOME", nullable = false, length = 120)
    private String nome;
    @Column(name = "SIGLA", nullable = false, length = 2)
    private String sigla;
    @Column(name = "SITUACAO", nullable = false)
    private Boolean situacao;

}
