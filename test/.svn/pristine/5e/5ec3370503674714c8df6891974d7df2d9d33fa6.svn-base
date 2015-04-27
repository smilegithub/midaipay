package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 电卡购电
 * 
 * @author Fncat
 * @data 2014-4-24上午11:37:44
 */
public class IC extends Thread {
	private Handler mHandler;
	private POSManage pm;

	public IC(Handler mHandler, POSManage pm) {
		this.mHandler = mHandler;
		this.pm = pm;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		String r = "电卡类型" + pm.SG_GetCardType() + "电卡序列号" + pm.SG_GetCardSN();
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E7);
		Utils.HandData(mHandler, r, 0xA1E7);
	}

}
