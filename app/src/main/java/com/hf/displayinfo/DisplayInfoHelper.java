package com.hf.displayinfo;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;

public class DisplayInfoHelper {
    private Activity mActivity;
    
    private Point mResolution = new Point();
    private DisplayMetrics mDisplayMetrics;

    public DisplayInfoHelper(Activity activity) {
        mActivity = activity;
        
        mActivity.getWindowManager().getDefaultDisplay().getRealSize(mResolution);
        mDisplayMetrics = mActivity.getResources().getDisplayMetrics();
    }
    
    public int getResolutionWidth() {
        return mResolution.x;
    }
    
    public int getResolutionHeight() {
        return mResolution.y;
    }
    
    public int getDensityDpi() {
        return mDisplayMetrics.densityDpi;
    }
    
    public float getDpiWidth() {
        return mDisplayMetrics.xdpi;
    }
    
    public float getDpiHeight() {
        return mDisplayMetrics.ydpi;
    }
    
    public float getDensity() {
        return mDisplayMetrics.density;
    }
    
    public float getDipWidth() {
        return (float) getResolutionWidth() * 160 / getDensityDpi();
    }

    public float getDipHeight() {
        return (float) getResolutionHeight() * 160 / getDensityDpi();
    }
    
    public String getResolutionWidthString() {
        return String.valueOf(getResolutionWidth());
    }
    
    public String getResolutionHeightString() {
        return String.valueOf(getResolutionHeight());
    }
    
    public String getDensityDpiString() {
        return String.valueOf(densityDpiToString(getDensityDpi()));
    }
    
    public String getDpiWidthString() {
        return String.valueOf(getDpiWidth());
    }
    
    public String getDpiHeightString() {
        return String.valueOf(getDpiHeight());
    }
    
    public String getDensityString() {
        return String.valueOf(getDensity());
    }
    
    public String getDipWidthString() {
        return String.valueOf(getDipWidth());
    }

    public String getDipHeightString() {
        return String.valueOf(getDipHeight());
    }
    
    public String getResolutionString() {
        return getResolutionString(getResolutionWidth(), getResolutionHeight());
    }
    
    public String getSmallestWidthString() {
        return getSmallestWidthString((int)getDipWidth(), (int)getDipHeight());
    }
    
    public String getSuggestionSW(String item) {
        return item + "-" + getSmallestWidthString();
    }
    
    public String getSuggestionSWResolution(String item) {
        return item + "-" + getSmallestWidthString() + "-" + getResolutionString();
    }
    
    public String getSuggestionSWLandResolution(String item) {
        return item + "-" + getSmallestWidthString() + "-land-" + getResolutionString();
    }
    
    private String getResolutionString(int rw, int rh) {
        return (rw > rh) ? "-" + rw + "x" + rh : "-" + rh + "x" + rw;
    }

    private String getSmallestWidthString(int dipWidth, int dipHeight) {
        return "-sw" + ((dipWidth < dipHeight) ? dipWidth : dipHeight) + "dp";
    }
    
    private String densityDpiToString(int densityDpi) {
        String str;
        switch (densityDpi) {
            case DisplayMetrics.DENSITY_HIGH:
                str = "hdpi";
                break;
            case DisplayMetrics.DENSITY_LOW:
                str = "ldpi";
                break;
            // case DisplayMetrics.DENSITY_DEFAULT:
            case DisplayMetrics.DENSITY_MEDIUM:
                str = "mdpi";
                break;
            case DisplayMetrics.DENSITY_TV:
                str = "tvdpi";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                str = "xhdpi";
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                str = "xxhdpi";
                break;
            case DisplayMetrics.DENSITY_560:
                str = "560";
            case DisplayMetrics.DENSITY_XXXHIGH:
                str = "xxxhdpi";
                break;
            default:
                str = "unknown";
                break;
        }

        return "" + densityDpi + " (" + str + ")";
    }
}
