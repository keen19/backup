package DesignPattern.Lab.Lab08;

public abstract class State {
    //扣除积分
    public abstract void deductMoney();

    //抽奖
    public abstract boolean raffle();

    //领奖品
    public abstract void dispensePrize();
}
