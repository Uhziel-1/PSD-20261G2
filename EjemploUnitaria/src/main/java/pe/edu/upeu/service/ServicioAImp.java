package pe.edu.upeu.service;

public class ServicioAImp implements ServicioA {
    @Override
    public int suma(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int resta(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public double dividir(int num1, int num2) {
        if(num2==0){
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return (double) num1/num2;
    }
}
