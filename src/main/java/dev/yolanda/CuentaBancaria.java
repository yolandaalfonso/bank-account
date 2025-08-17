package dev.yolanda;

public class CuentaBancaria {
    private float saldo;
    private int consignaciones;
    private int retiros;
    private float tasaAnual;
    private float comisionMensual;
    
    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    
}
