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

import io.swagger.annotations.Api;
import up.edu.br.sistemaacademico.dao.Dao;
import up.edu.br.sistemaacademico.dao.FabricaDao;
import up.edu.br.sistemaacademico.dao.TurmaDao;
import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.entidades.Turma;
import up.edu.br.sistemaacademico.servico.AlunoServico;
import up.edu.br.sistemaacademico.servico.ServicoException;
import up.edu.br.sistemaacademico.servico.TurmaServico;


@Path("/turmarest/")
@Api(value="/turmarest/")
public class TurmaRest {

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Turma> listar()
	{
		List<Turma> turmas = new TurmaDao().listar();
		return turmas;
	}
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void adicionar(Turma turma)
	{
		System.out.println(turma.toString());
		try {
			new TurmaServico().adicionar(turma);
		}catch (ServicoException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Turma turma) {
		try {
			new TurmaServico().editar(turma);
		}catch (ServicoException e) {
			e.printStackTrace();
		}	
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@PathParam("id")Long id) {
		try {
			Dao<Turma> turmaDao = FabricaDao.createDaoTurma();
			Turma turma = turmaDao.buscarPorId(id);
			turmaDao.excluir(turma);			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}	
	
}
