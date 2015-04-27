package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 切换至升级模式
 * 
 * @author Fncat
 * @data 2014-4-24上午11:34:36
 */
public class UpModel extends Thread {
	private Handler mHandler;
	private POSManage pm;

	public UpModel(Handler mHandler, POSManage pm) {
		this.mHandler = mHandler;
		this.pm = pm;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.ChangeUpgradeMode();
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E2);
		Utils.HandData(mHandler, r, 0xA1E2);
	}

}
