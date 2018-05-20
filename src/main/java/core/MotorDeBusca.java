package core;

import entidades.Reserva;
import entidades.TotalHotel;
import enums.HotelEnum;
import enums.TipoClienteEnum;

import java.util.List;
import java.util.stream.Collectors;

public class MotorDeBusca {

    public TotalHotel buscaHotelMenorValor(List<TotalHotel> resumoHotel) {
        TotalHotel hotelMaisBarato = resumoHotel.get(0);
        Long precoMaisBarato = resumoHotel.get(0).getTotal();

        for (int i = 0; i <= resumoHotel.size() - 1; i++) {
            TotalHotel hotelAtual = resumoHotel.get(i);
            Long precoAtual = resumoHotel.get(i).getTotal();

            if (precoAtual < precoMaisBarato) {
                precoMaisBarato = precoAtual;
                hotelMaisBarato = hotelAtual;
            } else if (precoAtual.equals(precoMaisBarato) && hotelAtual.getHotel().getEstrelas() > hotelMaisBarato.getHotel().getEstrelas()) {
                precoMaisBarato = precoAtual;
                hotelMaisBarato = hotelAtual;
            }
        }

        return hotelMaisBarato;
    }

    public TotalHotel buscaTotalDaReservaPorHotel(Reserva reserva, HotelEnum hotel) {
        List<Long> valores = reserva.getDias().stream()
                .map(dia -> buscaValorPorDia(reserva.getTipo(), hotel, dia))
                .collect(Collectors.toList());

        Long total = valores.stream().mapToLong(v -> v).sum();
        return new TotalHotel(total, hotel);
    }

    public Long buscaValorPorDia(TipoClienteEnum tipo, HotelEnum hotel, String dia) {
        Long valor = 0L;

        valor = buscarValorSeTipoRegular(tipo, hotel, dia, valor);
        valor = buscarValorSeTipoRewards(tipo, hotel, dia, valor);

        return valor;
    }

    private Long buscarValorSeTipoRewards(TipoClienteEnum tipo, HotelEnum hotel, String dia, Long valor) {
        if (tipo == TipoClienteEnum.REWARDS) {
            if (ehFimDeSemana(dia)) {
                valor = valor + hotel.getRewardFimDeSemana();
            } else {
                valor = valor + hotel.getRewardDiaDeSemana();
            }
        }
        return valor;
    }

    private Long buscarValorSeTipoRegular(TipoClienteEnum tipo, HotelEnum hotel, String dia, Long valor) {
        if (tipo == TipoClienteEnum.REGULAR) {
            if (ehFimDeSemana(dia)) {
                valor = valor + hotel.getRegularFimDeSemana();
            } else {
                valor = valor + hotel.getRegularDiaDeSemana();
            }
        }
        return valor;
    }

    public Boolean ehFimDeSemana(String dia) {
        return dia.equals("sat") || dia.equals("sun");
    }

}
