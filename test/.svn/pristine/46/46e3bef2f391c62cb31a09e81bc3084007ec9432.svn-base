package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * IC卡复位
 * 
 * @author Fncat
 * @data 2014-4-24上午11:36:03
 */
public class ICReset extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String[] resetData;

	public ICReset(Handler mHandler, POSManage pm, String[] resetData) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.resetData = resetData;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.SCardReset(resetData);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E4);
		Utils.HandData(mHandler, r, 0xA1E4);
	}

}
