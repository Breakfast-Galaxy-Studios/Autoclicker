package net.breakfaststudios.JNI;

public class Backend {
    static {
        // Get file path to dll, probably should be put in appdata
        // System.load();
    }

    public native void clicker(int key, int clickLimit, boolean doubleClick);

}
