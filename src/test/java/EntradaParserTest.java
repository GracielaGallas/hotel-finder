import enums.TipoClienteEnum;
import core.EntradaParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntradaParserTest {

    private EntradaParser extractor;

    @Before
    public void setUp() {
        extractor = new EntradaParser();
    }

    @Test
    public void deveExtrairTipoClienteRegular() {
        String tipo = "Regular:";

        TipoClienteEnum response = extractor.buildTipoCliente(tipo);
        assertThat(response, is(TipoClienteEnum.REGULAR));
    }

    @Test
    public void deveExtrairTipoClienteRewards() {
        String tipo = "Rewards:";

        TipoClienteEnum response = extractor.buildTipoCliente(tipo);
        assertThat(response, is(TipoClienteEnum.REWARDS));
    }

    @Test
    public void deveExtrairDias() {
        String[] dias = {"16Mar2009(mon)", "17Mar2009(tues)", "18Mar2009(wed)"};

        List<String> expected = Arrays.asList("mon", "tues", "wed");
        List<String> response = extractor.buildDias(dias);

        assertThat(response, is(expected));
    }
}
