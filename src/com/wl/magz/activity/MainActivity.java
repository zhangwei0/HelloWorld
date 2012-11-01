package com.wl.magz.activity;

import com.wl.magz.R;
import com.wl.magz.utils.SharedPreferencesHelper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    private Handler mHandler;
    private static final int DOWNLODD_COMPLETE = 0;
    private static final int DOWNLOAD_NET_OFFLINE = 1;
    private static final int DOWNLAOD_FAILURE = 2;
    private static final int DOWNLAOD_TIME_OUT = 3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //TODO ProgressBar displayed unnormal if the activity is not fullScreen WHY?

        mHandler = new ResultHandler();

        createShortcut();

        runFirstDownload();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	
	private void createShortcut() {
	    SharedPreferencesHelper helper = new SharedPreferencesHelper(getApplicationContext());
	    if(!helper.getFirstLunch()) {
	        return;
	    }
	    Intent shortcutIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
	    shortcutIntent.putExtra("duplicate", false);
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.shortcut_name));
	    Parcelable icon = Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.icon);
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
	    Intent startIntent = new Intent(getApplicationContext() , MainActivity.class);
	    startIntent.setAction("android.intent.action.MAIN");
	    startIntent.addCategory("android.intent.category.LAUNCHER");
	    shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, startIntent);
	    sendBroadcast(shortcutIntent);
	    
	    helper.setFirstLaunch(false);
	}

    private void runFirstDownload() {
        FirstDownloadThread thread = new FirstDownloadThread();
        thread.start();
    }

    private class ResultHandler extends Handler {
        public void handleMessage(Message msg) {
            switch(msg.what) {
            case DOWNLODD_COMPLETE:
                //TODO
                break;
            case DOWNLOAD_NET_OFFLINE:
                //TODO
                break;
            case DOWNLAOD_FAILURE:
                //TODO
                break;
            case DOWNLAOD_TIME_OUT:
                //TODO
                break;
            }
        }
    }

    private class FirstDownloadThread extends Thread {
        public void run() {
            //TODO
            //First Download

            //TODO
            //sendMessage();
        }

        private void sendMessage(int result) {
            mHandler.obtainMessage(result).sendToTarget();
        }
    }
}
