package com.fncat.xswipe.a_thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import cn.com.fmsh.util.FM_Bytes;

import com.fncat.xswipe.HttpParam;
import com.fncat.xswipe.MD5Util;
import com.fncat.xswipe.MainActivity;
import com.fncat.xswipe.controller.POSManage;
import com.fncat.xswipe.utils.Utils;

public class Http extends Thread {
	private Handler mHandler;
	private POSManage pm;
	private String mStrs;
	private LinearLayout dialog_data_load;
	private byte[] encTrack;
	private String passwd;
	private SimpleDateFormat sdf = new SimpleDateFormat("MMDDHHmmss");

	public Http(Handler mHandler, POSManage pm, String mStrs, LinearLayout dialog_data_load, byte[] encTrack, String passwd) {
		this.mHandler = mHandler;
		this.pm = pm;
		this.mStrs = mStrs;
		this.dialog_data_load = dialog_data_load;
		this.encTrack = encTrack;
		this.passwd = passwd;
	}

	@Override
	public void run() {
		Utils.HandData(mHandler, "密码加密中。。。", -1);
		// 密码密文
		int ErrorCode = 0;
		byte[] passByte = Utils.getPwd(passwd);// 加密1
		long timer = System.nanoTime();
		byte[] passpass = pm.encryptDigest((byte) 0x05, passByte, MainActivity.encryptFactor, MainActivity.Adc, ErrorCode);
		if (ErrorCode == 0 && passpass != null) {
			Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E11);
		} else {
			Utils.HandData(mHandler, "密码加密失败", -2);
			return;
		}
		if (dialog_data_load.getVisibility() != View.VISIBLE) {
			Utils.HandData(mHandler, "操作被中断", -2);
			return;
		}
		Log.e("卡磁", FM_Bytes.bytesToHexString(encTrack));
		byte[] zhaiyaopass = new byte[encTrack.length + passpass.length];
		System.arraycopy(encTrack, 0, zhaiyaopass, 0, encTrack.length);
		System.arraycopy(passpass, 0, zhaiyaopass, encTrack.length, passpass.length);
		byte[] nzhaiyaopass = Utils.digestEncrypt(zhaiyaopass, "SHA-1");
		byte[] xzhaiyao = new byte[16];
		System.arraycopy(nzhaiyaopass, 0, xzhaiyao, 0, xzhaiyao.length);
		Utils.HandData(mHandler, "摘要加密中。。。", -1);
		timer = System.nanoTime();
		byte[] encDigest = pm.encryptDigest((byte) 0x04, xzhaiyao, MainActivity.encryptFactor, MainActivity.Adc, ErrorCode);
		if (ErrorCode == 0 && encDigest != null) {
			Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E12);
		} else {
			Utils.HandData(mHandler, "摘要加密失败", -2);
			return;
		}
		if (dialog_data_load.getVisibility() != View.VISIBLE) {
			Utils.HandData(mHandler, "操作被中断", -2);
			return;
		}
		Utils.HandData(mHandler, "网络链接中。。。", -1);
		String mStr = getFormatTime();
		if (mStr == null || mStr.equals("")) {
			Utils.HandData(mHandler, "日期格式化错误！", -2);
			return;
		}
		List<BasicNameValuePair> mList = new ArrayList<BasicNameValuePair>();
		mList.add(new BasicNameValuePair("TrCd", "F10020"));// 交易代码
		mList.add(new BasicNameValuePair("ChlCd", "00000001"));// 渠道代码
		mList.add(new BasicNameValuePair("TrDt", mStr));// 交易时间
		mList.add(new BasicNameValuePair("userId", "12110600001"));// 用户编号
		mList.add(new BasicNameValuePair("termid", Utils.byteArray2Hex(MainActivity.deviceId)));// 终端号
		mList.add(new BasicNameValuePair("accno", Utils.byteArray2Hex(encTrack)));// 卡磁
		mList.add(new BasicNameValuePair("passwd", Utils.byteArray2Hex(passpass)));// 密码
		mList.add(new BasicNameValuePair("checkCode", Utils.byteArray2Hex(encDigest)));// 摘要密文
		mList.add(new BasicNameValuePair("MAC", MD5Util.getMD5String("F10020" + "00000001" + mStr + "12110600001" + "FsA203a3")));
		timer = System.nanoTime();
		String result = new HttpParam().getStringData(mStrs, mList, "GET", 0);
		Utils.HandData(mHandler, (System.nanoTime() - timer) / 1000000 + "毫秒", 0xA0E13);
		Utils.HandData(mHandler, result, 0xA1E13);
	}

	private String getFormatTime() {// 格式化时间
		synchronized (sdf) {
			try {
				return sdf.format(new java.util.Date());
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	}
}
