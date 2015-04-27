package com.fncat.xswipe;

import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

//http链接
public class HttpParam {

	public String getStringData(String mUrl, List<BasicNameValuePair> mLists, String Method, int mOvertime)  {
		String mStrData = "";
		try{
		HttpClient mHttpClient = new DefaultHttpClient();
		// 设置连接超时时间
		if (mOvertime == 0) {
			mHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
			mHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);
		} else {
			mOvertime = mOvertime * 1000;
			mHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, mOvertime);
			mHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, mOvertime);
		}
		HttpResponse mHttpResponse = null;
		if (Method == null || Method.equalsIgnoreCase("GET")) {
			StringBuffer sb = new StringBuffer(mUrl);
			if (mLists != null && !mLists.isEmpty()) {
				sb.append("?");
				for (BasicNameValuePair mList : mLists) {
					sb.append(mList.getName()).append("=").append(URLEncoder.encode(mList.getValue(), "UTF-8")).append("&");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			System.out.println(sb.toString());
			HttpGet mHttpGet = new HttpGet(sb.toString());
			mHttpResponse = mHttpClient.execute(mHttpGet);
		} else if (Method.equalsIgnoreCase("POST")) {
			HttpPost mHttpPost = new HttpPost(mUrl);
			if (mLists != null && !mLists.isEmpty()) {
				UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(mLists, "UTF-8");
				System.out.println("Post connection......");
				mHttpPost.setEntity(reqEntity);
				mHttpResponse = mHttpClient.execute(mHttpPost);
			}
		} else {
			return null;
		}
		System.out.println(mHttpResponse == null);
		System.out.println(mHttpResponse.getStatusLine().getStatusCode());
		if (mHttpResponse != null && mHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity mHttpEntity = mHttpResponse.getEntity();

			mStrData = EntityUtils.toString(mHttpEntity);
			System.out.println(mStrData);
			// InputStream mInputStream = mHttpEntity.getContent();
			// BufferedReader mBufferedReader = new BufferedReader(new
			// InputStreamReader(mInputStream, "UTF-8"));
			// StringBuilder mStringBuilder = new StringBuilder();
			// String line = null;
			// while ((line = mBufferedReader.readLine()) != null) {
			// mStringBuilder.append(line);
			// }
			// mInputStream.close();
			// mStrData = mStringBuilder.toString();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mStrData;
	}
}
