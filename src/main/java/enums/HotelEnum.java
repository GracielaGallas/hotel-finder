package enums;

import java.util.Arrays;

public enum HotelEnum {
    LAKEWOOD("Lakewood", 3, 110L, 80L, 90L, 80L),
    BRIDGEWOOD("Bridgewood", 4, 160L, 110L, 60L, 50L),
    RIDGEWOOD("Ridgewood", 5, 220L, 100L, 150L, 40L);


    HotelEnum(String nome, Integer estrelas, Long regularDiaDeSemana, Long rewardDiaDeSemana, Long regularFimDeSemana, Long rewardFimDeSemana) {
        this.nome = nome;
        this.estrelas = estrelas;
        this.regularDiaDeSemana = regularDiaDeSemana;
        this.rewardDiaDeSemana = rewardDiaDeSemana;
        this.regularFimDeSemana = regularFimDeSemana;
        this.rewardFimDeSemana = rewardFimDeSemana;
    }

    private String nome;
    private Integer estrelas;
    private Long regularDiaDeSemana;
    private Long rewardDiaDeSemana;
    private Long regularFimDeSemana;
    private Long rewardFimDeSemana;

    public String getNome() {
        return nome;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public Long getRegularDiaDeSemana() {
        return regularDiaDeSemana;
    }

    public Long getRewardDiaDeSemana() {
        return rewardDiaDeSemana;
    }

    public Long getRegularFimDeSemana() {
        return regularFimDeSemana;
    }

    public Long getRewardFimDeSemana() {
        return rewardFimDeSemana;
    }

    public static HotelEnum fromName(String nome) {
        return Arrays.stream(HotelEnum.values())
                .filter(v -> v.getNome().equals(nome))
                .findFirst().orElse(null);
    }

}
