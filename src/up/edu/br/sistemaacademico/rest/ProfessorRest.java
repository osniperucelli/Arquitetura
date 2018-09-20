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
import up.edu.br.sistemaacademico.dao.Dao;
import up.edu.br.sistemaacademico.dao.FabricaDao;
import up.edu.br.sistemaacademico.dao.ProfessorDao;
import up.edu.br.sistemaacademico.entidades.Professor;
import up.edu.br.sistemaacademico.servico.ProfessorServico;
import up.edu.br.sistemaacademico.servico.ServicoException;


@Path("/professorrest")
@Api(value="/professorrest")
public class ProfessorRest {


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> listar()
	{
		List<Professor> t = new ProfessorDao().listar();
		return t;
	}
	
	
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void adicionar(Professor t) {
			System.out.println(t.toString());
			try {
				new ProfessorServico().adicionar(t);			
			}catch (ServicoException e) {
				e.printStackTrace();
			}
		}
		
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void editar(Professor t) {
			try {
				new ProfessorServico().editar(t);
			}catch (ServicoException e) {
				e.printStackTrace();
			}
		}
		
		
		
		@DELETE
		@Path("{id}")
		@Consumes(MediaType.APPLICATION_JSON)	
		public void excluir (@PathParam("id")Long id){
			try {
				Dao<Professor> professorDao = FabricaDao.createDaoProfessor();
				Professor t = professorDao.buscarPorId(id);
				professorDao.excluir(t);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
