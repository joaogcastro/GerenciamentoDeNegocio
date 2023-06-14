package util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.Festa;

public class GerenciadorFestas {
    private List<Festa> festas;

    public GerenciadorFestas() {
        festas = new ArrayList<>();
    }

    public void adicionarFesta(Festa festa) {
        festas.add(festa);
    }

    public boolean verificarDataOcupada(LocalDateTime dataInicio, LocalDateTime dataFim) {
        for (Festa festa : festas) {
            LocalDateTime festaDataInicio = festa.getDataInicio();
            LocalDateTime festaDataFim = festa.getDataFim();

            // Verifica se as datas se sobrepõem
            if (dataInicio.isBefore(festaDataFim) && dataFim.isAfter(festaDataInicio)) {
                return true; // A data está ocupada
            }
        }

        return false; // A data está disponível
    }

    public void cancelarFesta(int idFesta) {
        Festa festaCancelada = null;
        for (Festa festa : festas) {
            if (festa.getIdFesta() == idFesta) {
                festaCancelada = festa;
                break;
            }
        }

        if (festaCancelada != null) {
            festas.remove(festaCancelada);
            System.out.println("A festa foi cancelada.");
        } else {
            System.out.println("Festa não encontrada com o ID fornecido.");
        }
    }

    public static void main(String[] args) {
        GerenciadorFestas gerenciador = new GerenciadorFestas();

        // Adicionar festas ao gerenciador
        Festa festa1 = new Festa();
        festa1.setIdFesta(1); // Definir um ID para a festa
        festa1.setDataInicio(LocalDateTime.of(2023, 6, 15, 10, 0));
        festa1.setDataFim(LocalDateTime.of(2023, 6, 15, 15, 0));
        gerenciador.adicionarFesta(festa1);

        // Verificar se uma data está ocupada
        LocalDateTime dataInicio = LocalDateTime.of(2023, 6, 15, 14, 0);
        LocalDateTime dataFim = LocalDateTime.of(2023, 6, 15, 17, 0);
        boolean dataOcupada = gerenciador.verificarDataOcupada(dataInicio, dataFim);

        if (dataOcupada) {
            System.out.println("A data está ocupada com uma festa marcada.");
        } else {
            System.out.println("A data está disponível para uma festa.");
        }

        // Cancelar uma festa com base no ID
        int idFestaCancelada = 1;
        gerenciador.cancelarFesta(idFestaCancelada);
    }
}

