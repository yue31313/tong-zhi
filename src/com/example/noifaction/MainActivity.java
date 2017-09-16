package com.example.noifaction;

import java.io.File;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	public void click(View view){
		//1得到一个notificationManager
		//得到一个notification的服务
		 NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		 //2Instantiate  the Notification
		 Notification  notification=new Notification(R.drawable.ic_launcher, "tickerText", System.currentTimeMillis());
		 
		 notification.sound=Uri.fromFile(new File("/sdcard/haha.mp3"));//指定声音
		 notification.flags=Notification.FLAG_AUTO_CANCEL;//notification显示完自动清空
		 notification.flags=Notification.FLAG_NO_CLEAR;//notification图标永远存在
		 notification.vibrate=new long[]{1000,200,1000};
		 
		 
		 
		 //3define the  notification's manager and RendingIntent//pendingIntnet延期的意图
		 Intent intent=new Intent(this,MainActivity.class);
		 PendingIntent contentIntent=PendingIntent.getActivity(this, 0, intent , 0);
		 notification.setLatestEventInfo(this, "notife 标题", "notification 正文",contentIntent);
		 //pass the Notification to  the notificatiion 
		 manager.notify(0, notification);
	}
}
