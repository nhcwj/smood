package com.oslove.smood;


import com.oslove.smood.liaofa.Click;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class cuimian2 extends Activity{
	private Button  btn4,btn5,btn6;
	private Button  btn3,btn2,btn1;
	 private SeekBar skbProgress;
	 private Player player;
	 String url="http://qingxuxiangmu-1253727250.cosgz.myqcloud.com/%E7%99%BD%E5%B0%8F%E7%99%BD%20-%20%E6%9C%80%E7%BE%8E%E6%83%85%E4%BE%A3.mp3";
	 /** Called when the activity is first created. */
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.cuimian2);
	 btn4=(Button) findViewById(R.id.riji);
		btn5=(Button) findViewById(R.id.shouye);
	    btn6=(Button) findViewById(R.id.liaofa);
	 btn2 = (Button) this.findViewById(R.id.btn2);
	 btn2.setOnClickListener(new ClickEvent());
     btn3=(Button)findViewById(R.id.jiesu);
	 btn1=(Button)findViewById(R.id.back);
	 btn1.setText("<");
	 btn4.setOnClickListener(new Click());
     btn5.setOnClickListener(new Click());
     btn6.setOnClickListener(new Click());
	 btn3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(cuimian2.this,EmulateActivity.class);
				startActivity(intent);
				finish();
				player.stop();
			}});
	   btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
				player.stop();
			}});
	 skbProgress = (SeekBar) this.findViewById(R.id.skbProgress);
	 skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
	 player = new Player(skbProgress);
	 }
	 class ClickEvent implements OnClickListener {
	 @Override
	 public void onClick(View v) {
	  if (btn2.getText().equals("| |")) {
		  player.playUrl(url);
		  btn2.setText("|>");
		  
	  } else if (btn2.getText().equals("|>")) {
		  player.pause();
		  btn2.setText("| |");
	  
	  } 
	 }

	 }
	 class Click implements OnClickListener {
		 @Override
		 public void onClick(View v) {
		  if (v==btn4) {
			  Intent intent=new Intent(cuimian2.this,shezhi.class);
			  startActivity(intent);
			  
		  } else if (v==btn5) {
			  Toast.makeText(getApplicationContext(), "没开发", 1).show();
		  
		  } else if (v==btn6) {
			  Intent intent=new Intent(cuimian2.this,liaofa.class);
			  startActivity(intent);
			  finish();
		  
		  } 
		 }
	}
	 class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
	 int progress;
	 @Override
	 public void onProgressChanged(SeekBar seekBar, int progress,
	  boolean fromUser) {
	  // 原本是(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
	  this.progress = progress * player.mediaPlayer.getDuration()
	   / seekBar.getMax();
	 }
	 @Override
	 public void onStartTrackingTouch(SeekBar seekBar) {
	 
	 }
	 @Override
	 public void onStopTrackingTouch(SeekBar seekBar) {
	  // seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
	  player.mediaPlayer.seekTo(progress);
	 }
	 }
	 @Override
	protected void onStop() {
		// TODO 自动生成的方法存根
		super.onStop();
		finish();
		player.stop();
	}
	}
