package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 写入密钥20
 * 
 * @author Fncat
 * 
 */
public class Writekey extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String writekey20;

	public Writekey(Handler mHandler, POSManage pm, String writekey20) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.writekey20 = writekey20;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.KeyWrite(writekey20.replace(" ", ""));
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E18);
		Utils.HandData(mHandler, r, 0xA1E18);
	}

}
