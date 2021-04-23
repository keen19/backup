package keen.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FruitHandler {
    public void startEatFruitDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startEatDate = simpleDateFormat.format(new Date());
        System.out.println("开始吃水果的时间"+startEatDate);

    }
    public void endEatFruitDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startEatDate = simpleDateFormat.format(new Date());
        System.out.println("结束吃水果的时间"+startEatDate);

    }
}
