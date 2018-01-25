package com.oslove.smood;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.oslove.smood.liaofa.Click;
import com.oslove.smood.toubu2.MyPlayerOnCompletionListener;

public class xiazhi2 extends Activity {
	private Button  btn4,btn5,btn6;
	private VideoView videoView ;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO 自动生成的方法存根
	super.onCreate(savedInstanceState);
	setContentView(R.layout.xiazhi2);
	Button btn1=(Button) findViewById(R.id.back);
	Button btn2=(Button) findViewById(R.id.jiesu);
	btn4=(Button) findViewById(R.id.riji);
    btn6=(Button) findViewById(R.id.liaofa);
    btn4=(Button) findViewById(R.id.riji);
	btn5=(Button) findViewById(R.id.shouye);
    btn6=(Button) findViewById(R.id.liaofa);btn4.setOnClickListener(new Click());
    btn5.setOnClickListener(new Click());
    btn6.setOnClickListener(new Click());
	btn1.setText("<");
	btn1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO 自动生成的方法存根
	finish();
		}
		
	});
	btn2.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO 自动生成的方法存根
			Intent intent=new Intent(xiazhi2.this,EmulateActivity.class);
			startActivity(intent);
	   //Intent intent=new Intent(toubu2.this,)
			finish();
		}
		
	});
	
	   
    Uri uri = Uri.parse("http://qingxuxiangmu-1253727250.cosgz.myqcloud.com/%E8%85%BF%E9%83%A8%E6%94%BE%E6%9D%BE1920x1080.mp4");
 
    videoView = (VideoView)this.findViewById(R.id.videoView1);
    //videoView.setLayoutParams(new RelativeLayout.LayoutParams(400,200));
    videoView.setMediaController(new MediaController(this));
    videoView.setOnCompletionListener( new MyPlayerOnCompletionListener());
    videoView.setVideoURI(uri);
    videoView.start();
}
class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {
	 
    @Override
    public void onCompletion(MediaPlayer mp) {
      Toast.makeText(xiazhi2.this, "播放完成了", Toast.LENGTH_SHORT).show();
    }
  }
class Click implements OnClickListener {
	 @Override
	 public void onClick(View v) {
	  if (v==btn4) {
		  Intent intent=new Intent(xiazhi2.this,shezhi.class);
		  startActivity(intent);
		  
	  } else if (v==btn5) {
		
		  Toast.makeText(getApplicationContext(), "没开发", 1).show();
	  } else if (v==btn6) {
		  Intent intent=new Intent(xiazhi2.this,liaofa.class);
		  startActivity(intent);
		  finish();
	  
	  } 
	 }
}
}
