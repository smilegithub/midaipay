package com.fncat.xswipe.a_thread;

import android.os.Handler;
import cn.com.fmsh.util.FM_Bytes;

import com.fncat.xswipe.MainActivity;
import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

/**
 * 获取设备ID
 * 
 * @author Fncat
 * @data 2014-4-24上午11:36:35
 */
public class Dever extends Thread {
	private Handler mHandler;
	private POSManage pm;

	public Dever(Handler mHandler, POSManage pm) {
		this.mHandler = mHandler;
		this.pm = pm;
	}

	@Override
	public void run() {
		long timer = System.nanoTime();
//		byte[] encryptFactor = new byte[8];// 存储服务器下发的分散因子
//		String[] data = new String[1];
//		int r = pm.getBankIcCardNo55Data(encryptFactor, data);
//		System.out.println(data[0] + ":" + r);
		int r = pm.getDeviceInfo(MainActivity.Adc, MainActivity.DevTypes, MainActivity.deviceId, MainActivity.version);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E5);
		Utils.HandData(mHandler, r, 0xA1E5);
	}

}
