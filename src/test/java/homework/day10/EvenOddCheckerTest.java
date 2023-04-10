package homework.day10;

import org.junit.Assert;
import org.junit.Test;

public class EvenOddCheckerTest {

    @Test

    public void ifEvenTest() {
        Assert.assertTrue(EvenOddChecker.check(6));
    }

    @Test
    public void ifOddTest() {
        Assert.assertFalse(EvenOddChecker.check(5));
    }

}
