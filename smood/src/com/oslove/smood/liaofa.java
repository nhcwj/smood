package com.oslove.smood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class liaofa extends Activity {
	private Button  btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liaofa);
        Button btn1=(Button) findViewById(R.id.back);
         Button btn2=(Button) findViewById(R.id.xingwei);
        Button btn3=(Button) findViewById(R.id.cuimian);
         btn4=(Button) findViewById(R.id.riji);
        btn4.setOnClickListener(new Click());
        btn1.setText("<");
        btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//此处为返回界面代码
				//Intent intent=new Intent();
				//finish();
			}});
        btn2.setOnClickListener(new OnClickListener(){

    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent intent=new Intent(liaofa.this,MainActivity.class);
    			startActivity(intent);
    			finish();
    		}});
        btn3.setOnClickListener(new OnClickListener(){

    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent intent=new Intent(liaofa.this,cuimian.class);
    			startActivity(intent);
    			finish();
    		}});
        
  
}

    class Click implements OnClickListener {
    	 @Override
    	 public void onClick(View v) {
    	  if (v==btn4) {
    		  Intent intent=new Intent(liaofa.this,shezhi.class);
    		  startActivity(intent);
    		  
    	  } else if (v==btn5) {
    		
    		  Toast.makeText(liaofa.this, "没开发", 1).show();
    	  } else if (v==btn6) {
    		
    	  
    	  } 
    	 }
    }

 
}

