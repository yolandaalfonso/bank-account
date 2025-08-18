package dev.yolanda;

public class CuentaCorriente extends CuentaBancaria{

    protected float sobregiro;

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
            float diferencia = retirada - saldo;
            saldo = 0;
            sobregiro += diferencia;
            retiros ++;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro){
                sobregiro = 0;
                cantidad -= sobregiro;
                saldo += cantidad;
            }else {
                sobregiro -= cantidad;
            }
            
        }else{
            saldo += cantidad;
        }
        consignaciones ++;
    }

    @Override
    public void calcularExtractoMensual() {
        super.calcularExtractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Número de transacciones: " + (consignaciones + retiros));
        System.out.println("Sobregiro: " + sobregiro);
    }

    
    


}
