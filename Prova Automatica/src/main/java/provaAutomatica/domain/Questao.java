package provaAutomatica.domain;

import java.io.Serializable;

import javax.persistence.*;


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