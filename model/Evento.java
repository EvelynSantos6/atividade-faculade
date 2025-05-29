package com.anhembi.eventosUAM.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String endereco;
	private String categoria;
	private LocalDateTime horario;
	private String descricao;
	private String cidade;
	private List<String> participantesEmails = new ArrayList<>();
	
	public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public LocalDateTime getHorario() { return horario; }
    public void setHorario(LocalDateTime horario) { this.horario = horario; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public List<String> getParticipantesEmails() { return participantesEmails; }
    public void adicionarParticipante(String email) { this.participantesEmails.add(email); }
    public void removerParticipante(String email) { this.participantesEmails.remove(email); }

    @Override
    public String toString() {
        return "Evento: " + nome + " | Categoria: " + categoria + " | Horário: " + horario +
               " | Endereço: " + endereco + " | Cidade: " + cidade +
               " | Participantes: " + participantesEmails.size();
    }
}

