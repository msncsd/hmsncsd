package com.example.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

	private ImageView imgView;
	ImageProcess imgPrcs=new ImageProcess();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgView=(ImageView)findViewById(R.id.selectImg);
	}

	public void mOnClick(View v){
		switch(v.getId()){
		case R.id.loadImg:
			Intent intent=imgPrcs.setIntent();
			//갤러리 뜸. 이미지 선택하면 OnActivityResult 메서드 호출됨.
			startActivityForResult(intent,0);
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//이미지 선택되면 호출
	protected void onActivityResult(int requestCode, int resultCode, Intent intent){
		switch (requestCode){
		case 0 :
			ContentResolver cr=getContentResolver();
			Bitmap bitMap=imgPrcs.getBitMap(cr, intent);
			imgView.setImageBitmap(bitMap);
			break;
		default:
			break;
		}
	}

}
