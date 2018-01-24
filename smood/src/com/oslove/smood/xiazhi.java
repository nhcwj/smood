package com.oslove.smood;



import com.oslove.smood.liaofa.Click;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class xiazhi extends Activity{
	private Button  btn4,btn5,btn6;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO 自动生成的方法存根
	super.onCreate(savedInstanceState);
	setContentView(R.layout.xiazhi);
	Button btn1=(Button) findViewById(R.id.back);
	Button btn2=(Button) findViewById(R.id.kaishi);
	btn4=(Button) findViewById(R.id.riji);
	btn5=(Button) findViewById(R.id.shouye);
    btn6=(Button) findViewById(R.id.liaofa);
	btn1.setText("<");btn4.setOnClickListener(new Click());
    btn5.setOnClickListener(new Click());
    btn6.setOnClickListener(new Click());
	btn2.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO 自动生成的方法存根
			Intent intent=new Intent(xiazhi.this,xiazhi2.class);
			startActivity(intent);
			finish();
		}
		
	});
	btn1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO 自动生成的方法存根
	finish();
		}
		
	});
}
class Click implements OnClickListener {
	 @Override
	 public void onClick(View v) {
	  if (v==btn4) {
		  Intent intent=new Intent(xiazhi.this,shezhi.class);
		  startActivity(intent);
		  
	  } else if (v==btn5) {
		  Toast.makeText(getApplicationContext(), "没开发", 1).show();
	  
	  } else if (v==btn6) {
		  //Intent intent=new Intent(xiazhi.this,liaofa.class);
		  //startActivity(intent);
		  //finish();
	  
	  } 
	 }
}
}
