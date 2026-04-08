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
}
