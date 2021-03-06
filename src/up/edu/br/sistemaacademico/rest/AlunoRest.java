package up.edu.br.sistemaacademico.rest;

import java.util.List;   

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apiguardian.api.API;

import io.swagger.annotations.Api;
import up.edu.br.sistemaacademico.dao.AlunoDao;
import up.edu.br.sistemaacademico.dao.Dao;
import up.edu.br.sistemaacademico.dao.FabricaDao;
import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.servico.AlunoServico;
import up.edu.br.sistemaacademico.servico.ServicoException;


//http://localhost:8080/rest/alunorest

@Path("/alunorest")
@Api(value="/alunorest")
public class AlunoRest {


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> listar()
	{
		List<Aluno> alunos = new AlunoDao().listar();
			return alunos;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void adicionar(Aluno aluno) {
		try {
			new AlunoServico().adicionar(aluno);
		}catch (ServicoException e) {
			e.printStackTrace();
		}
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Aluno aluno) {
		try {
			new AlunoServico().editar(aluno);
		}catch (ServicoException e) {
			e.printStackTrace();
		}	
	}

	
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON) // FORM_URLENCODED)
	public void excluir(@PathParam("id")Long id) {
		try {
			Dao<Aluno> alunoDao = FabricaDao.createDaoAluno();
			Aluno aluno = alunoDao.buscarPorId(id);
			alunoDao.excluir(aluno);			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
}
