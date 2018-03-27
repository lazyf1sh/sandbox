package KilJaeden;

public class Main
{
    public static void test(ClassA a)
    {
        a = new ClassA();
        a.setQwe("2");
    }

    public static void main(String[] args)
    {
        ClassA a = new ClassA();
        a.setQwe("1");
        test(a);
        a.getQwe();
        int i = 0;
    }


}
