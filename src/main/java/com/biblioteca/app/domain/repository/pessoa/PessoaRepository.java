package com.biblioteca.app.domain.repository.pessoa;

import com.biblioteca.app.domain.core.repository.BaseRepository;
import com.biblioteca.app.domain.entity.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends BaseRepository<Pessoa> {

    Boolean existsByCpf(String cpf);

    Boolean existsByEmail(String email);
}
