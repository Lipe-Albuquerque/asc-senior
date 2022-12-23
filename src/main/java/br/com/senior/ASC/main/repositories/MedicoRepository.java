package br.com.senior.ASC.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senior.ASC.main.model.Medico;
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
	@Query("SELECT obj FROM Medico obj WHERE obj.cpf =:cpf")
	Medico findByCPF(@Param("cpf") String cpf);
	

    List<Medico> findBySpecialtyEquals(String categoria);

}
