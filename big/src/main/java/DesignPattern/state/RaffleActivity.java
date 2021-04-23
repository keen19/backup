package DesignPattern.state;

/**
 * 抽奖活动
 */
public class RaffleActivity {
    //活动当前的状态
    State state = null;
    //奖品数量
    int count=0;

    State noRaffleState=new NoRaffleState(this);
    State canRaffleState=new CanRaffleState(this);

    State dispenseState=new DispenseState(this);
    State dispenseOutState=new DispenseOutState(this);

    //构造器
    //1.初始化当前的状态 noRaffleState(不能抽奖)
    //2.初始化奖品的数量
    public RaffleActivity(int count) {
        this.state=getNoRaffleState();
        this.count = count;
    }

    //扣分, 调用当前状态的deductMoney
    public void debuctMoney(){
        state.deductMoney();
    }

    //抽奖
    public void raffle() {
        //如果当前状态是抽奖成功
        if (state.raffle()) {
            //领取奖品
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        int  curCount=count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }


    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }
}
