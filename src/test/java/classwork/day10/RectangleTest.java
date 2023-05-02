package classwork.day10;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    classwork.day10.Rectangle rectangle = new classwork.day10.Rectangle(3.5, 2.1);

    @Test
    public void rectangleObjectTest() {
        Assert.assertNotNull("The rectangle shouldn't be null", rectangle);
    }

    @Test
    public void getRectangleLengthTest() {
        Assert.assertEquals("Method getLength() doesn't return length", 3.5, rectangle.getLength(), 0.00001);
    }

    @Test
    public void getRectangleWidthTest() {
        Assert.assertEquals("Method getWidth() doesn't return length", 2.1, rectangle.getWidth(), 0.00001);
    }

    @Test
    public void getRectangleAreaTest() {
        Assert.assertEquals("Method getArea() doesn't return area", 7.35, rectangle.getArea(), 0.00001);
    }

    @Test
    public void setRectangleLengthTest() {
        rectangle.setLength(8.4);
        Assert.assertEquals("Method setLength() doesn't change the length",8.4, rectangle.getLength(), 0.00001);
    }

    @Test
    public void setRectangleWidth() {
        rectangle.setWidth(5.8);
        Assert.assertEquals("Method setWidth() doesn't change the width", 5.8, rectangle.getWidth(), 0.00001);
    }
}
