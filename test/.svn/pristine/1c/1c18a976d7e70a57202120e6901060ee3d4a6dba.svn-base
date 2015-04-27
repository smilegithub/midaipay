package com.fncat.xswipe.a_thread;

import java.text.SimpleDateFormat;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.fncat.xswipe.utils.Utils;
import com.fncat.xswipe.controller.POSManage;

/**
 * 获取IC卡 55数据 非55数据
 * @author Zou
 *
 */
public class GetICData extends Thread {

	private String[] bankIcCard55Data = new String[1];
	private String[] bankIcCardNo55Data = new String[1];

	private Handler mHandler;
	private POSManage pm;

	public GetICData(Handler handler, POSManage pm, String[] bankIcCard55Data,
			String[] bankIcCardNo55Data) {
		this.mHandler = handler;
		this.pm = pm;
		this.bankIcCard55Data = bankIcCard55Data;
		this.bankIcCardNo55Data = bankIcCardNo55Data;
	}

	@Override
	public void run() {
		String time = getFormatTime();
		String yymmdd = getYYMMDD();
		String hhmmss = time.substring(4);

		int flag = pm.getIcCard55Data("0", yymmdd, hhmmss, (byte) 0x01, bankIcCard55Data);
		if (flag != 0 || bankIcCard55Data[0] == null) {
			mHandler.sendEmptyMessage(-5);
			return;
		}

		// pm.getBankIcCardNo55Data("0000000000000000".getBytes(),
		// bankIcCardNo55Data);
		// Log.d("GetICData", "No55Data = " + bankIcCardNo55Data[0]);
		// if (bankIcCardNo55Data[0] != null &&
		// !bankIcCardNo55Data[0].equals("")
		// && bankIcCardNo55Data[0].length() > 15 && bankIcCard55Data[0] != null
		// && bankIcCard55Data[0].length() > 15 &&
		// !bankIcCard55Data[0].equals("")) {
		//
		// } else {
		// mHandler.sendEmptyMessage(-6);
		// return;
		// }

		Message msg = Message.obtain(mHandler);
		msg.what = 0xA1F00;
		msg.sendToTarget();
	}

	/**
	 * 获取格式化的时间
	 *
	 * @return MMddHHmmss
	 */
	public static String getFormatTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		String time = sdf.format(new java.util.Date());
		Log.i("ts", "我是格式化时间:" + time);
		return time;
	}

	public static String getYYMMDD() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new java.util.Date());
		return time.substring(2);
	}
}
