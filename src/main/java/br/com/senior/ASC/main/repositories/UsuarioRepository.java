package br.com.senior.ASC.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senior.ASC.main.model.Usuario;
@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("SELECT obj FROM user_ obj WHERE obj.cpf =:cpf")
	Usuario findByCPF(@Param("cpf") String cpf);
	
	
	
}
