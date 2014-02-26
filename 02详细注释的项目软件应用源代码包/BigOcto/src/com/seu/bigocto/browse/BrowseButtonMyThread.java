package com.seu.bigocto.browse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint.Join;
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
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BrowseButtonMyThread extends Thread{
	
	private MyHandle myHandler=new MyHandle();//初始化Handler
	String SEARCH_VALUE;
	Activity activity;
	Context context;
	String imagePath;
	JSONArray jsonArray;
	
	MainUrl url=new MainUrl();//地址

	
	View view;
	public BrowseButtonMyThread(String value,Activity activity1,Context c) {
		// TODO Auto-generated constructor stub
		SEARCH_VALUE=value;
		activity=activity1;
		context=c;
		
	}
	public void run() {
		try{
			
			DefaultHttpClient client = new DefaultHttpClient();  
	        List<NameValuePair> list = new ArrayList<NameValuePair>();  
	        NameValuePair pair1 = new BasicNameValuePair("search_value",SEARCH_VALUE); 
	        list.add(pair1);
	        
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
			
			
			HttpPost post = new HttpPost(url.getBROWSE_URL());  
			Log.e("发送",url.getBROWSE_URL());
	        post.setEntity(entity); 
	        
	        Log.e("发送",url.getBROWSE_URL());
	        
	        HttpResponse response = client.execute(post);
	        

			InputStream isr=response.getEntity().getContent();
			BufferedReader br=new BufferedReader(new InputStreamReader(isr,"gbk"));
			
			String line=null;
			StringBuffer sb=new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line);
			}

	        jsonArray=new JSONArray(sb.toString());
	        
	        
	        Log.e("发送","成功0");
	        String[] imageurl=new String[jsonArray.length()];
	        for(int i=0;i<jsonArray.length();i++){
	        
//	        imageurl=ImageArray(jsonArray);
	        
			JSONObject json=jsonArray.getJSONObject(i);
			
			imageurl[i] = json.getString("imageUrl");
	        
			 Log.d("图片链接1",""+imageurl[i]);
	        
		
	        }
	        
	       
	        //Log.d("图片链接",""+imageAdress[1]);
	        //Log.d("图片链接",""+imageAdress[2]);
	        Log.e("发送","成功1");
	        
	        Bitmap[] bitmap=new Bitmap[jsonArray.length()];
	        
	        for(int i=0;i<jsonArray.length();i++){
	        Bitmap pic =null;  
	        Log.d("图片链接",""+imageurl[i]);
	        
		    HttpPost get = new HttpPost(url.getIMAGE_URL()+imageurl[i]);  
		    Log.e("发送","成功2");
		    HttpClient client1 = new DefaultHttpClient();  
		   

	        HttpResponse response1 = client1.execute(get);  
	        HttpEntity entity1 = response1.getEntity();  
	        InputStream is = entity1.getContent();  
	        
	        pic = BitmapFactory.decodeStream(is);   // 关键是这句代码  
	        
	        bitmap[i]=pic;

	        }

	        User user=new User();

			user.json=jsonArray;
			user.map=bitmap;
			
			showMsg(user);
		}catch(Exception e){

		}
		
	}
	


	
	class User{
		private JSONArray json;
		private Bitmap[] map=new Bitmap[jsonArray.length()];
		//private Bitmap map;
	}


//	protected List< Map<String, Object> > get_list_value(){
//		
//		ArrayList<Map<String, Object>> libr_list=new ArrayList<Map<String, Object>>();
//		Map<String, Object> map=new HashMap<String ,Object>();
//		for(int i=0;i<5;i++){
//			map.put("img",R.drawable.logo);
//			map.put("name"," "+"葵花宝典");
//			map.put("author","责任者："+"学长");
//			map.put("price",""+""+"1000刀");
//			//map.put("press","出版社："+booklist2.get(i).getPress());
//			//map.put("date","日期："+booklist2.get(i).getIsbn());
//
//			libr_list.add(map);
//		}
//		
//
//		
//		return libr_list;
//	}
/**************set BaseAdapter********************/
	
	public class broMyAdapter extends BaseAdapter{
		private LayoutInflater inflater;
		private JSONArray jsonArray;
		private Bitmap[] bit;

		public broMyAdapter(Context c,JSONArray jsonArray1,Bitmap[] bit1){
			this.inflater=LayoutInflater.from(c);
			this.jsonArray=jsonArray1;
			this.bit=bit1;
		
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return jsonArray.length();
		}

		@Override
		public Object getItem(int position) {
			return position;
			// TODO Auto-generated method stub
		
		}

		@Override
		public long getItemId(int position) {
			return position;
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder;
			if(convertView==null){
				convertView=inflater.inflate(R.layout.browse_book_list_item, null);
				
				holder=new ViewHolder();
				
				holder.bro_photo=(ImageView) convertView.findViewById(R.id.bro_listitem_book_img);
				holder.bro_name=(TextView) convertView.findViewById(R.id.bro_listitem_book_name);
				holder.bro_author=(TextView) convertView.findViewById(R.id.bro_listitem_book_author);
				holder.bro_price=(TextView) convertView.findViewById(R.id.bro_listitem_book_price);
				//holder.libr_press=(TextView) convertView.findViewById(R.id.libr_listitem_book_press);
				//holder.libr_date=(TextView) convertView.findViewById(R.id.libr_listitem_book_date);
				//holder.libr_button_reserve=(Button) convertView.findViewById(R.id.libr_listitem_book_reserve);
				convertView.setTag(holder);//绑定ViewHolder对象
			}
			else{
				holder=(ViewHolder)convertView.getTag();
			}
			
//			String[] from=new String[]{"bookImage","bookName","author","bookPrice"};
//			
			List<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
			
			String bookName=null;
			String bookAuthor=null;
			
			String bookPrice=null;
			for(int i = 0;i<jsonArray.length();i++){
				
				HashMap<String,String> map=new HashMap<String,String>();
				
				try {
					JSONObject json=jsonArray.getJSONObject(i);
					
					bookName = json.getString("name");
					bookAuthor = "作者:"+json.getString("author");
					
					bookPrice = "价格:"+json.getString("price");

					//String imageName = json.getString("image");
					//String path = json.getString("image_path");
					
					map.put("bookName", bookName);
					map.put("author", bookAuthor);
					map.put("bookPrice", bookPrice);
					map.put("bookImage", null);
					
//					if(ImageCacheUtils.isImageExistedInLocalCache(imageName, BookListActivity.this)){
//						map.put("bookImage", imageName);
//					}else{
//						AsyncBookImage asyncBookImage=new AsyncBookImage(bookName, imageName, path);
//						bookImages.add(asyncBookImage);
//					}
					data.add(map);
					
					
					
				} catch (JSONException e) {

					e.printStackTrace();
				}
			}
			 holder.bro_photo.setImageBitmap(bit[position]);
			 holder.bro_name.setText(data.get(position).get("bookName").toString());
			 holder.bro_author.setText(data.get(position).get("author").toString());
			 holder.bro_price.setText(data.get(position).get("bookPrice").toString());
			 return convertView;
		}
		
	}
	
	
	public class ViewHolder{
		public ImageView bro_photo;
		public TextView bro_name;
		public TextView bro_author;
		public TextView bro_price;
		//public TextView libr_press;
		//public TextView libr_date;
		//public Button libr_button_reserve;
	}
	
	
	class MyHandle extends Handler{
		
		public static final int SHOW_BOOK_LIST=0x0000;
		public static final int SHOW_BOOK_IMAGE=0x0001;
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			ListView listview=(ListView)activity.findViewById(R.id.bro_search_list);
			if(msg.what==SHOW_BOOK_LIST){
			
			
			User user1=(User) msg.obj;
			JSONArray json1=user1.json;
			Bitmap[] mapArray=new Bitmap[json1.length()];
			mapArray=user1.map;
			broMyAdapter madapter=new broMyAdapter(context,json1,mapArray);
			
			listview.setAdapter(madapter);
			
			Log.e("穿入json",json1.toString());
			
			/********判断传回值是否空******/
			String Json_test=null;
			String Json_test2=null;
			try {
				JSONObject Jsonb=json1.getJSONObject(0);
				Json_test=Jsonb.getString("id");
				Json_test2=Jsonb.getString("name");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(Json_test.equals("null")&&Json_test2.equals("null")){
				Toast toast1=Toast.makeText(activity, "Sorry,搜索内容不存在！", Toast.LENGTH_SHORT);
				toast1.show();
			}else{
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
						json=jsonArray.getJSONObject(position);
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

			
		}
	
		
	}
	
	/*************showBookList************/
	private void showMsg(User str){
		Message msg = Message.obtain(myHandler,MyHandle.SHOW_BOOK_LIST);
		
		msg.obj = str;
		//msg.setTarget(myHandler);//把message内容放入，handle
		msg.sendToTarget();
	}
	
	

	

}



