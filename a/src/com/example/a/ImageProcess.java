package com.example.a;

import java.io.FileNotFoundException;
import java.io.IOException;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Images;


public class ImageProcess {

	//선택된 이미지를 화면에 출력
	public Bitmap getBitMap(ContentResolver cr, Intent intent){
		Bitmap bitMap=null;
		Uri imgUri=intent.getData();
		try{
			bitMap=Images.Media.getBitmap(cr, imgUri);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		return bitMap;
	}

	public Intent setIntent() {
		Intent intent=new Intent(Intent.ACTION_PICK);
		intent.setType(Images.Media.CONTENT_TYPE);
		intent.setData(Images.Media.EXTERNAL_CONTENT_URI);
		return intent;
	}
	
	//선택된 이미지 정사각형으로 편집
	public Bitmap reSizeBitMap(Bitmap bitMap){
		int bitMapWidth=bitMap.getWidth();
		int bitMapHeight=bitMap.getHeight();
		
		if(bitMapWidth>bitMapHeight){
			bitMap=Bitmap.createBitmap(bitMap,0,0,bitMapHeight,bitMapHeight);
		} else{
			bitMap=Bitmap.createBitmap(bitMap,0,0,bitMapWidth,bitMapWidth);
		}
		return bitMap;
	}
	
}
