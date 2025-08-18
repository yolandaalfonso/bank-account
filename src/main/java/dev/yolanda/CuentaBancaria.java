package dev.yolanda;

public class CuentaBancaria {
    protected  float saldo;
    protected  int consignaciones;
    protected  int retiros;
    protected  float tasaAnual;
    protected  float comisionMensual;
    
    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
        this.consignaciones = 0;
        this.retiros = 0;
        this.comisionMensual = 0;
    }

    

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }



    public void consignar(float cantidad) {
        saldo += cantidad;
        consignaciones ++;
    }

    public void retirarDinero( float retirada) {
        if (retirada <= saldo) {
            //float saldoActual = saldo - retirada;
            saldo -=retirada;
            retiros ++;
        } else{
            System.out.print("No hay saldo suficiente en la cuenta");
        }
        
    }

    public void calcularInteres(){
        float interesMensual = (saldo * (tasaAnual/12)) / 100;
        saldo += interesMensual;
    }

    public void calcularExtractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
    }

    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Número de consignaciones: " + consignaciones);
        System.out.println("Número de retiros: " + retiros);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: " + comisionMensual);
    }

    
}
