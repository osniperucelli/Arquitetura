package up.edu.br.sistemaacademico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Persistence;


import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Professor;
import up.edu.br.sistemaacademico.entidades.Turma;

public class ProfessorDao implements Dao<Professor> {

	@Override
	public void adicionar(Professor t) {
		EntityManager em = Conexao.getInstance().createEntityManager();		
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();		
	}

	@Override
	public void editar(Professor t) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();		
	}

	@Override
	public void excluir(Professor t) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();		
	}

	@Override
	public List<Professor> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select t from Professor t");
		return q.getResultList();
	}

	@Override
	public Professor buscarPorId(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		return em.find(Professor.class, id);
	}

	@Override
	public Professor buscarProf (Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		return em.find(Professor.class, id);
	}

	@Override
	public Aluno buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
