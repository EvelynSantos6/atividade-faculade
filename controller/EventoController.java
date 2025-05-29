package com.anhembi.eventosUAM.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.anhembi.eventosUAM.model.Evento;
import com.anhembi.eventosUAM.service.EventoService;

@Component
public class EventoController {

    @Autowired
    private EventoService eventoService;

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Evento");
            System.out.println("2 - Listar Eventos Próximos");
            System.out.println("3 - Listar Eventos da Minha Cidade");
            System.out.println("4 - Listar Eventos Ocorrendo Agora");
            System.out.println("5 - Listar Eventos Concluídos");
            System.out.println("6 - Confirmar Participação");
            System.out.println("7 - Cancelar Participação");
            System.out.println("8 - Sair e Salvar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarEvento(scanner);
                case 2 -> eventoService.listarProximos().forEach(System.out::println);
                case 3 -> listarEventosPorCidade(scanner);
                case 4 -> eventoService.listarOcorrendoAgora().forEach(System.out::println);
                case 5 -> eventoService.listarConcluidos().forEach(System.out::println);
                case 6 -> confirmarParticipacao(scanner);
                case 7 -> cancelarParticipacao(scanner);
                case 8 -> {
                    eventoService.salvarEventos();
                    rodando = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private void cadastrarEvento(Scanner scanner) {
        Evento evento = new Evento();

        System.out.print("Nome do evento: ");
        evento.setNome(scanner.nextLine());

        System.out.print("Endereço: ");
        evento.setEndereco(scanner.nextLine());

        System.out.print("Categoria (festa/show/esportivo): ");
        evento.setCategoria(scanner.nextLine());

        System.out.print("Descrição: ");
        evento.setDescricao(scanner.nextLine());

        System.out.print("Cidade: ");
        evento.setCidade(scanner.nextLine());

        System.out.print("Data e hora (yyyy-MM-ddTHH:mm): ");
        String dataHora = scanner.nextLine();
        try {
            evento.setHorario(LocalDateTime.parse(dataHora));
        } catch (Exception e) {
            System.out.println("Formato inválido! Use: yyyy-MM-ddTHH:mm");
            return;
        }

        eventoService.cadastrarEvento(evento);
    }

    private void listarEventosPorCidade(Scanner scanner) {
        System.out.print("Informe sua cidade: ");
        String cidade = scanner.nextLine();
        List<Evento> eventosNaCidade = eventoService.listarPorCidade(cidade);
        if (eventosNaCidade.isEmpty()) {
            System.out.println("Nenhum evento encontrado para sua cidade.");
        } else {
            eventosNaCidade.forEach(System.out::println);
        }
    }

    private void confirmarParticipacao(Scanner scanner) {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Nome do evento: ");
        String nomeEvento = scanner.nextLine();

        boolean sucesso = eventoService.confirmarParticipacao(email, nomeEvento);
        if (sucesso) {
            System.out.println("Participação confirmada com sucesso.");
        } else {
            System.out.println("Não foi possível confirmar a participação.");
        }
    }

    private void cancelarParticipacao(Scanner scanner) {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Nome do evento: ");
        String nomeEvento = scanner.nextLine();

        boolean sucesso = eventoService.cancelarParticipacao(email, nomeEvento);
        if (sucesso) {
            System.out.println("Participação cancelada com sucesso.");
        } else {
            System.out.println("Não foi possível cancelar a participação.");
        }
    }
}

