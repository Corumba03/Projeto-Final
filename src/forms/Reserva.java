package forms;

import pacotes_viagem.Destino;
import usuarios.Usuario;

import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private Destino destino;
    private final LocalDate criacao; // Data de criação da reserva
    private LocalDate reserva; // Data reservada // TODO colocar nome mais intuitivo

    public Reserva(Usuario usuario, Destino destino, LocalDate reserva) {
        this.usuario = usuario;
        this.destino = destino;
        this.criacao = LocalDate.now();
        this.reserva = reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public LocalDate getCriacao() {
        return criacao;
    }

    public LocalDate getReserva() {
        return reserva;
    }

    public void setReserva(LocalDate reserva) {
        this.reserva = reserva;
    }
}
