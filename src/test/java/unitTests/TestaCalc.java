package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestaCalc {
    @Test
    public void testarSomarDoisNumeros(){

    // - Prepara- Configurar - Given
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;



    // - Executar - When

        int resultadoAtual = Calc.somarDoisNumeros(num1,num2);



    // - validar - Then
        assertEquals(resultadoEsperado,resultadoAtual);




    }
    @Test
    public void testarSubtrairDoisNumeros(){


            int num1 = 7;
            int num2 = 2;
            int resultadoEsperado = 5;

            int resultadoAtual = Calc.subtrairDoisNumeros(num1,num2);

            assertEquals(resultadoEsperado,resultadoAtual);
    }

}
