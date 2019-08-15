package br.com.tecdainfor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import br.com.tecdainfor.model.Impressora;

@Repository
public class ImpressoraDAOImpl implements  ImpressoraDAO{

	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	@javax.transaction.Transactional
	public Impressora cadastrarImpressora(Impressora impressora){
		return manager.merge(impressora);
	}
	
	@javax.transaction.Transactional
	public Impressora alterarImpressora(Impressora impressora){
		return manager.merge(impressora);
				
	}
	
	@javax.transaction.Transactional
	public Impressora consultarImpressora(int id){
		return manager.find(Impressora.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@javax.transaction.Transactional
	public List<Impressora> listarImpSetor(String nome){
		return manager.createQuery(" SELECT u FROM Impressora u WHERE u.setor = nome ").getResultList();
		
	}
	
	@javax.transaction.Transactional
	public Impressora excluir(int id) {
		// TODO Auto-generated method stub
		Impressora impressora = this.consultarImpressora(id);
		manager.remove(impressora);
		return impressora;
		//porque esse metodo retorna um monitor?
	}
	
	@javax.transaction.Transactional
	public List<Impressora> listarImpressoras(){
		return manager.createQuery("SELECT u FROM Impressora u ORDER BY u.modelo", Impressora.class).getResultList();
	}
	
}
