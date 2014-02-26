package com.seu.bigocto.setting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.seu.bigocto.R;
import com.seu.bigocto.mainframe.MainUrl;
import com.seu.bigocto.setting.SettingMyInfoActivity.InfoMyThread;
import com.seu.bigocto.setting.SettingMyInfoActivity.MyHandle;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class SettingAccountActivity extends Activity{
	
	SharedPreferences.Editor editor;
	SharedPreferences sharedata ;//数据存储
	Context context;
	String login_data;
	String login_name_data;
	String login_password_data;
	JSONArray jsonArray;
	MyHandle handle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_account_activity);
		setTitle("个人账户");
		Log.e("Info 发送","成功");
		
		sharedata=getSharedPreferences("login_info",0);
		sharedata =getSharedPreferences("login_info", 0);
		
		handle=new MyHandle();
		
		login_data= sharedata.getString("success","");//登陆状态
		login_name_data=sharedata.getString("name","");//登陆名
		login_password_data=sharedata.getString("password", "");
		
		Log.e("Info 发送",login_data);
		
		InfoMyThread th=new InfoMyThread();
		th.start();

		
	}
	
	public class InfoMyThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				
				DefaultHttpClient client = new DefaultHttpClient();  
		        List<NameValuePair> list = new ArrayList<NameValuePair>();  
		        NameValuePair pair1 = new BasicNameValuePair("name",login_name_data);
		        NameValuePair pair2 = new BasicNameValuePair("password",login_password_data); 
		        list.add(pair1);
		        list.add(pair2);
		        
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
				
				MainUrl url=new MainUrl();
				
				Log.e("Info 发送",url.getSETTINGMYINFO_URL());
				HttpPost post = new HttpPost(url.getSETTINGMYINFO_URL());
				post.setEntity(entity);
				
				HttpResponse response=client.execute(post);
				InputStream isr=response.getEntity().getContent();
				BufferedReader br=new BufferedReader(new InputStreamReader(isr,"gbk"));
				
				String line=null;
				StringBuffer sb=new StringBuffer();
				while((line=br.readLine())!=null){
					sb.append(line);
				}
		       
				jsonArray=new JSONArray(sb.toString());
				
				Log.d("个人信息jsonArray",jsonArray.toString());
				
				showMeg(jsonArray);
			}catch(Exception e){
				
			}
		}

		private void showMeg(JSONArray jsonArray) {
			// TODO Auto-generated method stub
			Message msg=Message.obtain();
			msg.obj=jsonArray;
			msg.setTarget(handle);
			msg.sendToTarget();
		}
		
	}
	
	public class MyHandle extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			JSONArray jsonarray=(JSONArray) msg.obj;
			JSONObject Jsonobj;
			
				try {
					Jsonobj=jsonarray.getJSONObject(0);
					
					Log.d("个人信息",Jsonobj.toString());
					
					TextView acc_name2=(TextView)findViewById(R.id.acc_name);
					acc_name2.setText(Jsonobj.getString("realname"));
					
					Log.d("个人信息",Jsonobj.getString("realname"));
					TextView acc_grade2=(TextView)findViewById(R.id.acc_grade);
					acc_grade2.setText(Jsonobj.getString("level"));
					
					TextView acc_point2=(TextView)findViewById(R.id.acc_point);
					acc_point2.setText(Jsonobj.getString("point"));
					
					TextView acc_money2=(TextView)findViewById(R.id.acc_money);
					acc_money2.setText(Jsonobj.getString("balance"));
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		}
}
