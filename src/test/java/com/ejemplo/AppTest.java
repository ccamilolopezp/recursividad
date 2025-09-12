package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest {

    @Test
    void testSuma() {
        assertEquals(5, App.suma(2, 3));
        assertEquals(10, App.suma(10, 0));
        assertEquals(0, App.suma(0, 0));
    }

    @Test
    void testMultiplicacion() {
        assertEquals(6, App.multiplicacion(2, 3));
        assertEquals(0, App.multiplicacion(5, 0));
        assertEquals(25, App.multiplicacion(5, 5));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120",
        "6, 720"
    })
    void testFactorialParametrizado(int entrada, int esperado) {
        assertEquals(esperado, App.factorial(entrada));
    }

    @Test
    void testFactorialNegativoLanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> App.factorial(-5)
        );
        assertEquals("El factorial no está definido para números negativos", ex.getMessage());
    }

    @Test
    void testTipoDatoFactorial() {
        int resultado = App.factorial(5);
        assertTrue(Integer.valueOf(resultado) instanceof Integer);
        assertEquals(120, resultado);
    }

}
