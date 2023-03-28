import com.pjotr.calculator.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

/**
 * @TestFractional
 * Deze methode test de methode factorial. Om te kijken of het werkt. Zowel met 0 en 1 als met elk ander getal.
 * @return het faculteit van een getal.
 */
public class TestFractional extends MathUtils{
    @Test
    public void testFactorial() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(1.0, mathUtils.factorial(0));
        assertEquals(1.0, mathUtils.factorial(1));
        assertEquals(120.0, mathUtils.factorial(5));
    }
}
