package DesignPattern.proxy.dynamicproxy;

public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("老师授课....");
    }

    @Override
    public void say(String word ,int number) {
        System.out.println(word+number);
    }

}
