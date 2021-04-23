package DesignPattern.builder;

//抽象的建造者
public abstract class HouseBuilder {

    protected House house=new House();

    //打地基
    public abstract void buildBasic();
    //砌墙
    public abstract void buildWalls();
    //盖房顶
    public abstract void roofed();

    //建房子,返回
    public House buildHouse(){
        return house;
    }
}
