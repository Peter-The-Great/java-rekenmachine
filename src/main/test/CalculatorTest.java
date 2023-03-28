import com.pjotr.calculator.CalculatorOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends CalculatorOperation {
    private static final double DELTA = 1e-15;
    @Test
    public void testAddition() {
        CalculatorOperation calc = new CalculatorOperation();
        calc.Operation("1+2");
        assertEquals(3, calc.AdditionAndSubtraction(), DELTA);
    }

    @Test
    public void testSubtraction() {
        CalculatorOperation calc = new CalculatorOperation();
        calc.Operation("5-3");
        assertEquals(2, calc.AdditionAndSubtraction(), DELTA);
    }

    @Test
    public void testMultiplication() {
        CalculatorOperation calc = new CalculatorOperation();
        calc.Operation("3*4");
        assertEquals(12, calc.multiplication(), DELTA);
    }

    @Test
    public void testDivision() {
        CalculatorOperation calc = new CalculatorOperation();
        calc.Operation("10/5");
        assertEquals(2, calc.division(), DELTA);
    }

    @Test
    public void testPower() {
        CalculatorOperation calc = new CalculatorOperation();
        calc.Operation("2^3");
        assertEquals(8, calc.power(), DELTA);
    }
}
