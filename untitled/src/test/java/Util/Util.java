package Util;

public class Util {
    public static void delay(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
