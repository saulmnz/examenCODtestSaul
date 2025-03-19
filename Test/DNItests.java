import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DNItests {

    @ParameterizedTest (name = "Comprobar DNI: {0} {1} => {2}")
    @CsvSource({
            "00000000, T, true",
            "12345678, Z, true",
            "11111111, H, true",
            "53974423, R, true",
            "53123155, J, false",
            "53974423, W, false"

    })
    void testComprobarDNI(String dni, char letra, boolean expected) {
        boolean result = Main.comprobarDNI(dni, letra);
        assertEquals(expected, result);
    }


    @ParameterizedTest(name = "LETRA DNI: {0} => {1}")
    @CsvSource({
            "00000000, T",
            "00000001, R",
            "00000002, W",
            "00000003, A",
            "00000004, G",
            "00000005, M",
            "00000006, Y",
            "00000007, F",
            "00000008, P",
            "00000009, D",
            "00000010, X",
            "00000011, B",
            "00000012, N",
            "00000013, J",
            "00000014, Z",
            "00000015, S",
            "00000016, Q",
            "12345678, Z",
            "0, T",
            "123, P",
    })
    public void testCalcularLetraDNI(String dni, char expected) {
        assertEquals(expected, Main.calcularLetraDNI(dni));
    }

}