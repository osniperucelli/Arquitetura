package up.edu.br.sistemaacademico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Professor;
import up.edu.br.sistemaacademico.entidades.Turma;

public class TurmaDao implements Dao<Turma> {

	@Override
	public void adicionar(Turma turma) {
		EntityManager em = Conexao.getInstance().createEntityManager();		
		em.getTransaction().begin();
		em.persist(turma);
		em.getTransaction().commit();		
	}
	
	
	@Override
	public void editar(Turma turma) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		 em.merge(turma);
		 em.getTransaction().commit();		
	}
	
	
	@Override
	public void excluir(Turma turma) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Turma.class, turma.getId()));
		em.getTransaction().commit();		
	}
	
	@Override
	public List<Turma> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select a from Turma a");
		return q.getResultList();
	}
	
	@Override
	public Turma buscarPorId(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		return em.find(Turma.class, id);
	}

	

	@Override
	public Aluno buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Professor buscarProf(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
