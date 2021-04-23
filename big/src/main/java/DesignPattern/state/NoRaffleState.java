package DesignPattern.state;

/**
 * 不能抽奖状态
 */
public class NoRaffleState extends State {

    //初始化传入活动引用,扣除积分后改变状态
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity=activity;
    }

    //当前状态可以扣积分,扣除后,将状态设置成可以抽奖状态
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功,您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    //当前状态不能抽奖
    @Override
    public boolean raffle(){
        System.out.println("扣了积分才可以抽奖");
        return false;
    }

    @Override
    public void dispensePrize(){
        System.out.println("不能发放奖品");
    }
}
