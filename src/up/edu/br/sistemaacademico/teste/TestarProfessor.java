package up.edu.br.sistemaacademico.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.edu.br.sistemaacademico.dao.ProfessorDao;
import up.edu.br.sistemaacademico.entidades.Professor;
import up.edu.br.sistemaacademico.servico.ProfessorServico;
import up.edu.br.sistemaacademico.servico.ServicoException;

@FixMethodOrder(MethodSorters.JVM)
public class TestarProfessor {


	static long id;
	
	@Test
	public void deveriaCadastrarUmProfessor() {
		Professor t = new Professor();
		t.setId(null);
		t.setNome("Cleverson");
		t.setCodFuncional("4321");
		
		try {
			new ProfessorServico().adicionar(t);			
		}catch (ServicoException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, t.getId() != null);
		id = t.getId();
	}
	
	
	@Test
	public void deveriaListarProfessor() {
		List<Professor> professores = new ProfessorDao().listar();
		
		assertEquals(true, professores.size() >0);
	}
	
	
	@Test
	public void deveriaAlterarUmProfessor() {
		Professor t = new ProfessorServico().buscar(id);
		
		t.setNome("Claudio");
		
		try {
			new ProfessorServico().adicionar(t);
			
		}catch (ServicoException e){
			e.printStackTrace();			
		}
		
		t = new ProfessorServico().buscar(id);
		assertEquals(true, t.getNome().equals("Claudio"));
		
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
