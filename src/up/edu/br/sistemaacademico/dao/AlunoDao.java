package up.edu.br.sistemaacademico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Professor;

public class AlunoDao implements Dao<Aluno> {
	
	public void adicionar(Aluno aluno) {
		EntityManager em = Conexao.getInstance().createEntityManager();		
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public void editar(Aluno aluno) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
	}
	
	public void excluir(Aluno aluno) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(aluno));
		em.getTransaction().commit();
		
	}
	
	public List<Aluno> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select a from Aluno a");
		return q.getResultList();
	}

	@Override
	public Aluno buscarPorId(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		return em.find(Aluno.class, id);
	}

	@Override
	public Aluno buscar(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		return em.find(Aluno.class, id);
	}

	@Override
	public Professor buscarProf(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
