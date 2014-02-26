package com.seu.bigocto.collection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class CollectionMyThread extends Thread{
	
	Activity activity;
	String User_Name,User_password;
	Context context;
	JSONArray jsonarray;
	private MyHandle myHandler=new MyHandle();//初始化Handler
	
	public CollectionMyThread(String name,String password, Activity ac, Context cn){
		this.User_Name=name;
		this.User_password=password;
		this.activity=ac;
		this.context=cn;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			DefaultHttpClient client=new DefaultHttpClient();
			List<NameValuePair> list=new ArrayList<NameValuePair>();
			NameValuePair pair1=new BasicNameValuePair("User_name",User_Name);
			NameValuePair pair2=new BasicNameValuePair("User_password",User_password);
			list.add(pair1);
			list.add(pair2);
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
			
			MainUrl url=new MainUrl();
			HttpPost post = new HttpPost(url.getCOLLECTION_URL());
			post.setEntity(entity);
			
			HttpResponse response=client.execute(post);
			InputStream isr=response.getEntity().getContent();
			BufferedReader br=new BufferedReader(new InputStreamReader(isr,"gbk"));
			
			String line=null;
			StringBuffer sb=new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line);
			}
	       
			jsonarray=new JSONArray(sb.toString());
			
	        String[] userId=new String[jsonarray.length()];
	        for(int i=0;i<jsonarray.length();i++){
			JSONObject json=jsonarray.getJSONObject(i);
			userId[i] = json.getString("id");
		 	Log.d("id:",""+userId[i]);
	        }
	        ShowMsg(jsonarray);
			
 		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ShowMsg(JSONArray e){
		Message msg=Message.obtain();
		msg.obj=e;
		msg.setTarget(myHandler);
		msg.sendToTarget();
	}
	
	
	public class MyHandle extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			JSONArray json1=(JSONArray) msg.obj;
			ListView listview=(ListView)activity.findViewById(R.id.collect_list);
			collectMyAdapter myAdapter=new collectMyAdapter(context,json1);
			listview.setAdapter(myAdapter);
			
			listview.setOnItemClickListener(new OnItemClickListener() {
				
				
				Bundle bundle=null;
				JSONObject json;
				String loc_name;
				String loc_author;
				String loc_price;
				String loc_id;
				@Override
				public void onItemClick(AdapterView<?> arg0,
						View view, int position, long id) {
					
					
					try {
						json=jsonarray.getJSONObject(position);
						loc_name=json.getString("name");
						loc_author=json.getString("author");
						loc_price=json.getString("price");
						loc_id=json.getString("id");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					bundle=new Bundle();
					bundle.putString("loc_name", loc_name);
					bundle.putString("loc_author", loc_author);
					bundle.putString("loc_price", loc_price);
					bundle.putString("loc_id", loc_id);
					Log.e("此处跳转",loc_name);
					Intent intent=new Intent(activity,BrowseCommodityActivity.class);
					intent.putExtras(bundle);
					activity.startActivity(intent);
				}
			});
		}
		
		
		
	}
	
	
/**************set BaseAdapter********************/
	
	public class collectMyAdapter extends BaseAdapter{
		
		private LayoutInflater inflater;
		JSONArray jsonarray;
		
		public collectMyAdapter(Context c,JSONArray ar){
			this.inflater=LayoutInflater.from(c);
			this.jsonarray=ar;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return jsonarray.length();
		}
		
		@Override
		public boolean isEnabled(int position) {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			ViewHolder holder;
			if(convertView==null){
				convertView=inflater.inflate(R.layout.collect_book_list_item, null);
				
				holder=new ViewHolder();
				
				holder.collect_name=(TextView) convertView.findViewById(R.id.collect_listitem_book_name);
				holder.collect_author=(TextView) convertView.findViewById(R.id.collect_listitem_book_author);
				holder.collect_price=(TextView) convertView.findViewById(R.id.collect_listitem_book_price);
				//holder.libr_press=(TextView) convertView.findViewById(R.id.libr_listitem_book_press);
				//holder.libr_date=(TextView) convertView.findViewById(R.id.libr_listitem_book_date);
				convertView.setTag(holder);//绑定ViewHolder对象
			}
			else{
				holder=(ViewHolder)convertView.getTag();
			}
			
			String bookName = null,bookAuthor = null,bookPrice = null;
			
			List<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
			
			/******设置对应的动态数组数据*********/
			Log.d("jsonArray length():",jsonarray.length()+"");
			
			for(int i=0;i<jsonarray.length();i++){
			
			HashMap<String,String> map=new HashMap<String,String>();
			
			
			try {
				
				JSONObject obj= jsonarray.getJSONObject(i);
				bookName = obj.getString("name");
				bookAuthor = obj.getString("author");
				bookPrice = obj.getString("price");
				
				map.put("bookname", bookName);
				map.put("bookAuthor", bookAuthor);
				map.put("bookPrice", bookPrice);
				Log.d("bookname",bookName);
				
				data.add(map);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			holder.collect_name.setText(data.get(position).get("bookname").toString());
			holder.collect_author.setText(data.get(position).get("bookAuthor").toString());
			holder.collect_price.setText("￥"+data.get(position).get("bookPrice").toString());

			 return convertView;
		}
		
	}
	
	public class ViewHolder{
		public ImageView collect_photo;
		public TextView collect_name;
		public TextView collect_author;
		public TextView collect_price;
		//public TextView libr_press;
		//public TextView libr_date;
		//public Button libr_button_reserve;
	}
	
	
	

}
