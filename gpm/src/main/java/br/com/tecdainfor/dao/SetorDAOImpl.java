package br.com.tecdainfor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.Setor;
import br.com.tecdainfor.model.Usuario;

@Repository
public class SetorDAOImpl implements SetorDAO {
	
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	
	
	@Override
	@javax.transaction.Transactional
	public Setor cadastrarSetor(Setor setor) {
		return manager.merge(setor);
		
	}

	@Override
	@javax.transaction.Transactional
	public Setor alterarSetor(Setor setor) {
		return manager.merge(setor);
	}

	@Override
	@javax.transaction.Transactional
	public Setor consultarSetor(int id) {
		return manager.find(Setor.class, id);
	}
	

	@Override
	@javax.transaction.Transactional
	public Setor excluir(int id) {
		Setor setor = this.consultarSetor(id);
		 manager.remove(setor);
		 return setor;
	}

	@Override
	@javax.transaction.Transactional
	public List<Setor> listarSetores() {
		return manager.createQuery("SELECT u FROM Setor u ORDER BY u.nome", Setor.class).getResultList();
	}

}
