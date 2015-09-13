import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Administrator on 2015/9/8 0008.
 */
public class CalculatorTest
{
    private Calculator calculator;
    Adder adder;
    @Before
    public void setUp() throws Exception
    {
        Mockery context = new Mockery();
        context.setImposteriser(ClassImposteriser.INSTANCE);
        calculator = new Calculator();
        adder = context.mock(Adder.class);
        calculator.setAdder(adder);

        context.checking(new Expectations()
        {
            {
                oneOf(adder).add(2, 3); will(returnValue(5));
            }
        });
        context.checking(new Expectations(){
            {
                oneOf(adder).add(2, 4); will(returnValue(6));
            }
        });
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testAdd() throws Exception
    {
        int result = calculator.add(2, 3);
        Assert.assertEquals(5,result);
        result = calculator.add(2, 4);
        Assert.assertEquals(6,result);
    }
}