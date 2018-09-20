package up.edu.br.sistemaacademico.servico;

import java.util.List;

import up.edu.br.sistemaacademico.dao.Dao;
import up.edu.br.sistemaacademico.dao.FabricaDao;
import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Turma;


public class TurmaServico {

	Dao<Turma> TurmaDao = FabricaDao.createDaoTurma();
	
	public void adicionar (Turma turma) throws ServicoException {
		if (turma.getNome().isEmpty()) {
			throw new ServicoException("O campo turma"
					+ "não pode ser vazio.");
		}		
		Dao<Turma> turmaDao = FabricaDao.createDaoTurma();
		TurmaDao.adicionar(turma);		
	}

	public Turma buscar(long id) {
		// TODO Auto-generated method stub
		Dao<Turma> turmaDao = FabricaDao.createDaoTurma();
		return turmaDao.buscarPorId(id);	
	}	
	
	
	public List<Turma> listar(){
		return TurmaDao.listar();
	}
	
	
	public void editar(Turma turma) throws ServicoException {
		if (turma.getNome() == null) {
			throw new ServicoException("O campo nome "	+ "não pode ser vazio.");
		}		
		
		Dao<Turma> turmaDao = FabricaDao.createDaoTurma();
			TurmaDao.editar(turma);
	}
	
	
	
	
	
	
	
}
