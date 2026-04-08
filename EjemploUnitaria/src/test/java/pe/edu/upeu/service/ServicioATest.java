package pe.edu.upeu.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
@DisplayName("Operaciones Basicas")
public class ServicioATest {
    private ServicioA servicioA;
    @BeforeAll
    static void setup(){
        System.out.println("Iniciando Pruebas ServicioA");
    }
    @BeforeEach
    void setExec(){
        System.out.println("Ejecutado");
        servicioA=new ServicioAImp();
    }
    @Nested
    class OperacionesBasicas{
        @Test
        @DisplayName("Suma dos Valores")
        void sumaValores(){
            int resultado=servicioA.suma(5,6);
            Assertions.assertThat(resultado).isEqualTo(11);
        }
        @Test
        @DisplayName("Resta de dos Valores")
        void restaValores(){
            int resultado=servicioA.resta(8,6);
            Assertions.assertThat(resultado).isEqualTo(2);
        }
    }
    @AfterAll
    static void finalizar(){
        System.out.println("Pruebas Finalizadas");
    }
}
