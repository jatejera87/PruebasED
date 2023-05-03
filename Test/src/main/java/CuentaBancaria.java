public class CuentaBancaria {
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria(double saldoInicial, double tasaInteres) {
        this.saldo = saldoInicial;
        this.tasaInteres = tasaInteres;
    }

    public void deposito(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        this.saldo += monto;
    }

    public void retiro(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        if (monto > this.saldo) {
            throw new IllegalArgumentException("El monto excede el saldo disponible.");
        }
        this.saldo -= monto;
    }

    public void aplicarInteres() {
        this.saldo += this.saldo * this.tasaInteres;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getTasaInteres() {
        return this.tasaInteres;
    }
}

