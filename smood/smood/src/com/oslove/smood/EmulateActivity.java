package com.oslove.smood;


import java.text.SimpleDateFormat;
import java.util.Date;
import db.DBOpenHelper;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class EmulateActivity extends Activity implements OnClickListener  {
	
	ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
	Button back,submit;
	int flag = 0;
	
	private DBOpenHelper helper;
	private SQLiteDatabase db;
	
	String date = "";
	String userphone = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emulate);
		
		SharedPreferences sp = getSharedPreferences("userinfo", MODE_PRIVATE);
		userphone = sp.getString("userphone", null);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.format(new Date());
		
		helper = new DBOpenHelper(EmulateActivity.this);
		db = helper.getWritableDatabase();
		
		btn1 = (ImageButton)findViewById(R.id.btn1);
		btn2 = (ImageButton)findViewById(R.id.btn2);
		btn3 = (ImageButton)findViewById(R.id.btn3);
		btn4 = (ImageButton)findViewById(R.id.btn4);
		btn5 = (ImageButton)findViewById(R.id.btn5);
		btn6 = (ImageButton)findViewById(R.id.btn6);
		btn7 = (ImageButton)findViewById(R.id.btn7);
		btn8 = (ImageButton)findViewById(R.id.btn8);
		btn9 = (ImageButton)findViewById(R.id.btn9);
		btn10 = (ImageButton)findViewById(R.id.btn10);
		submit = (Button)findViewById(R.id.submit);
		back = (Button) findViewById(R.id.button1);
		
		back.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(EmulateActivity.this,liaofa.class);
				startActivity(intent);
				finish();
			}
	    });
		
		String sql = "select * from tb_emulate where userphone = ? and date = ?";
		Cursor cursor = db.rawQuery(sql, new String[]{userphone,date});
		if(cursor.moveToNext()) {
			Toast.makeText(EmulateActivity.this, "今天你已经评分了", Toast.LENGTH_LONG).show();
			click(cursor.getInt(cursor.getColumnIndex("score")));
			//submit.setBackgroundColor(Color.parseColor(""));
			submit.setEnabled(false);
			return;
		}
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn10.setOnClickListener(this);
		
		submit.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				if(flag == 0)
					Toast.makeText(EmulateActivity.this, "你还未评分",Toast.LENGTH_SHORT).show();
				else {
					String sql = "insert into tb_emulate values(?,?,?)";
					db.execSQL(sql, new String[]{userphone,date,String.valueOf(flag)});
					
					Toast.makeText(EmulateActivity.this, "评分成功  :" + String.valueOf(flag), Toast.LENGTH_SHORT).show();
					
		    		Intent intent = new Intent(EmulateActivity.this,liaofa.class);
					startActivity(intent);
					finish();
				}
			}
	    });
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
		case R.id.btn1:
			recovery(flag);
			btn1.setBackgroundResource(R.drawable.button1ed);
			flag = 1;
			break;
		case R.id.btn2:
			recovery(flag);
			btn2.setBackgroundResource(R.drawable.button2ed);
			flag = 2;
			break;
		case R.id.btn3:
			recovery(flag);
			btn3.setBackgroundResource(R.drawable.button3ed);
			flag = 3;
			break;
		case R.id.btn4:
			recovery(flag);
			btn4.setBackgroundResource(R.drawable.button4ed);
			flag = 4;
			break;
		case R.id.btn5:
			recovery(flag);
			btn5.setBackgroundResource(R.drawable.button5ed);
			flag = 5;
			break;
		case R.id.btn6:
			recovery(flag);
			btn6.setBackgroundResource(R.drawable.button6ed);
			flag = 6;
			break;
		case R.id.btn7:
			recovery(flag);
			btn7.setBackgroundResource(R.drawable.button7ed);
			flag = 7;
			break;
		case R.id.btn8:
			recovery(flag);
			btn8.setBackgroundResource(R.drawable.button8ed);
			flag = 8;
			break;
		case R.id.btn9:
			recovery(flag);
			btn9.setBackgroundResource(R.drawable.button9ed);
			flag = 9;
			break;
		case R.id.btn10:
			recovery(flag);
			btn10.setBackgroundResource(R.drawable.button10ed);
			flag = 10;
			break;
		default:
			break;
		}
		
	}
	
	public void click(int checked) {
		
		switch(checked) {
		case 1:
			btn1.setBackgroundResource(R.drawable.button1ed);
			break;
		case 2:
			btn2.setBackgroundResource(R.drawable.button2ed);
			break;
		case 3:
			btn3.setBackgroundResource(R.drawable.button3ed);
			break;
		case 4:
			btn4.setBackgroundResource(R.drawable.button4ed);
			break;
		case 5:
			btn5.setBackgroundResource(R.drawable.button5ed);
			break;
		case 6:
			btn6.setBackgroundResource(R.drawable.button6ed);
			break;
		case 7:
			btn7.setBackgroundResource(R.drawable.button7ed);
			break;
		case 8:
			btn8.setBackgroundResource(R.drawable.button8ed);
			break;
		case 9:
			btn9.setBackgroundResource(R.drawable.button9ed);
			break;
		case 10:
			btn10.setBackgroundResource(R.drawable.button10ed);
			break;
		}
		
	}
	
	public void recovery(int i) {
		
		switch(i) {
		case 0:
			break;
		case 1:
			btn1.setBackgroundResource(R.drawable.button1);
			break;
		case 2:
			btn2.setBackgroundResource(R.drawable.button2);
			break;
		case 3:
			btn3.setBackgroundResource(R.drawable.button3);
			break;
		case 4:
			btn4.setBackgroundResource(R.drawable.button4);
			break;
		case 5:
			btn5.setBackgroundResource(R.drawable.button5);
			break;
		case 6:
			btn6.setBackgroundResource(R.drawable.button6);
			break;
		case 7:
			btn7.setBackgroundResource(R.drawable.button7);
			break;
		case 8:
			btn8.setBackgroundResource(R.drawable.button8);
			break;
		case 9:
			btn9.setBackgroundResource(R.drawable.button9);
			break;
		case 10:
			btn10.setBackgroundResource(R.drawable.button10);
			break;
		}
		
	}
	
	

	
}