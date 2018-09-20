package up.edu.br.sistemaacademico.servico;

import java.util.List;

import up.edu.br.sistemaacademico.dao.AlunoDao;
import up.edu.br.sistemaacademico.dao.Dao;
import up.edu.br.sistemaacademico.dao.FabricaDao;
import up.edu.br.sistemaacademico.entidades.Aluno;


	
	public class AlunoServico {
		
		Dao<Aluno> AlunoDao = FabricaDao.createDaoAluno();
		
		public void adicionar(Aluno aluno) throws ServicoException {
			if (aluno.getMatricula() == null) {
				throw new ServicoException("O campo matricula " + "não pode ser vazio.");
			}		
			Dao<Aluno> alunoDao = FabricaDao.createDaoAluno();
			AlunoDao.adicionar(aluno);
		}


		public Aluno buscar(long id) {
			return AlunoDao.buscar(id);
		}
	
		
		public List<Aluno> listar(){
			return AlunoDao.listar();
		}
		
		
		public void editar(Aluno aluno) throws ServicoException {
			if (aluno.getMatricula() == null) {
				throw new ServicoException("O campo matricula "	+ "não pode ser vazio.");
			}		
			
			Dao<Aluno> alunoDao = FabricaDao.createDaoAluno();
 			AlunoDao.editar(aluno);
		}
		
			
	}