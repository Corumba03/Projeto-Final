package model.forms;

import java.time.LocalDate;

import controller.usuarios.UsuarioController;
import model.pacotesViagem.DestinoModel;

public class ReservaModel {
    private UsuarioController usuario;
    private DestinoModel destino;
    private final LocalDate criacao; // Data de criação da reserva
    private LocalDate dataReserva; // Data reservada

    public ReservaModel(UsuarioController usuario, DestinoModel destino, LocalDate dataReserva) {
        this.usuario = usuario;
        this.destino = destino;
        this.criacao = LocalDate.now();
        this.dataReserva = dataReserva;
    }

    // Getters e Setters
    public UsuarioController getUsuario() { return usuario; }
    public void setUsuario(UsuarioController usuario) { this.usuario = usuario; }

    public DestinoModel getDestino() { return destino; }
    public void setDestino(DestinoModel destino) { this.destino = destino; }

    public LocalDate getCriacao() { return criacao; }

    public LocalDate getDataReserva() { return dataReserva; }
    public void setDataReserva(LocalDate DataReserva) { this.dataReserva = dataReserva; }
}
