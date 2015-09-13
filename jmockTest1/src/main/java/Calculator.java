/**
 * Created by Administrator on 2015/9/8 0008.
 */
public class Calculator
{
    public Adder adder;

    int add(int a, int b)
    {
        return adder.add(a, b);
    }

    public Adder getAdder()
    {
        return adder;
    }

    public void setAdder(Adder adder)
    {
        this.adder = adder;
    }
}
