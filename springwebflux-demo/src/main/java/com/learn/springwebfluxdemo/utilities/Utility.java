package com.learn.springwebfluxdemo.utilities;

public class Utility {

    public static void sleep(long millis){
        System.out.println( "--- [START SLEEP] ---" );
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println( "--- [END   SLEEP] ---" );
    }

}
