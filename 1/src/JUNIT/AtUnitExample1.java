package JUNIT;


import org.junit.Test;

public class AtUnitExample1 {
    public String methodOne(){
        return "This is methodOne";
    }
    public int methodTwo(){
        System.out.println("This is methodTwo");
        return 2;
    }
    @Test
    public void methodOneTest(){
        System.out.println(methodOne().equals("This is methodOne"));
    }
    @Test
    public void methodTwoTest(){
        System.out.println(methodTwo()==2);
    }

}
