package calculator2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestForArguments {
    @Test
    public void testArgumentsReturns2and5(){
        Calculator calculator=new Calculator();
        String testString="2-4";
        List<Double> correctList  = new ArrayList<Double>();
        correctList.add(2.0);
        correctList.add(4.0);

        Assert.assertEquals(calculator.findArguments(testString), correctList);
    }
}
