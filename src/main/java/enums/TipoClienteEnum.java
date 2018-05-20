package enums;

import java.util.Arrays;

public enum TipoClienteEnum {
    REGULAR("Regular"),
    REWARDS("Rewards");

    private String nome;

    TipoClienteEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static TipoClienteEnum fromName(String nome) {
        return Arrays.stream(TipoClienteEnum.values())
                .filter(v -> v.getNome().equals(nome))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Nao foi possivel encontrar TipoCliente para: " + nome));
    }
}
