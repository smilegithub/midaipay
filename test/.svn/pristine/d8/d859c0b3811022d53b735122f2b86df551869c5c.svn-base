package com.fncat.xswipe.a_thread;

import android.os.Handler;
import cn.com.fmsh.util.FM_Bytes;

import com.fncat.xswipe.MainActivity;
import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * IC卡数据传输
 * 
 * @author Fncat
 * @data 2014-4-24上午11:35:34
 */
public class ICData extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String mStr;

	public ICData(Handler mHandler, POSManage pm, String mStr) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.mStr = mStr;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
		int r = pm.SCardTransmit(FM_Bytes.hexStringToBytes(mStr), MainActivity.recvbuf, 6000);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E3);
		Utils.HandData(mHandler, r, 0xA1E3);
	}

}
