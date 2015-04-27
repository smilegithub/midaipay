package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.MainActivity;
import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 获取电子现金余额
 * 
 * @author Fncat
 * @data 2014-4-24上午11:37:10
 */
public class Balance extends Thread {
	private Handler mHandler;
	private POSManage pm;

	public Balance(Handler mHandler, POSManage pm) {
		this.mHandler = mHandler;
		this.pm = pm;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.getBankIcCardBalance(MainActivity.moneys);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E6);
		Utils.HandData(mHandler, r, 0xA1E6);
	}

}
