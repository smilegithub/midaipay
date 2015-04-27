package com.fncat.xswipe;

import java.util.Map;
import java.util.TreeMap;

import com.fncat.xswipe.controller.ErrorCode;

public class ErrorHint {
	public static Map<Integer, String> errorMap = new TreeMap<Integer, String>();

	// "~错误码：" + Msg;
	public static void InitErrorMsg() {
		if (errorMap.size() == 0) {
			errorMap.put(ErrorCode.SUCCESS, "执行成功！");
			errorMap.put(ErrorCode.COMMAND_NOT_IMPLEMENTED, "命令未执行！");
			errorMap.put(ErrorCode.SECRET_KEY_IS, "密钥已经存在！");
			errorMap.put(ErrorCode.PARAMETER_IS_ERROR, "输入参数错误！");
			errorMap.put(ErrorCode.SECRET_KEY_NO, "密钥不存在！");
			errorMap.put(ErrorCode.ENCRYPT_FAIL, "加密失败！");
			errorMap.put(ErrorCode.NOT_SWIPE_CARD, "未刷卡！");
			errorMap.put(ErrorCode.SWIPE_CARD_FAIL, "刷卡失败！");
			errorMap.put(ErrorCode.DEVICE_IS_OPEN, "刷卡器已打开！");
			errorMap.put(ErrorCode.RECV_DATA_NOT_ENOUGH, "接受数据长度不够！");
			errorMap.put(ErrorCode.RECV_DATA_ERROR, "将接受数据错误，获取为null！");
			errorMap.put(ErrorCode.ERR_DEVICE_UNKOWN, "设备没初始化！");
			errorMap.put(ErrorCode.NOT_SWIPER_LISTENER, "未启动刷卡监听！");
			errorMap.put(ErrorCode.INPUT_PARAMS, "参数长度不够！");
			errorMap.put(ErrorCode.UNKNOW_ERROR, "未知错误！");
			errorMap.put(ErrorCode.SYSTEM_BUSY, "硬件正在工作中！");
			errorMap.put(ErrorCode.GET_DEVICE_INFO_FAIL, "获取设备信息失败！");
			errorMap.put(ErrorCode.CRC_ERROR, "CRC错误！");
			errorMap.put(ErrorCode.NOT_OPEN_DEVICE, "没有调用打开刷卡接口！");

			errorMap.put(ErrorCode.AudioManager_NULL, "音频初始化失败！");
			errorMap.put(ErrorCode.brand_NULL, "手机型号获取为空！");
			errorMap.put(ErrorCode.brand_nothing, "该手机型号没有适配！");
			errorMap.put(ErrorCode.powerDevice_ERROR, "设备上电/关闭异常！");
			errorMap.put(ErrorCode.Device_encrypt_NULL, "获取卡磁为null！");
			errorMap.put(ErrorCode.Device_encrypt_1, "轮询超过指定次数获取卡磁！");
			errorMap.put(ErrorCode.Device_Card_NULL, "获取卡号为null！");
			errorMap.put(ErrorCode.Common_Interrupt, "中断！");
			errorMap.put(ErrorCode.Common_TIMEOUT, "超时！");

			errorMap.put(ErrorCode.VOID_PACKAGE, "空包，一般单片机用来告知手机发送的请求成功接受，但是没有需要的数据");
			errorMap.put(ErrorCode.DATA_INCOMPLETE, "数据接受结束后，接受的数据不全而导致错误");
			errorMap.put(ErrorCode.DATA_LOST, "在解析音频数据的时候，发现有数据无法解析而导致数据丢失");
			errorMap.put(ErrorCode.CAPTRUE_HEAD_FAILED, "一直捕获不到前导 尝试超过次数");
			errorMap.put(ErrorCode.READ_WAV_TIMEOUT, "录取音频的时候一直没有有效音频数据出现，超时");
			errorMap.put(ErrorCode.AUDIO_RECORD_NOT_INIT, "record没有被初始化，联想手机上出现过权限被拦截的情况");
			errorMap.put(ErrorCode.PARSE_TIMEOUT, "解析音频数据超时");
			errorMap.put(ErrorCode.AUDIO_RECORD_IS_STOP, "录音停止了");
			errorMap.put(ErrorCode.AUDIO_TRACK_NOT_INIT, "AudioTrack没有初始化");
			errorMap.put(ErrorCode.INPUT_ERROR, "输入有错，输入的数据格式有误");
			errorMap.put(ErrorCode.WRITE_EXCEPTION, "写入音频数据异常");
			errorMap.put(ErrorCode.CANNOT_PLAY_TRACK, "不能播放音频");
			errorMap.put(ErrorCode.CHECK_FAILED, "数据校验错误");
			errorMap.put(ErrorCode.DEVICE_RECV_ERR, "单片机一直要求重发数据");
			errorMap.put(ErrorCode.MUST_NOT_CMD_NORMAL_REQUEST, "单片机不应该给手机发送CMD_NORMAL_REQUEST命令");
			errorMap.put(ErrorCode.INTERRPUTED, "工作被中断了");
			errorMap.put(ErrorCode.PROTOCAL_ERR, "在保证数据接受完全正确的前提下，协议错误，任何与协议不符的错误");
			errorMap.put(ErrorCode.NO_INPUT, "输入数据空");
			errorMap.put(ErrorCode.AUDIO_VOLUME_LIMITED, "媒体音量被系统强制减弱，请到设置里修改媒体音量至最大值");
		}
	}
}
