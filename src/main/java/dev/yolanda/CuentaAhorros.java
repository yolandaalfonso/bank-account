package dev.yolanda;

public class CuentaAhorros extends CuentaBancaria {

    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    @Override
    public void calcularExtractoMensual() {
        
        if (retiros > 4) {
            comisionMensual += (retiros - 4) * 1000;
        } else {
            super.calcularExtractoMensual();
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (!activa) {
            System.out.println("La cuenta no está activa y mo puedes realizar depósitos.");
        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Número de transacciones: " + (consignaciones + retiros));
        System.out.println("Cuenta activa: " + activa);
    }

    @Override
    public void retirarDinero(float retirada) {
        if (!activa) {
            System.out.println("La cuenta no está activa y no puedes retirar dinero.");
        } else {
            super.retirarDinero(retirada);
        }
    }
    
    
}
