package DesignPattern.Lab.Lab08;

/**
 * 发放奖品的状态
 */
public class DispenseState extends State {
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("退回25分钱");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    //发放奖品
    @Override
    public void dispensePrize() {
        //有奖品发奖品
        if (activity.getCount() > 0) {
            System.out.println("恭喜中奖,获得第二颗糖果");
            //改变状态不能抽奖
            activity.setState(activity.getNoRaffleState());
            //判断是否还有奖品 没有则活动结束
            if (activity.getCount()==0){
                activity.setState(activity.getDispenseOutState());
                System.exit(0);
            }
        }
    }
}
