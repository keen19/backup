package DesignPattern.facade;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import javax.net.ssl.SSLServerSocket;

public class HomeTheaterFacade {
    //定义各个子系统对象
    private TheaterLight theaterLight;
    private Popcorn popcorn;
    private  Stereo stereo;
    private  Projector projector;
    private Screen screen;
    private DVDPlayer dvdPlayer;

    //构造器
    public HomeTheaterFacade() {
        super();
        this.theaterLight = TheaterLight.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }
    public void play(){
        dvdPlayer.play();
    }

    public void pause(){
        dvdPlayer.pause();
    }
    public void end(){
        popcorn.off();
        popcorn.off();
        screen.up();
        projector.off();
        stereo.off();
        dvdPlayer.off();
        theaterLight.bright();
    }


}
