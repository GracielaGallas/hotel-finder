import entidades.Reserva;
import entidades.TotalHotel;
import enums.HotelEnum;
import enums.TipoClienteEnum;
import core.MotorDeBusca;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MotorDeBuscaTest {

    private MotorDeBusca motor;

    @Before
    public void setUp() {
        motor = new MotorDeBusca();
    }

    @Test
    public void deveRetornarTrueSeForFinalDeSemana() {
        Boolean response = motor.ehFimDeSemana("sat");
        Boolean expected = Boolean.TRUE;

        assertThat(response, is(expected));
    }

    @Test
    public void deveRetornarFalseSeForDiaDeSemana() {
        Boolean response = motor.ehFimDeSemana("tue");
        Boolean expected = Boolean.FALSE;

        assertThat(response, is(expected));
    }

    @Test
    public void deveBuscarValorDoDiaLakewood(){
        Long response = motor.buscaValorPorDia(TipoClienteEnum.REWARDS, HotelEnum.LAKEWOOD, "sat");
        Long expected = 80L;

        assertThat(response, is(expected));
    }

    @Test
    public void deveBuscarValorDoDiaBridgewood(){
        Long response = motor.buscaValorPorDia(TipoClienteEnum.REGULAR, HotelEnum.BRIDGEWOOD, "fri");
        Long expected = 160L;

        assertThat(response, is(expected));
    }

    @Test
    public void deveBuscarValorDoDiaRidgewood(){
        Long response = motor.buscaValorPorDia(TipoClienteEnum.REWARDS, HotelEnum.RIDGEWOOD, "sun");
        Long expected = 40L;

        assertThat(response, is(expected));
    }

    @Test
    public void deveBuscarTotalPorHotel(){
        Reserva reserva = new Reserva(TipoClienteEnum.REWARDS, Arrays.asList("fri", "sat"));

        TotalHotel response = motor.buscaTotalDaReservaPorHotel(reserva, HotelEnum.LAKEWOOD);
        TotalHotel expected = new TotalHotel(160L, HotelEnum.LAKEWOOD);

        assertThat(response, is(expected));
    }

    @Test
    public void deveBuscarHotelMenorValor(){
        TotalHotel totalHotelUm = new TotalHotel(160L, HotelEnum.LAKEWOOD);
        TotalHotel totalHotelDois = new TotalHotel(150L, HotelEnum.BRIDGEWOOD);

        TotalHotel response = motor.buscaHotelMenorValor(Arrays.asList(totalHotelUm, totalHotelDois));
        TotalHotel expected = totalHotelDois;

        assertThat(response, is(expected));
    }

    @Test
    public void deveBuscarHotelMenorValorEmCasoDeEmpateRetornaOMelhor(){
        TotalHotel totalHotelUm = new TotalHotel(160L, HotelEnum.LAKEWOOD);
        TotalHotel totalHotelDois = new TotalHotel(160L, HotelEnum.BRIDGEWOOD);

        TotalHotel response = motor.buscaHotelMenorValor(Arrays.asList(totalHotelUm, totalHotelDois));
        TotalHotel expected = totalHotelDois;

        assertThat(response, is(expected));
    }
}

