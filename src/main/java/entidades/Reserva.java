package entidades;

import enums.TipoClienteEnum;

import java.util.List;

public class Reserva {

    private TipoClienteEnum tipo;
    private List<String> dias;

    public Reserva(TipoClienteEnum tipo, List<String> dias) {
        this.tipo = tipo;
        this.dias = dias;
    }

    public TipoClienteEnum getTipo() {
        return tipo;
    }

    public List<String> getDias() {
        return dias;
    }

    @Override
    public String toString() {
        return "entidades.Reserva{" +
                "tipo=" + tipo +
                ", dias=" + dias +
                '}';
    }
}
