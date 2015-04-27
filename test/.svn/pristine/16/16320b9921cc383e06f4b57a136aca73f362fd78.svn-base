package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 更新密钥
 * 
 * @author Fncat
 * 
 */
public class UpdateKey extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String updatekey;
	public UpdateKey(Handler mHandler, POSManage pm,String updatekey) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.updatekey = updatekey;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.Change_KEY(updatekey.replace(" ", ""));
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E14);
		Utils.HandData(mHandler, r, 0xA1E14);
	}

}
