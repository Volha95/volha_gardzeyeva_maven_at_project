package homework.day10;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void calculatorAddMaxPosTest() {
        Assert.assertEquals("Addition returned wrong result: ", 2147483647, calculator.add(1073741824, 1073741823));
    }

    @Test
    public void calculatorAddMaxNegTest() {
        Assert.assertEquals("Addition returned wrong result: ", -2147483648, calculator.add(-1073741824, -1073741824));
    }

    @Test
    public void calculatorAddMaxNegOneNegTest() {
        Assert.assertEquals("Addition returned wrong result: ", -2147483648, calculator.add(-2147483647, -1));
    }

    @Test
    public void calculatorAddMaxNegZeroTest() {
        Assert.assertEquals("Addition returned wrong result: ", -2147483648, calculator.add(-2147483648, 0));
    }

    @Test
    public void calculatorAddMaxNegOnePosTest() {
        Assert.assertEquals("Addition returned wrong result: ", -2147483647, calculator.add(-2147483648, 1));
    }

    @Test
    public void calculatorAddMaxNegMaxPosTest() {
        Assert.assertEquals("Addition returned wrong result: ", -1, calculator.add(-2147483648, 2147483647));
    }

    @Test
    public void calculatorAddOneNegOneNegTest() {
        Assert.assertEquals("Addition returned wrong result: ", -2, calculator.add(-1, -1));
    }

    @Test
    public void calculatorAddZeroZeroTest() {
        Assert.assertEquals("Addition returned wrong result: ", 0, calculator.add(0, 0));
    }

    @Test
    public void calculatorAddOneOneTest() {
        Assert.assertEquals("Addition returned wrong result: ", 2, calculator.add(1, 1));
    }

    @Test
    public void calculatorSubtractMaxNegTest() {
        Assert.assertEquals("Subtraction returned wrong result: ", 0, calculator.subtract(-2147483648, -2147483648));
    }

    @Test
    public void calculatorSubtractOneNegTest() {
        Assert.assertEquals("Subtraction returned wrong result: ", 0, calculator.subtract(-1, -1));
    }

    @Test
    public void calculatorSubtractZeroZeroTest() {
        Assert.assertEquals("Subtraction returned wrong result: ", 0, calculator.subtract(0, 0));
    }

    @Test
    public void calculatorSubtractOneOneTest() {
        Assert.assertEquals("Subtraction returned wrong result: ", 0, calculator.subtract(1, 1));
    }

    @Test
    public void calculatorSubtractMaxPosTest() {
        Assert.assertEquals("Subtraction returned wrong result: ", 0, calculator.subtract(2147483647, 2147483647));
    }

    @Test
    public void calculatorMultiplyMaxNegTest() {
        Assert.assertEquals("Multiply returned wrong result: ", -2147395600, calculator.multiply(-46340, -46340));
    }

    @Test
    public void calculatorMultiplyOneNegTest() {
        Assert.assertEquals("Multiply returned wrong result: ", 1, calculator.multiply(-1, -1));
    }

    @Test
    public void calculatorMultiplyZeroTest() {
        Assert.assertEquals("Multiply returned wrong result: ", 0, calculator.multiply(0, 0));
    }

    @Test
    public void calculatorMultiplyOnePosTest() {
        Assert.assertEquals("Multiply returned wrong result: ", 1, calculator.multiply(1, 1));
    }

    @Test
    public void calculatorMultiplyMaxPosTest() {
        Assert.assertEquals("Multiply returned wrong result: ", 2147395600, calculator.multiply(46340, 46340));
    }

    @Test
    public void calculatorDivideMaxNegTest() {
        Assert.assertEquals("Division returned wrong result: ", 1, calculator.divide(-2147483648, -2147483648));
    }

    @Test
    public void calculatorDivideOneNegTest() {
        Assert.assertEquals("Division returned wrong result: ", 1, calculator.divide(-1, -1));
    }

    @Test
    public void calculatorDivideOnePosTest() {
        Assert.assertEquals("Division returned wrong result: ", 1, calculator.divide(1, 1));
    }

    @Test
    public void calculatorDivideMaxPosTest() {
        Assert.assertEquals("Division returned wrong result: ", 1, calculator.divide(2147483647, 2147483647));
    }

}
