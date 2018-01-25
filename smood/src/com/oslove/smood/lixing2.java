package com.oslove.smood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class lixing2 extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO 自动生成的方法存根
	super.onCreate(savedInstanceState);
	setContentView(R.layout.lixing2);
	Button btn1=(Button)findViewById(R.id.back);
	btn1.setText("<");
	btn1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO 自动生成的方法存根
			Intent intent=new Intent(lixing2.this,liaofa.class);
			startActivity(intent);
			finish();
		}});
}
}
