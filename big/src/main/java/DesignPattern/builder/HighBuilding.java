package DesignPattern.builder;

public class HighBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼建房子100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙100cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼封顶");
    }
}

