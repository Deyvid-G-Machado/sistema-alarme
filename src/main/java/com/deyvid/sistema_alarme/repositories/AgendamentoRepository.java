package com.deyvid.sistema_alarme.repositories;

import com.deyvid.sistema_alarme.models.Agendamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgendamentoRepository extends CrudRepository<Agendamento, Integer> {
    @Query(value = "SELECT * FROM tb_agendamentos ORDER BY data_hora DESC", nativeQuery = true)
    public List<Agendamento> agendamentosDecrecente();
}
