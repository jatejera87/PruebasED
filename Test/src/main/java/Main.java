

public class Main {

	public static void main(String[] args) throws Exception {
		try{
			int valor1 = 0;
			int valor2 = 0;
			String op = "";
			int res = 0;

			valor1 = Integer.parseInt(args[0]);
			valor2 = Integer.parseInt(args[1]);
			op = args[2];

			if ("+".equals(op)) {
				res = suma(valor1,valor2);
			}else if("-".equals(op)){
				res = resta(valor1,valor2);
			}else if("x".equals(op)){
				res = multiplica(valor1,valor2);
			}else if("/".equals(op)){
				res = divide(valor1,valor2);
			}else {
				throw new IllegalArgumentException("Unexpected value: " + op);
			}			
			System.out.print("EL resultado de " + valor1 + " " + op +  " " + valor2 + " = " + res ); 
			//return res;
		}catch (Exception e) {
			System.out.print("La has liado compañero");
			throw e;
		}
	}
	
	public static int suma (int valor1, int valor2) {
		int v1 = valor1;
		int v2 = valor2;
		int resultado = v1+v2;
		return resultado;
	}
	
	public static int resta (int valor1, int valor2) {
		int v1 = valor1;
		int v2 = valor2;
		int resultado = v1-v2;
		return resultado;
	}
	
	public static int multiplica (int valor1, int valor2) {
		int v1 = valor1;
		int v2 = valor2;
		int resultado = v1*v2;
		return resultado;
	}
	
	public static int divide (int valor1, int valor2) {
		int v1 = valor1;
		int v2 = valor2;
		int resultado = v1/v2;
		return resultado;
	}
}
