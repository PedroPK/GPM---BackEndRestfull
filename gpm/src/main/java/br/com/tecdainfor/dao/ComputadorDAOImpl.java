package br.com.tecdainfor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.Setor;

@Repository
public class ComputadorDAOImpl implements ComputadorDAO{

	
	private static final Query Query = null;
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	
	@Override
	@javax.transaction.Transactional
	public Computador cadastrarComputador(Computador computador){
		return manager.merge(computador);
	}
	
	
	@Override
	@javax.transaction.Transactional
	public Computador alterarComputador(Computador computador){
		return manager.merge(computador);
				
	}
	
	
	@Override
	@javax.transaction.Transactional
	public Computador consultarComputador(int id){
		return manager.find(Computador.class, id);
	}
	

	@Override
	@javax.transaction.Transactional
	public Setor consultarSetor(int id){
		return manager.find(Setor.class, id);
	}
	
	
	@Override
	@javax.transaction.Transactional
	public List<Computador> listaCompSetor(String setor){
		List<Computador> computador =  manager.createQuery(" SELECT u FROM Computador u WHERE u.setor LIKE '" + setor + "%'").getResultList();		
		return computador;
	}
	

	@Override
	@javax.transaction.Transactional
	public List<Setor> listaSetor() {
		return manager.createQuery("SELECT u FROM Setor u ORDER BY u.nome", Setor.class).getResultList();
	}

	
	
	@Override
	@javax.transaction.Transactional
	public Computador excluir(int id) {
		
		Computador computador = this.consultarComputador(id);
		manager.remove(computador);
		return computador;
		
	}
	
	
	@Override
	@javax.transaction.Transactional
	public List<Computador> listarComputadores(){
		List<Computador> lista = manager.createQuery("SELECT u FROM Computador u ORDER BY u.id", Computador.class).getResultList();
	
		return lista;
	}

}
