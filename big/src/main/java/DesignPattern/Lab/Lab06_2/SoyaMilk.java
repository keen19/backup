package DesignPattern.Lab.Lab06_2;

//抽象类,
public abstract class SoyaMilk {
    //模板方法make
    final void make(){
        select();
        if (hook()) {
            addCondiments();
        }
        soak();
        beat();

    }
    //选材料
    void select(){
        System.out.println("选择黄豆");
    }

    //添加不同的配料,抽象方法,子类具体实现
    abstract void addCondiments();

    //浸泡
    void soak(){
        System.out.println("浸泡黄豆");
    }

    //制作
    void beat(){
        System.out.println("打豆浆");
    }
    boolean hook(){
        return true;
    }
}
