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
import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.servico.AlunoServico;
import up.edu.br.sistemaacademico.servico.ServicoException;


@FixMethodOrder(MethodSorters.JVM)
public class TestarAluno {
	
	static long id;
	
	@Test
	public void deveriaCadastrarUmAluno() {
		Aluno a = new Aluno();
		a.setId(null);
		a.setNome("Cleverson");
		a.setMatricula("12345");
		
		try {
			new AlunoServico().adicionar(a);
		} catch (ServicoException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, a.getId() != null);
		id = a.getId();
	}
	
	@Test
	public void deveriaListarAlunos() {
		List<Aluno> alunos = new AlunoDao().listar();
		
		assertEquals(true, alunos.size() > 0);
	}
	
	
	
	@Test
	public void deveriaAlterarUmAluno() {
		
		Aluno a = new AlunoServico().buscar(id);
		
		a.setNome("ABC");
		
		try {
			new AlunoServico().adicionar(a);
		} catch (ServicoException e) {			
			e.printStackTrace();
		}
		
		a = new AlunoServico().buscar(id);
		
		assertEquals(true,a.getNome().equals("ABC"));
		
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
