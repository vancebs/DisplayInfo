package com.hf.displayinfo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private DisplayInfoHelper mHelper;

    private TextView mResolutionWidth;
    private TextView mResolutionHeight;
    private TextView mDPIWidth;
    private TextView mDPIHeight;
    private TextView mDensityDpi;
    private TextView mDesity;
    private TextView mDIPWidth;
    private TextView mDIPHeight;

    private TextView mSuggestionValues;
    private TextView mSuggestionValuesLand;
    private TextView mSuggestionValuesSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeFullScreen();

        mHelper = new DisplayInfoHelper(this);

        // Get UI elements
        mResolutionWidth = (TextView) findViewById(R.id.resolution_width);
        mResolutionHeight = (TextView) findViewById(R.id.resolution_height);
        mDPIWidth = (TextView) findViewById(R.id.dpi_width);
        mDPIHeight = (TextView) findViewById(R.id.dpi_height);
        mDensityDpi = (TextView) findViewById(R.id.density_dpi);
        mDesity = (TextView) findViewById(R.id.density);
        mDIPWidth = (TextView) findViewById(R.id.dip_width);
        mDIPHeight = (TextView) findViewById(R.id.dip_height);
        mSuggestionValues = (TextView) findViewById(R.id.suggestion_values);
        mSuggestionValuesLand = (TextView) findViewById(R.id.suggestion_values_land);
        mSuggestionValuesSimple = (TextView) findViewById(R.id.suggestion_values_simple);

        // resolution
        mResolutionWidth.setText(mHelper.getResolutionWidthString());
        mResolutionHeight.setText(mHelper.getResolutionHeightString());

        // DPI
        mDPIWidth.setText(mHelper.getDpiWidthString());
        mDPIHeight.setText(mHelper.getDpiHeightString());
        mDensityDpi.setText(mHelper.getDensityDpiString());

        // Density
        mDesity.setText(mHelper.getDensityString());

        // DIP
        mDIPWidth.setText(mHelper.getDipWidthString());
        mDIPHeight.setText(mHelper.getDipHeightString());

        // suggestion
        String item = "values";
        mSuggestionValuesSimple.setText(mHelper.getSuggestionSW(item));
        mSuggestionValues.setText(mHelper.getSuggestionSWResolution(item));
        mSuggestionValuesLand.setText(mHelper.getSuggestionSWLandResolution(item));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_compute:
                return onComputeClicked();
            default:
                // do nothing
        }
        return super.onMenuItemSelected(featureId, item);
    }

    private void makeFullScreen() {
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }

    private boolean onComputeClicked() {
        Intent intent = new Intent();
        intent.setClass(this, ComputeActivity.class);
        startActivity(intent);
        return true;
    }
}
