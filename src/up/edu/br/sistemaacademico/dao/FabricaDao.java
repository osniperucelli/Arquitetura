package up.edu.br.sistemaacademico.dao;

import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Professor;
import up.edu.br.sistemaacademico.entidades.Turma;

public class FabricaDao {
	
	public static Dao<Aluno> createDaoAluno() {
		return new AlunoDao();
	}

	
	public static Dao<Professor> createDaoProfessor() {
		return new ProfessorDao();
	}

	
	public static Dao<Turma> createDaoTurma()	{
		return new TurmaDao();
	}
	
}
