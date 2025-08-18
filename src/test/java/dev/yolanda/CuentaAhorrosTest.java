package dev.yolanda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CuentaAhorrosTest {

    @Test
    void testCuentaActivaInicial() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 12);
        assertTrue(cuenta.activa);
    }

    @Test
    void testCuentaInactivaInicial() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 12);
        assertFalse(cuenta.activa);
    }

    @Test
    void testCalcularExtractoMensualConMuchosRetiros() {
        CuentaAhorros cuenta = new CuentaAhorros(20000, 12);
        for (int i = 0; i < 6; i++) {
            cuenta.retirarDinero(1000);
        }
        cuenta.calcularExtractoMensual();
        assertTrue(cuenta.comisionMensual > 0);
        assertTrue(cuenta.saldo < 20000);
    }

    @Test
    void testConsignarEnCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 12);
        cuenta.consignar(2000);
        assertEquals(5000, cuenta.saldo, 0.001);
    }


    @Test
    void testRetirarDineroEnCuentaActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(20000, 12);
        cuenta.retirarDinero(5000);
        assertEquals(15000, cuenta.saldo, 0.001);
    }
}
