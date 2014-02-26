package com.seu.bigocto.setting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.seu.bigocto.R;
import com.seu.bigocto.mainframe.MainFrameActivity;
import com.seu.bigocto.mainframe.MainUrl;
import com.seu.bigocto.setting.SettingLoginActivity.MyHandler;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingRegisterActivity extends Activity{

	EditText re_name;
	EditText re_password;
	EditText re_password2;
	EditText re_Email;
	EditText re_phone;
	EditText re_postalAdress;
	Button re_button;
	String name,password,password2,Email,phone,postalAddress;
	mHandle myHandler=new mHandle();//初始化Handler
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_register_activity);
		this.setTitle("注册");
		
		re_name=(EditText)findViewById(R.id.set_register_name);
		re_password=(EditText)findViewById(R.id.set_register_password);
		re_password2=(EditText)findViewById(R.id.set_register_password2);
		re_Email=(EditText)findViewById(R.id.set_register_address);
		re_phone=(EditText)findViewById(R.id.set_register_phone);
		re_postalAdress=(EditText)findViewById(R.id.set_register_postalAddress);
		re_button=(Button)findViewById(R.id.set_register_button);
		


		re_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				name=re_name.getText().toString();
				password=re_password.getText().toString();
				password2=re_password2.getText().toString();
				Email=re_Email.getText().toString();
				phone=re_phone.getText().toString();
				postalAddress=re_postalAdress.getText().toString();
				
				Log.d("输入内容",name+password+password2+Email);
				if(name.isEmpty()||password.isEmpty()||password2.isEmpty()||Email.isEmpty()){
					Toast toast=Toast.makeText(SettingRegisterActivity.this, "有注册内容未填写", Toast.LENGTH_SHORT);
					toast.show();
				}else{
				if(password.indexOf(password2)<0){
					Toast toast=Toast.makeText(SettingRegisterActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT);
				toast.show();
				}else{
					ReMyThread th=new ReMyThread();
					th.start();
			}}
		}
		});
		
		
	}

	
	public class mHandle extends Handler{

		@Override
		public void handleMessage(Message msg) {
			String str = (String) msg.obj;
			Toast.makeText(SettingRegisterActivity.this, "注册："+str, Toast.LENGTH_LONG).show();
			String value1="success";
			if(str.indexOf(value1)>=0){
				Intent intent=new Intent(SettingRegisterActivity.this,MainFrameActivity.class);
				startActivity(intent);
			}
		}
		
	}
	public class ReMyThread extends Thread{

		@Override
		public void run() {
			try{
				
				name=re_name.getText().toString();
				password=re_password.getText().toString();
				password2=re_password2.getText().toString();
				Email=re_Email.getText().toString();
				phone=re_phone.getText().toString();
				postalAddress=re_postalAdress.getText().toString();
				
				DefaultHttpClient client = new DefaultHttpClient();  
	            List<NameValuePair> list = new ArrayList<NameValuePair>();  
	            NameValuePair pair1 = new BasicNameValuePair("name",name);  

	            NameValuePair pair2 = new BasicNameValuePair("password",password);
	            NameValuePair pair3=new BasicNameValuePair("Email",Email);
	            NameValuePair pair4=new BasicNameValuePair("phone",phone);
	            NameValuePair pair5=new BasicNameValuePair("PostalAddress",postalAddress);
	            list.add(pair1);  
	            list.add(pair2);  
	            list.add(pair3);
	            list.add(pair4);
	            list.add(pair5);
	            
	            Log.e("数据穿入",name);
	            
	            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
	        	
	            MainUrl url=new MainUrl();
	            HttpPost post = new HttpPost(url.getSETTINGRESGISTER_URL());  
	            post.setEntity(entity); 
	            
	            HttpResponse response=client.execute(post); 
	            if(response.getStatusLine().getStatusCode()==200){  
	                InputStream in = response.getEntity().getContent();//接收服务器的数据，并在Toast上显示  
	                BufferedReader str = new BufferedReader(
							new InputStreamReader(in));
	                String line = null;
	                line=str.readLine();
	                
	                showMsg(line);
	            } 
	            
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void showMsg(String str){
		Message msg=new Message();
		msg.obj=str;
		msg.setTarget(myHandler);
		msg.sendToTarget();
		Log.d("aaaaaaaa",str);
		
	}
	
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
