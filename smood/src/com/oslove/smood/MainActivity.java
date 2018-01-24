package com.oslove.smood;

import com.oslove.smood.liaofa.Click;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
	private Button  btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn4=(Button) findViewById(R.id.riji);
    	btn5=(Button) findViewById(R.id.shouye);
        btn6=(Button) findViewById(R.id.liaofa);
        btn4.setOnClickListener(new Click());
        btn5.setOnClickListener(new Click());
        btn6.setOnClickListener(new Click());
        Button btn1=(Button) findViewById(R.id.back);
        Button btn2=(Button) findViewById(R.id.jubu);
        Button btn3=(Button) findViewById(R.id.quanshen);
        btn1.setText("<");
        btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//此处为返回界面代码
				//Intent intent=new Intent();
				Intent intent=new Intent(MainActivity.this,liaofa.class);
				startActivity(intent);
				finish();
			}});
        btn2.setOnClickListener(new OnClickListener(){

    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent intent=new Intent(MainActivity.this,jubu.class);
    			startActivity(intent);
    			finish();
    		}});
        btn3.setOnClickListener(new OnClickListener(){

    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent intent=new Intent(MainActivity.this,quanshen.class);
    			startActivity(intent);
    			finish();
    		}});
   
  
}
    class Click implements OnClickListener {
   	 @Override
   	 public void onClick(View v) {
   	  if (v==btn4) {
   		  Intent intent=new Intent(MainActivity.this,shezhi.class);
   		  startActivity(intent);
   		  
   	  } else if (v==btn5) {
   		Toast.makeText(getApplicationContext(), "没开发", 1).show();
   	  
   	  } else if (v==btn6) {
   		  Intent intent=new Intent(MainActivity.this,liaofa.class);
   		  startActivity(intent);
   		  finish();
   	  
   	  } 
   	 }
   }
 
}
