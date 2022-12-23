package br.com.senior.ASC.main.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.senior.ASC.main.dtos.AgendamentoDTO;
import br.com.senior.ASC.main.model.Agendamento;

@Repository
@EnableJpaRepositories
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

	public List<AgendamentoDTO> findByDateOpenBefore(LocalDateTime data);

	public List<AgendamentoDTO> findByStatusEquals(Integer status, Pageable paginacao);
		

}
