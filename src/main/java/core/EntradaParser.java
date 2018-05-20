package core;

import entidades.Reserva;
import enums.TipoClienteEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class EntradaParser {

    public Reserva parse(String[] parametros) {

        //Se nenhum parametro for informado busca arquivo com parametros
        if (parametros == null || parametros.length == 0) {
            LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo();
            Optional<String> parametroDoArquivo = leitorDeArquivo.buscarArgumentosPorArquivo();
            if (parametroDoArquivo.isPresent()) {
                parametros = parametroDoArquivo.get().split(",");
                TipoClienteEnum tipo = buildTipoCliente(parametros[0].split(":")[0]);
                List<String> dias = buildDias(parametros);
                return new Reserva(tipo, dias);
            } else {
                throw new IllegalArgumentException("Nao foi possivel extrair argumentos do arquivo");
            }
        }
        //Se for informado uma string com todos os parametros
        else if (parametros.length == 1) {
            parametros = parametros[0].split(",");
            TipoClienteEnum tipo = buildTipoCliente(parametros[0].split(":")[0]);
            List<String> dias = buildDias(parametros);
            return new Reserva(tipo, dias);

        } else {
            TipoClienteEnum tipo = buildTipoCliente(parametros[0]);
            List<String> dias = buildDias(parametros);
            return new Reserva(tipo, dias);
        }

    }

    public List<String> buildDias(String[] args) {
        return Arrays.stream(args)
                .filter(d -> d.length() > 9)
                .map(this::formataDia)
                .collect(toList());
    }

    public TipoClienteEnum buildTipoCliente(String valor) {
        valor = valor.replace(":", "");
        return TipoClienteEnum.fromName(valor);
    }

    private String formataDia(String dia) {
        dia = dia.substring(dia.indexOf("(") + 1, dia.indexOf(")"));
        dia = dia.replace(",", "");
        return dia;
    }

}
