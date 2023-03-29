import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.pjotr.calculator.CalculatorOperation;
import com.pjotr.calculator.MathUtils;

public class CalculatorTest {
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
        calc.Operation("3-2");
        assertEquals(1, calc.AdditionAndSubtraction(), DELTA);
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
    @Test
    public void testFactorial() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(1.0, mathUtils.factorial(0));
        assertEquals(1.0, mathUtils.factorial(1));
        assertEquals(120.0, mathUtils.factorial(5));
    }
}
