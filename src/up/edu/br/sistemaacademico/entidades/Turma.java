package up.edu.br.sistemaacademico.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;;


@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonProperty("Nome")
	private String Nome;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "turma", targetEntity = Aluno.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluno> listaDeAlunos;

	public List<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}

	public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", Nome=" + Nome + ", listaDeAlunos=" + listaDeAlunos + "]";
	}

	
		
}
