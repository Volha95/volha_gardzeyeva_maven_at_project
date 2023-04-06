import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void calculatorAddTest() {
        Assert.assertEquals("Addition returned wrong result: ", 10, calculator.add(6, 4));
    }

    @Test
    public void calculatorSubtractTest() {
        Assert.assertEquals("Subtraction returned wrong result: ", 5, calculator.subtract(15, 10));
    }

    @Test
    public void calculatorMultiplyTest() {
        Assert.assertEquals("Multiply returned wrong result: ", 25, calculator.multiply(5, 5));
    }

    @Test
    public void calculatorDivideTest() {
        Assert.assertEquals("Division returned wrong result: ", 3, calculator.divide(30, 10));
    }

    @Test
    public void calculatorAddNegativeTest() {
        Assert.assertEquals("Addition returned wrong result: ", -10, calculator.add(-6, -4));
    }

    @Test
    public void calculatorSubtractNegativeTest() {
        Assert.assertEquals("Subtraction returned wrong result: ", -5, calculator.subtract(-15, -10));
    }

    @Test
    public void calculatorMultiplyNegativeTest() {
        Assert.assertEquals("Multiply returned wrong result: ", 25, calculator.multiply(-5, -5));
    }

    @Test
    public void calculatorDivideNegativeTest() {
        Assert.assertEquals("Division returned wrong result: ", 3, calculator.divide(-30, -10));
    }
}
