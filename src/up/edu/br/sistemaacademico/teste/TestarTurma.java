package up.edu.br.sistemaacademico.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.edu.br.sistemaacademico.dao.AlunoDao;
import up.edu.br.sistemaacademico.dao.TurmaDao;
import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Turma;
import up.edu.br.sistemaacademico.servico.AlunoServico;
import up.edu.br.sistemaacademico.servico.ServicoException;
import up.edu.br.sistemaacademico.servico.TurmaServico;

@FixMethodOrder(MethodSorters.JVM)
public class TestarTurma {
		
static long id;
	
	@Test
	public void deveriaCadastrarUmaTurma() {
		Turma turma = new Turma();
		turma.setId(null);
		turma.setNome ("Arquitetura de Software");
	
		try {
			new TurmaServico().adicionar(turma);
		} catch (ServicoException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, turma.getId() != null);
		id = turma.getId();
	}
	
	@Test
	public void deveriaListarTurmas() {
		List<Turma> turmas = new TurmaDao().listar();
		
		assertEquals(true, turmas.size() > 0);
	}
	
	
	
	@Test
	public void deveriaAlterarUmaTurma() {
		
		Turma turma = new TurmaServico().buscar(id);
		
		turma.setNome("ABC");
		
		try {
			new TurmaServico().adicionar(turma);
		} catch (ServicoException e) {			
			e.printStackTrace();
		}
		
		turma = new TurmaServico().buscar(id);
		
		assertEquals(true,turma.getNome().equals("ABC"));
		
	}

	
	
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		//Factory
		
		///java 1.4
		Calendar c = Calendar.getInstance();	//new GregorianAdvanced();
		c.setTime(d);
		
		///java > 1.4
		//Calendar c = Calendar.getInstance();//new GregorianCalendar();
		//c.setTime(d);
		
		c.add(Calendar.DAY_OF_MONTH,2);
		System.out.println(c.getTime());
				
	}
	
	
	
	

}
