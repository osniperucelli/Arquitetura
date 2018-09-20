package up.edu.br.sistemaacademico.dao;

import java.util.List;

import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Professor;

public interface Dao<T> {

	public void adicionar(T t);

	public void editar(T t);

	public void excluir(T t);

	public List<T> listar();
	
	public T buscarPorId(Long id);

	Aluno buscar(Long id);

	Professor buscarProf(Long id);

}
