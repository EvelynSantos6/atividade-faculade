package com.anhembi.eventosUAM.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.anhembi.eventosUAM.model.Evento;
import com.anhembi.eventosUAM.repository.EventoRepository;

@Service
public class EventoService {
    private List<Evento> eventos;
    private final EventoRepository eventoRepository = new EventoRepository();

    public EventoService() {
        this.eventos = eventoRepository.carregar();
        System.out.println("Eventos carregados: " + eventos.size());
        if (!eventos.isEmpty()) {
            System.out.println("Lista de eventos carregados do arquivo:");
            listarTodos();
        }
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    public List<Evento> listarProximos() {
        return eventos.stream()
                .filter(e -> e.getHorario().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(Evento::getHorario))
                .collect(Collectors.toList());
    }

    public List<Evento> listarPorCidade(String cidade) {
        return eventos.stream()
                .filter(e -> e.getCidade().equalsIgnoreCase(cidade))
                .collect(Collectors.toList());
    }

    public List<Evento> listarOcorrendoAgora() {
        LocalDateTime agora = LocalDateTime.now();
        return eventos.stream()
                .filter(e -> e.getHorario().isBefore(agora.plusHours(1)) && e.getHorario().isAfter(agora.minusHours(1)))
                .collect(Collectors.toList());
    }

    public List<Evento> listarConcluidos() {
        return eventos.stream()
                .filter(e -> e.getHorario().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    public void salvarEventos() {
        eventoRepository.salvar(eventos);
    }

    public void listarTodos() {
        eventos.forEach(System.out::println);
    }

    public boolean confirmarParticipacao(String email, String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                if (!evento.getParticipantesEmails().contains(email)) {
                    evento.adicionarParticipante(email);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cancelarParticipacao(String email, String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                if (evento.getParticipantesEmails().contains(email)) {
                    evento.removerParticipante(email);
                    return true;
                }
            }
        }
        return false;
    }
}