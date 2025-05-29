package com.anhembi.eventosUAM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.anhembi.eventosUAM.controller.EventoController;

@SpringBootApplication
public class EventosApplication implements CommandLineRunner {

    @Autowired
    private EventoController eventoController;

    public static void main(String[] args) {
        SpringApplication.run(EventosApplication.class, args);
    }

    @Override
    public void run(String... args) {
        eventoController.iniciar();
    }
}

