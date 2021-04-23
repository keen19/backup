package DesignPattern.Lab.Lab04_1;



/**
 * 懒汉式（静态变量）
 */
    public class DiaoShan{
        public static final int HIGH=3;
        public static final int MEDIUM=2;
        public static final int  LOW=1;
        public static final int  OFF=0;
        int switchspeed;
        //1.构造器私有化
        public DiaoShan(){};



        public void high(){
            switchspeed=HIGH;
            System.out.println("风扇速度：高");
        }
        public void medium(){
            switchspeed=MEDIUM;
            System.out.println("风扇速度：中");
        }
        public void low(){
            switchspeed=LOW;
            System.out.println("风扇速度：低");
        }
        public void off(){
            switchspeed=OFF;
            System.out.println("风扇速度：停");
        }
        public int getSwitchspeed(){
            return switchspeed;
        }
}
