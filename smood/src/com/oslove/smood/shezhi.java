package com.oslove.smood;

import com.oslove.smood.liaofa.Click;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class shezhi extends Activity {
	private Button  btn4,btn5,btn6;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO �Զ����ɵķ������
	super.onCreate(savedInstanceState);
	setContentView(R.layout.shezhi);
	Button btn1=(Button) findViewById(R.id.back);
	Button btn2=(Button) findViewById(R.id.tuichu);
	Button jia1=(Button)findViewById(R.id.qingchu);
	Button jia2=(Button)findViewById(R.id.gerenshezhi);
	Button jia3=(Button)findViewById(R.id.pifu);
	btn4=(Button) findViewById(R.id.riji);
	btn5=(Button) findViewById(R.id.shouye);
    btn6=(Button) findViewById(R.id.liaofa);
    btn4.setOnClickListener(new Click());
    btn5.setOnClickListener(new Click());
    btn6.setOnClickListener(new Click());
	btn1.setText("<");
	btn1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			finish();
			
			
		}});
	btn2.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			
			System.exit(0);
			
		}});
	jia1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			
			Toast.makeText(getApplicationContext(), "���������", 1).show();
			
		}});
	jia2.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			
			Toast.makeText(getApplicationContext(), "û����", 1).show();
			
		}});
	jia3.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			
			Toast.makeText(getApplicationContext(), "û����", 1).show();
			
		}});
}
class Click implements OnClickListener {
	 @Override
	 public void onClick(View v) {
	  if (v==btn4) {
		  Intent intent=new Intent(shezhi.this,shezhi.class);
		  startActivity(intent);
		  
	  } else if (v==btn5) {
		  Toast.makeText(getApplicationContext(), "û����", 1).show();
	  
	  } else if (v==btn6) {
		  Intent intent=new Intent(shezhi.this,liaofa.class);
		  startActivity(intent);
		  finish();
	  
	  } 
	 }
}
}
