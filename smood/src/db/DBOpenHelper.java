package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
	
	private static final int VERSION = 1;// �������ݿ�汾��
	private static final String DBNAME = "oslove.db";// �������ݿ���

	public DBOpenHelper(Context context) {
		super(context, DBNAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("create table tb_user(userphone varchar(20) primary key ,username varchar(20) ,useremail varchar(20) ,password varchar(20))");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
