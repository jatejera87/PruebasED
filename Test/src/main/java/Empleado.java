

import java.math.BigDecimal;
import java.math.RoundingMode;

class Empleado {
	 
    private double salarioBruto;
    private double impuesto;
    private double salarioNeto;
 
    public Empleado(double salarioBruto) {
        this.salarioBruto = salarioBruto;
        impuesto = round2Decimals(salarioBruto * 0.14);
        salarioNeto = salarioBruto - impuesto;
    }
 
    @Override
    public String toString() {
        return "Salario Bruto: " + salarioBruto
                + "\nImpuestos y retenciones:" + impuesto
                + "\nSalario neto: " + salarioNeto;
    }
 
    public static Double round2Decimals(Double val) {
        return new BigDecimal(val.toString()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
 
    /**
     * @return the salarioBruto
     */
    public double getSalarioBruto() {
        return salarioBruto;
    }
 
    /**
     * @param salarioBruto the salarioBruto to set
     */
    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
 
    /**
     * @return the impuesto
     */
    public double getImpuesto() {
        return impuesto;
    }
 
    /**
     * @param impuesto the impuesto to set
     */
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
 
    /**
     * @return the salarioNeto
     */
    public double getSalarioNeto() {
        return salarioNeto;
    }
 
    /**
     * @param salarioNeto the salarioNeto to set
     */
    public void setSalarioNeto(double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }
}