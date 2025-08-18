package dev.yolanda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CuentaBancariaTest {
    @Test
    void testCalcularExtractoMensual() {
        CuentaBancaria cuenta = new CuentaBancaria(10000, 12);
        cuenta.setComisionMensual(500);
        cuenta.calcularExtractoMensual();
        assertTrue(cuenta.saldo < 10000);
    }

    @Test
    void testCalcularInteres() {
        CuentaBancaria cuenta = new CuentaBancaria(12000, 12);
        cuenta.calcularInteres();
        assertTrue(cuenta.saldo > 12000);
    }

    @Test
    void testConsignar() {
        CuentaBancaria cuenta = new CuentaBancaria(5000, 12);
        cuenta.consignar(2000);
        assertEquals(7000, cuenta.saldo, 0.001);
        assertEquals(1, cuenta.consignaciones);
    }

    @Test
    void testRetirarDinero() {
        CuentaBancaria cuenta = new CuentaBancaria(5000, 12);
        cuenta.retirarDinero(2000);
        assertEquals(3000, cuenta.saldo, 0.001);
        assertEquals(1, cuenta.retiros);
    }

    @Test
    void testRetirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(1000, 12);
        cuenta.retirarDinero(2000);
        assertEquals(1000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.retiros);
    }

    @Test
    void testImprimirCuentaBancaria() {
    CuentaBancaria cuenta = new CuentaBancaria(10000, 12);
    cuenta.imprimir();  
    }

}
