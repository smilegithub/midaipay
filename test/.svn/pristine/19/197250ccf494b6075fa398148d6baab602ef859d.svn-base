package com.fncat.xswipe.a_thread;

import android.os.Handler;
import cn.com.fmsh.util.FM_Bytes;

import com.fncat.xswipe.MainActivity;
import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 获取用户密码
 * 
 * @author Fncat
 * 
 */
public class Password extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String pin;

	public Password(Handler mHandler, POSManage pm, String pin) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.pin = pin;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.GetPinBlock(FM_Bytes.hexStringToBytes(pin), MainActivity.PIN_Block);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E15);
		Utils.HandData(mHandler, r, 0xA1E15);
	}

}
