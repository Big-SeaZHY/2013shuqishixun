package com.seu.bigocto.favorite;

import com.seu.bigocto.R;
import com.seu.bigocto.browse.BrowseCommodityActivity;
import com.seu.bigocto.browse.BrowseButtonMyThread.ViewHolder;
import com.seu.bigocto.browse.BrowseButtonMyThread.broMyAdapter;
import com.seu.bigocto.browse.BrowseCommodityActivity.User;
import com.seu.bigocto.mainframe.MainUrl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

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

public class FavoriteFragment extends Fragment{
	
	JSONArray jsonArray;
	MyHandle myHandler;
	View view;
	Context context;
	public FavoriteFragment() {
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		context=getActivity();
		view=inflater.inflate(R.layout.favorite_main_fragment,container,false);
		myHandler=new MyHandle();
		Fav_MyThread th=new Fav_MyThread();
		th.start();
		return view;
	}
	

	
	public class Fav_MyThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try{
				DefaultHttpClient client = new DefaultHttpClient();  
		        List<NameValuePair> list = new ArrayList<NameValuePair>();  
		        NameValuePair pair1 = new BasicNameValuePair("favorite_value","value"); 
		        list.add(pair1);
		        
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
				
				MainUrl url=new MainUrl();
				HttpPost post = new HttpPost(url.getFAVORITE_URL());
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
		        
		        
		        Log.e("favorite发送","成功");
		        
		        String[] imageurl=new String[jsonArray.length()];
		        
		        for(int i=0;i<jsonArray.length();i++){
		        
				JSONObject json=jsonArray.getJSONObject(i);
				
				imageurl[i] = json.getString("imageUrl");
		        
				Log.d("favorite图片链接",""+imageurl[i]);
		        }
		        
		        Bitmap[] bitmap=new Bitmap[jsonArray.length()];
		        
		        for(int i=0;i<jsonArray.length();i++){
		        Bitmap pic =null;  
		        
		        Log.d("favorite图片链接",""+imageurl[i]);
		        
			    HttpPost get = new HttpPost(url.getFAVORITE_IMAGE()+imageurl[i]);  
			    Log.e("favorite图片发送","成功2");
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
				e.printStackTrace();
			}
		}
		
	}
	private void showMsg(User user) {
		// TODO Auto-generated method stub
		Message msg = Message.obtain();
		
		msg.obj = user;
		msg.setTarget(myHandler);//把message内容放入，handle
		msg.sendToTarget();
	}
	class User{
		private JSONArray json;
		private Bitmap[] map=new Bitmap[jsonArray.length()];
		
	}
	
	class MyHandle extends Handler{
		
		@Override
		public void handleMessage(Message msg) {
			
			User user1=(User) msg.obj;
			JSONArray json1=user1.json;
			Bitmap[] mapArray=new Bitmap[json1.length()];
			mapArray=user1.map;
			
			
			/***************************************/
			
			GridView fav_gridview=(GridView) view.findViewById(R.id.favorite_gridview);
			ArrayList<HashMap<String, Object>> libr_gridItem=new ArrayList<HashMap<String,Object>>();
			for(int i=0;i<json1.length();i++){
				
				HashMap<String, Object> map=new HashMap<String, Object>();
				JSONObject jobject;
				String name=null;
				try {
					jobject = json1.getJSONObject(i);
					name=jobject.getString("name");
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				
				
				
				map.put("ItemImage",mapArray[i] );
				map.put("ItemText",name);
				
				Log.d("FavoriteImage",mapArray[i].toString());
				Log.d("FavoriteText",name.toString().toString());
				libr_gridItem.add(map);
			
			}
			FraMyAdapter madapter=new FraMyAdapter(context,json1,mapArray);
			
			fav_gridview.setAdapter(madapter);

			
			fav_gridview.setOnItemClickListener(new OnItemClickListener() {
				
				
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
					Intent intent=new Intent(getActivity(),BrowseCommodityActivity.class);
					intent.putExtras(bundle);
					startActivity(intent);
				}
			});
			
			
		}
	
		
	}
	
/**************set BaseAdapter********************/
	
	public class FraMyAdapter extends BaseAdapter{
		private LayoutInflater inflater;
		private JSONArray jsonArray;
		private Bitmap[] bit;

		public FraMyAdapter(Context c,JSONArray jsonArray1,Bitmap[] bit1){
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
				convertView=inflater.inflate(R.layout.favorite_main_fragment_gridview, null);
				
				holder=new ViewHolder();
				
				holder.fra_photo=(ImageView) convertView.findViewById(R.id.favorite_gridview_ItemImage);
				holder.fra_name=(TextView) convertView.findViewById(R.id.favorite_gridview_ItemText);
				//holder.fra_author=(TextView) convertView.findViewById(R.id.bro_listitem_book_author);
				holder.fra_price=(TextView) convertView.findViewById(R.id.favorite_gridview_price);
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
					//bookAuthor = "作者:"+json.getString("author");
					
					bookPrice = "价格:￥"+json.getString("price");

					//String imageName = json.getString("image");
					//String path = json.getString("image_path");
					
					map.put("bookName", bookName);
					//map.put("author", bookAuthor);
					map.put("bookPrice", bookPrice);
					//map.put("bookImage", null);
					
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
			 holder.fra_photo.setImageBitmap(bit[position]);
			 holder.fra_name.setText(data.get(position).get("bookName").toString());
			// holder.fra_author.setText(data.get(position).get("author").toString());
			 holder.fra_price.setText(data.get(position).get("bookPrice").toString());
			 return convertView;
		}
		
	}
	
	public class ViewHolder{
		public ImageView fra_photo;
		public TextView fra_name;
		public TextView fra_author;
		public TextView fra_price;
		//public TextView libr_press;
		//public TextView libr_date;
		//public Button libr_button_reserve;
	}
	
}
