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
		//1�õ�һ��notificationManager
		//�õ�һ��notification�ķ���
		 NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		 //2Instantiate  the Notification
		 Notification  notification=new Notification(R.drawable.ic_launcher, "tickerText", System.currentTimeMillis());
		 
		 notification.sound=Uri.fromFile(new File("/sdcard/haha.mp3"));//ָ������
		 notification.flags=Notification.FLAG_AUTO_CANCEL;//notification��ʾ���Զ����
		 notification.flags=Notification.FLAG_NO_CLEAR;//notificationͼ����Զ����
		 notification.vibrate=new long[]{1000,200,1000};
		 
		 
		 
		 //3define the  notification's manager and RendingIntent//pendingIntnet���ڵ���ͼ
		 Intent intent=new Intent(this,MainActivity.class);
		 PendingIntent contentIntent=PendingIntent.getActivity(this, 0, intent , 0);
		 notification.setLatestEventInfo(this, "notife ����", "notification ����",contentIntent);
		 //pass the Notification to  the notificatiion 
		 manager.notify(0, notification);
	}
}
