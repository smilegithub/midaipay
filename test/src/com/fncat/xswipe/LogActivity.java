package com.fncat.xswipe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fncat.xswipe.utils.Lw;

public class LogActivity extends Activity implements OnClickListener {
	private TextView log;
	private ScrollView scro;
	private boolean s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		InitLayout();
	}

	private void InitLayout() {
		scro = (ScrollView) findViewById(R.id.scro);
		log = (TextView) findViewById(R.id.log);
		// String mStr=new String(Logs.ReadLog(this).getBytes("UTF-8"),"GBK");
		s = false;
		String mStr = new String(Lw.ReadLog(this));
		log.setText(mStr);
		Button log_clear_btn = (Button) findViewById(R.id.log_clear_btn);
		log_clear_btn.setOnClickListener(this);
		Button log_export_btn = (Button) findViewById(R.id.log_export_btn);
		log_export_btn.setOnClickListener(this);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (!s && hasFocus) {
			s = true;
			// scro.smoothScrollTo(0, scro.getMeasuredHeight()*2);
			// scro.scrollBy(0,0);
			scro.fullScroll(ScrollView.FOCUS_DOWN);
			// scro.scrollTo(0, scro.getHeight());
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.log_clear_btn:
			log.setText("");
			Lw.ClearLog(this);
			break;
		case R.id.log_export_btn:
			Lw.ExportLog(this);

			break;
		}
	}

}
