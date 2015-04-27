package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 命令下发
 * 
 * @author Fncat
 * @data 2014-4-24上午11:33:43
 */
public class Common extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String mStr;

	public Common(Handler mHandler, POSManage pm, String mStr) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.mStr = mStr;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		String r = pm.OrderSend(mStr);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E1);
		Utils.HandData(mHandler, r, 0xA1E1);
	}

}
