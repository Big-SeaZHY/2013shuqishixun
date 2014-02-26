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
import com.seu.bigocto.browse.BrowseCommodityActivity;
import com.seu.bigocto.mainframe.MainUrl;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class SettingMyInfoActivity extends Activity{
	
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
		setContentView(R.layout.setting_info_activity);
		setTitle("个人基本信息");
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
	
	public void getLoginData(){
		sharedata=getSharedPreferences("login_info",0);
		
		login_data= sharedata.getString("success","");//登陆状态
		login_name_data=sharedata.getString("name","");//登陆名
		login_password_data=sharedata.getString("password", "");
		
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
			
//			if(login_data.equals("false")){
//				Toast toast=Toast.makeText(SettingMyInfoActivity.this,"未登录", Toast.LENGTH_SHORT);
//				toast.show();
//				Intent intent=new Intent(SettingMyInfoActivity.this,BrowseCommodityActivity.class);
//				intent.putExtras(intent);
//				
//			}else{
//				
//
				try {
					Jsonobj=jsonarray.getJSONObject(0);
					
					Log.d("个人信息",Jsonobj.toString());
					
					TextView info_name2=(TextView)findViewById(R.id.info_name_value);
					info_name2.setText(Jsonobj.getString("realname"));
					
					Log.d("个人信息",Jsonobj.getString("realname"));
					TextView info_sex2=(TextView)findViewById(R.id.info_sex_value);
					info_sex2.setText(Jsonobj.getString("sex"));
					TextView info_birthday2=(TextView)findViewById(R.id.info_birthday_value);
					info_birthday2.setText(Jsonobj.getString("birthday"));
					TextView info_phone2=(TextView)findViewById(R.id.info_phone_value);
					info_phone2.setText(Jsonobj.getString("phone"));
					TextView info_Idcard2=(TextView)findViewById(R.id.info_IDcard_value);
					info_Idcard2.setText(Jsonobj.getString("IDcard"));
					TextView info_address2=(TextView)findViewById(R.id.info_address_value);
					info_address2.setText(Jsonobj.getString("home"));
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		}
		
		
	//}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		ActionBar actionbar=getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
	}
	
   @Override
   public boolean onOptionsItemSelected(MenuItem item)
    {
        // TODO Auto-generated method stub
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
