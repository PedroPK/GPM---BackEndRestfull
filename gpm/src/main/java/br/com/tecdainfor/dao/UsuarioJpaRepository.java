package br.com.tecdainfor.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tecdainfor.dao.UsuarioDAO;
import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.ResponseModel;
import br.com.tecdainfor.model.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Long>, UsuarioDAO{

	

	@Query("Select u from Computador u")
	Collection<Computador> findAllComputadores();

	@Query("SELECT u FROM Usuario u WHERE u.nome LIKE =?1")
	List<Usuario> findByName(String nome);

	
	
}
