package DesignPattern.principle.yilaidaozhuan;

public class Test {
    public static void main(String[] args) {
        ALLITVImpl allitv = new ALLITVImpl();
        Samsung itv = new Samsung();
        allitv.playControl(itv);
    }
}

//电视机开关
interface ALLITV {
    void playControl(ITV itv);
}

//电视机类型
interface ITV {
    void play();
}

//电视机实现
class Samsung implements ITV {
    @Override
    public void play() {
        System.out.println("三星电视打开");
    }
}

//电视机开关实现
class ALLITVImpl implements ALLITV {
    @Override
    public void playControl(ITV itv) {
        itv.play();
    }
}
