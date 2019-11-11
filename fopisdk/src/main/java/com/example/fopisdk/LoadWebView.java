package com.example.fopisdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.webkit.WebView;

public class LoadWebView {
    static Context context;

    WebView mywebview;

    public LoadWebView(Context context) {
        this.context = context;
    }

    public static void loadFOPIAPP(WebView view) {

        view.loadUrl("http://kandktechnepal.com/");

    }



    private static int getBatteryPercentage(){
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        return batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

    }

    private static boolean isBlueStak(){
        boolean isBluestack=false;
        int BatteryPercent = getBatteryPercentage();
        String version = System.getProperty("os.version");
        if(BatteryPercent>=99 && (version.contains("android")||!version.contains("-")))
            isBluestack = true;
        return isBluestack;
    }

    private static boolean isAndroidEmulator() {
        String product = Build.PRODUCT;
        boolean isEmulator = false;
        if (product != null) {
            isEmulator = product.equals("sdk") || product.contains("_sdk") || product.contains("sdk_");
        }
        return isEmulator;
    }

    private static boolean isRunningOnEmulator() {
        return Build.FINGERPRINT.startsWith("generic")
                ||Build.FINGERPRINT.contains("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT)
                || Build.PRODUCT.contains("vbox86p")
                || Build.DEVICE.contains("vbox86p")
                || Build.HARDWARE.contains("vbox86");
    }
}

