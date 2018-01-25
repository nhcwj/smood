package com.oslove.smood;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import db.DBOpenHelper;

public class LoginActivity extends Activity {

	private DBOpenHelper helper;
	private SQLiteDatabase db;
	
	EditText edit1,edit2;
	Button button1,button2,btn1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		button1 = (Button) findViewById(R.id.button1);  //注册按钮
		button2 = (Button) findViewById(R.id.button2);  //登录按钮
		edit1 = (EditText) findViewById(R.id.editText1);  //用户名
		edit2 = (EditText) findViewById(R.id.editText2);  //密码
		
		helper = new DBOpenHelper(LoginActivity.this);
		db = helper.getReadableDatabase();
		
		button1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
	    });
		
		button2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				String userphone = edit1.getText().toString();
				String password = edit2.getText().toString();
				
				if(userphone.isEmpty() || password.isEmpty()) {
					Toast.makeText(LoginActivity.this, "请输入完整的用户信息",Toast.LENGTH_SHORT).show();
					return;
				}
				
				String sql = "select * from tb_user where userphone = ? and password = ?";
				Cursor cursor = db.rawQuery(sql, new String[] {userphone,password});
				
				if(cursor.moveToNext()) {
					String str = cursor.getString(cursor.getColumnIndex("username"));
					SharedPreferences sp = getSharedPreferences("userinfo", MODE_PRIVATE);
		            Editor editor = sp.edit();
		            editor.putString("userphone", userphone);
		            editor.putString("username", str);
		            editor.commit();
		    		Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
		    		Intent intent = new Intent(LoginActivity.this,liaofa.class);
					startActivity(intent); 
					finish();
				}else {
					Toast.makeText(LoginActivity.this, "用户名或密码不正确",Toast.LENGTH_SHORT).show();
				}
				edit2.setText("");
				cursor.close();
				
			}
	    });
		
	}

	
}
