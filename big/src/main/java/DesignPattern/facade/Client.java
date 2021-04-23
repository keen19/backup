package DesignPattern.facade;

public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        System.out.println("准备");
        homeTheaterFacade.ready();
        System.out.println("开始");
        homeTheaterFacade.play();
        System.out.println("结束");
//        homeTheaterFacade.pause();
        homeTheaterFacade.end();
    }
}
