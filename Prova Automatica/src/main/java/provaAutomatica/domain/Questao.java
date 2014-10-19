package provaAutomatica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;


/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="questao_id")
	private int questaoId;

	@Length(max=20,message="Valor deve ser menor que 20 caracteres")
	private String conteudo;

	public Questao() {
	}

	public int getQuestaoId() {
		return this.questaoId;
	}

	public void setQuestaoId(int questaoId) {
		this.questaoId = questaoId;
	}

	public String getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}