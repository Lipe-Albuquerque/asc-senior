package br.com.senior.ASC.main.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senior.ASC.main.model.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

	Page<Paciente> findBySymptoms(String sintoma, Pageable pageable);
		
}
