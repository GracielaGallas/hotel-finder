package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class LeitorDeArquivo {

    public Optional<String> buscarArgumentosPorArquivo() {
        try {
            return Files.lines(Paths.get("reserva.txt")).findFirst();
        } catch (IOException e) {
            return Optional.empty();
        }
    }

}
