package Mannoroth;

public class One
{

    public static void main(String[] args)
    {
        One o = new Two(){
            @Override
            protected String getSomeString()
            {
                return "1";
            }
        };
    }

    protected String getSomeString()
    {
        return "0";
    }

    private void someInnerMethod()
    {
        String result = getSomeString();
        int i = 0;
    }

    public One()
    {
        someInnerMethod();
    }
}
