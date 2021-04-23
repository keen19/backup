package DesignPattern.state;

public class Client {
    public static void main(String[] args) {
        //创建抽奖活动对象 activity,设置奖品数量为 1
        RaffleActivity activity = new RaffleActivity(1);

        //抽10次奖
        for (int i = 0; i < 10; i++) {
            System.out.println("---第--"+(i+1)+"--次抽奖--------");
            //扣除积分
            activity.debuctMoney();;
            //抽奖
            activity.raffle();
        }
    }
}
