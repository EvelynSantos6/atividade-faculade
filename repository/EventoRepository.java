package com.anhembi.eventosUAM.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.anhembi.eventosUAM.model.Evento;

public class EventoRepository {
	private final String arquivo = "events.data";

    public void salvar(List<Evento> eventos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(eventos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos: " + e.getMessage());
        }
    }

    public List<Evento> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Evento>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Arquivo de eventos não encontrado ou corrompido. Criando lista vazia.");
            return new ArrayList<>();
        }
    }
}
