package net.breakfaststudios.JNI;

public class ThreadManager {
    private boolean doubleClick;
    private int clickLimit;
    private int key;
    private Backend backend;

    public ThreadManager(){
        // -1 assumes infinite until interrupted
        clickLimit = -1;
        doubleClick = false;
        backend = new Backend();
    }

    private final Thread clicker = new Thread(() -> backend.clicker(key, clickLimit, doubleClick));

    public void startClickThread(int key){
        startClickThread(key, clickLimit, doubleClick);
    }

    public void startClickThread(int key, int clickLimit){
        startClickThread(key, clickLimit, doubleClick);
    }

    public void startClickThread(int key, int clickLimit, boolean doubleClick){
        this.clickLimit = clickLimit;
        this.doubleClick = doubleClick;
        this.key = key;
        clicker.start();
    }

    public void stopClickThread(){
        if (clicker.isAlive()) {
            clicker.interrupt();
        }
    }
}