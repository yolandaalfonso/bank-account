package dev.yolanda;

public class CuentaCorriente extends CuentaBancaria{

    private float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void retirarDinero( float retirada) {
        if (retirada <= saldo) {
            //float saldoActual = saldo - retirada;
            saldo -=retirada;
            retiros ++;
        } else{
            sobregiro = saldo -=retirada;
            retiros ++;
        }
    }

    @Override
    public void consignar(float cantidad) {
        super.consignar(cantidad);
        if (sobregiro > 0) {
            sobregiro += cantidad;
            consignaciones ++;
        }else{
            saldo += cantidad;
            consignaciones ++;
        }
        
    }

    @Override
    public void calcularExtractoMensual() {
        //saldo -= comisionMensual;
        //calcularInteres();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Número de consignaciones: " + consignaciones);
        System.out.println("Número de retiros: " + retiros);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: " + comisionMensual);
    }
    


}
