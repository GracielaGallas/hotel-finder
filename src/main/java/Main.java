import entidades.Reserva;
import entidades.TotalHotel;
import enums.HotelEnum;
import enums.TipoClienteEnum;
import core.LeitorDeArquivo;
import core.MotorDeBusca;
import core.EntradaParser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        //Instancia de classes
        EntradaParser parser = new EntradaParser();
        MotorDeBusca motor = new MotorDeBusca();

        //Extrai informações dos parametros de entrada e cria obj reserva
        Reserva reserva = parser.parse(args);

        //Busca totais por core
        TotalHotel lakewood = motor.buscaTotalDaReservaPorHotel(reserva, HotelEnum.LAKEWOOD);
        TotalHotel bridgewood = motor.buscaTotalDaReservaPorHotel(reserva, HotelEnum.BRIDGEWOOD);
        TotalHotel ridgewood = motor.buscaTotalDaReservaPorHotel(reserva, HotelEnum.RIDGEWOOD);

        List<TotalHotel> resumoHotel = Arrays.asList(lakewood, bridgewood, ridgewood);

        //Busca resultado final (compara os valores dos hoteis)
        TotalHotel vencedor = motor.buscaHotelMenorValor(resumoHotel);
        System.out.println(vencedor.getHotel().getNome());
    }

}
