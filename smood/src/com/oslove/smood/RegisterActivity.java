package com.oslove.smood;

import db.DBOpenHelper;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	
	EditText edit1,edit2,edit3,edit4;
	Button button1,button2;
	
	private DBOpenHelper helper;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		edit1 = (EditText) findViewById(R.id.editText1);  //�û��绰
		edit2 = (EditText) findViewById(R.id.editText2);  //�û��ǳ�
		edit3 = (EditText) findViewById(R.id.editText3);  //�û�����
		edit4 = (EditText) findViewById(R.id.editText4);  //����
		button1 = (Button) findViewById(R.id.register_button);  //ע��
		button2 = (Button) findViewById(R.id.back);  //����
		button2.setText("<");
		helper = new DBOpenHelper(RegisterActivity.this);
		db = helper.getWritableDatabase();
		
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				String str1 = edit1.getText().toString();
				String str2 = edit2.getText().toString();
				String str3 = edit1.getText().toString();
				String str4 = edit1.getText().toString();
				
				if(TextUtils.isEmpty(str1)&&TextUtils.isEmpty(str2)&&TextUtils.isEmpty(str3)&&TextUtils.isEmpty(str4))
				{
					Toast.makeText(RegisterActivity.this, "�������û�ע����Ϣ",
							Toast.LENGTH_SHORT).show();
				}
				else{
					
					db.execSQL("insert into tb_user(userphone,username,useremail,password) values (?,?,?,?)",new Object[]{str1,str2,str3,str4});
					finish();
					Toast.makeText(getApplicationContext(), "ע�����", 1).show();
				}
				
			}
		});
			
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				edit1.setText("");
				edit2.setText("");
				edit3.setText("");
				edit4.setText("");
				finish();
			}
		});
		
	}

	

	
}
