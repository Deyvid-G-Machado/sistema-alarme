package com.deyvid.sistema_alarme.repositories;

import com.deyvid.sistema_alarme.models.Historico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoricoRepository extends CrudRepository<Historico, Integer> {
    @Query(value = "SELECT * FROM tb_historico ORDER BY data_hora DESC LIMIT 1", nativeQuery = true)
    public Historico ultimoHistorico();

    @Query(value = "SELECT * FROM tb_historico ORDER BY data_hora DESC", nativeQuery = true)
    public List<Historico> historicosDecrecente();
}
