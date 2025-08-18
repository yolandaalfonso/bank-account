package dev.yolanda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
    @Test
    void testCalcularExtractoMensual() {
        CuentaCorriente cuenta = new CuentaCorriente(10000, 12);
        cuenta.setComisionMensual(500);
        cuenta.calcularExtractoMensual();
        assertTrue(cuenta.saldo < 10000);
    }

    @Test
    void testConsignar() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.consignar(2000);
        assertEquals(7000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.sobregiro, 0.001);
    }

    @Test
    void testConsignarSinSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.consignar(2000);
        assertEquals(7000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.sobregiro, 0.001);
    }

    @Test
    void testRetiroConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 12);
        cuenta.retirarDinero(8000);
        assertEquals(0, cuenta.saldo, 0.001);
        assertEquals(3000, cuenta.sobregiro, 0.001);
    }

    @Test
    void testImprimirCuentaBancaria() {
    CuentaBancaria cuenta = new CuentaBancaria(10000, 12);
    cuenta.imprimir();  
    }
}
