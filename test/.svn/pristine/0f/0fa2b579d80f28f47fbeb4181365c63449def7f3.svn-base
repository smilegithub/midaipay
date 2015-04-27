package com.fncat.xswipe.a_thread;

import android.os.Handler;

import com.fncat.xswipe.MainActivity;
import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 金融IC卡脚本
 * 
 * @author Fncat
 * @data 2014-4-24上午11:33:22
 */
public class MoneyScript extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String mStr;

	public MoneyScript(Handler mHandler, POSManage pm, String mStr) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.mStr = mStr;
	}

	@Override
	public void run() {
		if (mStr == null || mStr.equals(""))
			mStr = "009F360201AE910AFE5577EFA8FE58E730308A0230307211860F04DA9F790A0000000500005D473EEC";
		long timer = System.nanoTime();
		int r = pm.doBankIcCardScript(mStr, (byte) 00, MainActivity.script);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E0);
		Utils.HandData(mHandler, r, 0xA1E0);
	}

}
