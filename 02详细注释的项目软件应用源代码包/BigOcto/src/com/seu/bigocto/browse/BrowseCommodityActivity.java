package com.seu.bigocto.browse;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.seu.bigocto.R;
import com.seu.bigocto.mainframe.MainUrl;
import com.seu.bigocto.setting.SettingLoginActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BrowseCommodityActivity extends FragmentActivity{
	Bundle bundle;
	JSONArray jsonArray;
	Context context;
	MyHandle myHandler;
	TextView com_comment_content;
	ImageView com_image;
	
	MyHandle2 myHandler2;
	SharedPreferences.Editor editor;
	SharedPreferences sharedata ;//数据存储
	
	String login_data;//登陆状态
	String login_name_data;//登陆名
	String login_name_password;
	String book_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browse_commodity_activity);
		setTitle("图书详情");
		myHandler=new MyHandle();
		myHandler2=new MyHandle2();
		bundle=this.getIntent().getExtras();//获取bundle
		
		initView();
		ComMythread th=new ComMythread();
		th.start();
		

	}
	
	public void initView(){
		
		TextView com_name=(TextView)findViewById(R.id.commodity_name);
		com_name.setText(bundle.getString("loc_name"));
		TextView com_author=(TextView)findViewById(R.id.commodity_author);
		com_author.setText("     "+bundle.getString("loc_author"));
		TextView com_price=(TextView)findViewById(R.id.commodity_price);
		com_price.setText("     ￥"+bundle.getString("loc_price"));
		com_comment_content=(TextView)findViewById(R.id.commodity_content);
		com_image=(ImageView)findViewById(R.id.commodity_image);
		
	}
	

	
	public class ComMythread extends Thread{
		public void run(){
			
			try{
			DefaultHttpClient client=new DefaultHttpClient();
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			NameValuePair pair1=new BasicNameValuePair("commodity_detail",bundle.getString("loc_id"));
			list.add(pair1);
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
			
			MainUrl url=new MainUrl();
			HttpPost post = new HttpPost(url.getCONTENT_DETAIL());
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
	        
	        Log.d("commodity JsonArray:",""+jsonArray+"");
	        
	        String[] imageurl=new String[jsonArray.length()];
	        
	        for(int i=0;i<jsonArray.length();i++){
	        
	        imageurl=ImageArray(jsonArray);
	        
			JSONObject json=jsonArray.getJSONObject(i);
			
			imageurl[i] = json.getString("imageUrl");
			 Log.d("图片链接",""+imageurl[i]);
		
	        }
	        
	        Bitmap bitmap;
	        
	        
	        Bitmap pic =null;  
	        Log.d("commodity图片",""+imageurl[0]);
	        
		    HttpPost get = new HttpPost(url.getDETAIL_IAMGE_URL()+imageurl[0]);  
		    Log.e("发送","成功2");
		    HttpClient client1 = new DefaultHttpClient();  
		   
	        HttpResponse response1 = client1.execute(get);  
	        HttpEntity entity1 = response1.getEntity();  
	        InputStream is = entity1.getContent();  
	        
	        pic = BitmapFactory.decodeStream(is);   // 关键是这句代码  
	        
	        bitmap=pic;
	        User user=new User();

			user.json=jsonArray;
			user.map=bitmap;
			
			showMsg(user);

		
		}catch(Exception e){
			
		}
		}
	}
	
	class MyHandle extends Handler{
		
		@Override
		public void handleMessage(Message msg) {
			
			User user1=new User();
			user1=(User) msg.obj;
			JSONArray json1=user1.json;
			Bitmap mapArray;
			mapArray=user1.map;
			

			JSONObject json;
			String loc_content=null;
			try {
				json = json1.getJSONObject(0);
				loc_content=json.getString("content");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			com_comment_content.setText(loc_content);
			Log.e("内容",loc_content);
			Log.e("获取图片","00");
			com_image.setImageBitmap(mapArray);
			
			
		}
	
		
	}
	
	public class User{
		private JSONArray json;
		private Bitmap map;
	}
	
	public String[] ImageArray(JSONArray array) throws JSONException{
		
		String[] mapurl=new String[array.length()];
		
		for(int i = 0;i<array.length();i++){

			JSONObject json=array.getJSONObject(i);
			mapurl[i]=json.getString("imageUrl");
		
		}
		return mapurl;
	}
	
	private void showMsg(User str){
		Message msg = Message.obtain();
		
		msg.obj = str;
		msg.setTarget(myHandler);//把message内容放入，handle
		msg.sendToTarget();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		ActionBar actionbar=getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
	}
	
   
   @Override  
   public boolean onCreateOptionsMenu(Menu menu)  
   {  
       MenuInflater inflater = getMenuInflater();  
       inflater.inflate(R.menu.mainframe_menu, menu);  
       
       return true;  
   } 
	
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       super.onOptionsItemSelected(item);
       if(item.getItemId() == android.R.id.home)
       {
           finish();
           return true;
       }
       
       switch(item.getItemId())//得到被点击的item的itemId
       {
       case R.id.mianframe_title_shoppingcart:
       		{
       			MyAddShopThread th=new MyAddShopThread();
	    	   th.start();
	    	   break;
       		}
//       case R.id.mianframe_title_shoppingrefresh:
//       {
//  			MyAddShopThread th=new MyAddShopThread();
//  			th.start();
//  			break;
//       }
   }
	return true;
   }
   
   
   class MyAddShopThread extends Thread{
	   public void run(){
		   try{
				sharedata=getSharedPreferences("login_info",0);
				
				login_data= sharedata.getString("success","");//登陆状态
				login_name_data=sharedata.getString("name","");//登陆名
				login_name_password=sharedata.getString("password", "");
				book_id=bundle.getString("loc_id");
				DefaultHttpClient client = new DefaultHttpClient();  
	            List<NameValuePair> list = new ArrayList<NameValuePair>();  
	            NameValuePair pair1 = new BasicNameValuePair("name",login_name_data);  
	            NameValuePair pair2 = new BasicNameValuePair("password",login_name_password);
	            NameValuePair pair3 = new BasicNameValuePair("bookid",book_id);
	            Log.e("book_id",book_id);
	            list.add(pair1);  
	            list.add(pair2);  
	            list.add(pair3);
	            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
	        	
	            MainUrl url=new MainUrl();
	            HttpPost post = new HttpPost(url.getCOMMODITY_COLLECTION_URL());  
	            
	            post.setEntity(entity); 
	            
	            HttpResponse response = client.execute(post);  
	              
	            if(response.getStatusLine().getStatusCode()==200){  
	                InputStream in = response.getEntity().getContent();//接收服务器的数据，并在Toast上显示  
	                BufferedReader str = new BufferedReader(
							new InputStreamReader(in));
	                String line = null;
	                line=str.readLine();
	                
	                showMsg2(line);
	            } 
			   
	           View view=(View)findViewById(R.layout.collection_main_fragment);
			   view.postInvalidate();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
   }
   
   public void showMsg2(String str){
		Message msg = Message.obtain();
		
		msg.obj = str;
		msg.setTarget(myHandler2);//把message内容放入，handle
		msg.sendToTarget();
   }
   
	class MyHandle2 extends Handler{
		
		@Override
		public void handleMessage(Message msg) {
			
			String str=(String) msg.obj; 
			Toast.makeText(BrowseCommodityActivity.this,"收藏状态："+str, Toast.LENGTH_LONG).show();

		}
	
		
	}
}
