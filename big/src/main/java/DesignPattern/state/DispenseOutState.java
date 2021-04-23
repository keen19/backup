package DesignPattern.state;

/**
 * 奖品发送完状态
 */
public class DispenseOutState extends State{
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了");

        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了");

    }
}
