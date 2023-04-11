package com.biblioteca.app.domain.repository.cidade;

import com.biblioteca.app.domain.core.repository.BaseRepository;
import com.biblioteca.app.domain.entity.Cidade;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends BaseRepository<Cidade> {
    List<Cidade> getByUnidadeFederativaId(String id, Sort sort);
}
