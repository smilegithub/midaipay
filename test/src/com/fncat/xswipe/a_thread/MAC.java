package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.MainActivity;
import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 获取MAC
 * 
 * @author Fncat
 * 
 */
public class MAC extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String MACdata;

	public MAC(Handler mHandler, POSManage pm, String mac) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.MACdata = mac;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.GetMAC(MACdata.replace(" ", ""), MainActivity.MAC);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E17);
		Utils.HandData(mHandler, r, 0xA1E17);
	}

}
