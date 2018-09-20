package up.edu.br.sistemaacademico.servico;

import java.util.List; 

import up.edu.br.sistemaacademico.dao.Dao;
import up.edu.br.sistemaacademico.dao.FabricaDao;
import up.edu.br.sistemaacademico.entidades.Professor;
import up.edu.br.sistemaacademico.dao.ProfessorDao;


public class ProfessorServico {

Dao<Professor> ProfessorDao = FabricaDao.createDaoProfessor();
		
	public void adicionar(Professor t) throws ServicoException{
		if (t.getCodFuncional() == null) {
			throw new ServicoException("O campo codigo funcional" + "não pode ser vazio.");
		}
		Dao<Professor> professorDao = FabricaDao.createDaoProfessor();
		ProfessorDao.adicionar(t);
	}
	
	
	public Professor buscar(long id) {
		Dao<Professor> ProfessorDao = FabricaDao.createDaoProfessor();
		return ProfessorDao.buscarPorId(id);
	}

	
	public List<Professor> listar(){
		return ProfessorDao.listar();
	}
	
	
	public void editar(Professor t) throws ServicoException {
		if (t.getCodFuncional() == null) {
			throw new ServicoException("O campo codigo funcional "	+ "não pode ser vazio.");
		}		
		Dao<Professor> professorDao = FabricaDao.createDaoProfessor();
				ProfessorDao.editar(t);
	}	
	
	
	
}
