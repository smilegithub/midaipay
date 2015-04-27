package com.fncat.xswipe;

import android.app.Application;

public class ApplicationInfo extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler crashHandler = CrashHandler.getInstance(this.getApplicationContext());// App崩溃记录
		crashHandler.init(getApplicationContext());
	}
}
