package com.seu.bigocto.browse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.seu.bigocto.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class BrowseFragment extends Fragment{
	
	EditText bro_search_text;
	ImageView bro_search_img;
	ListView listviews;
	View view;
	String bro_search_value=null;
	FragmentActivity bro_context;
	Context context;
	//private broMyAdapter bro_adapter=null;
	private HttpClient bro_client;
	
	public BrowseFragment() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		bro_context = getActivity();
		context=getActivity();
		view=inflater.inflate(R.layout.browse_main_fragment,container,false);
		
		
		bro_search_text=(EditText)view.findViewById(R.id.bro_search_edit);
		bro_search_img=(ImageView)view.findViewById(R.id.bro_search_button);
		
		
		
		/****************set a search image button************/
		
		bro_search_img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				bro_search_value=bro_search_text.getText().toString();
				if(bro_search_value.isEmpty()){
					Toast toast1=Toast.makeText(getActivity(), "嘛都没写，搜个蛋", Toast.LENGTH_SHORT);
					toast1.show();
				}else{
					BrowseButtonMyThread th=new BrowseButtonMyThread(bro_search_value,getActivity(),context);
					th.start();
					Log.e("wwwwwwwwwwww","aaaaaaaaaaaaa");
					
				}
			}
		});
		
		/***********set a android search enter*************/
		bro_search_text.setOnEditorActionListener(new OnEditorActionListener(){
			
			
			
			@Override
			public boolean onEditorAction(TextView bro_view, int keyCode, KeyEvent event) {
				
				if(event.getAction()==KeyEvent.ACTION_DOWN){
					bro_search_value=bro_search_text.getText().toString();
					if(bro_search_value.isEmpty()){
						Toast toast1=Toast.makeText(getActivity(), "嘛都没写，搜个蛋", Toast.LENGTH_SHORT);
						toast1.show();
					}
					else{
							BrowseButtonMyThread th=new BrowseButtonMyThread(bro_search_value,getActivity(),context);
							th.start();
							
//							listviews=(ListView)view.findViewById(R.id.bro_search_list);
//							broMyAdapter madapter=new broMyAdapter(getActivity());
//							listviews.setAdapter(madapter);
//							view.requestLayout();
							
							//设置listView响应时间
							
//							listviews.setOnItemClickListener(new OnItemClickListener() {
//
//								@Override
//								public void onItemClick(AdapterView<?> arg0,
//										View view, int position, long id) {
//									
//									Intent intent=new Intent(getActivity(),BrowseCommodityActivity.class);
//									startActivity(intent);
//								}
//							
//							});
						
						}
				}
				return true;
			}
		});
			
		
		return view;
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
///**************set BaseAdapter********************/
//	
//	public class broMyAdapter extends BaseAdapter{
//		
//		private LayoutInflater inflater;
//		private JSONArray jsonArray;
//		public broMyAdapter(Context c){
//			this.inflater=LayoutInflater.from(c);
//		}
//		@Override
//		public int getCount() {
//			// TODO Auto-generated method stub
//			return get_list_value().size();
//		}
//
//		@Override
//		public Object getItem(int position) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public long getItemId(int position) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//		
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			// TODO Auto-generated method stub
//			ViewHolder holder;
//			if(convertView==null){
//				convertView=inflater.inflate(R.layout.browse_book_list_item, null);
//				
//				holder=new ViewHolder();
//				
//				holder.bro_photo=(ImageView) convertView.findViewById(R.id.bro_listitem_book_img);
//				holder.bro_name=(TextView) convertView.findViewById(R.id.bro_listitem_book_name);
//				holder.bro_author=(TextView) convertView.findViewById(R.id.bro_listitem_book_author);
//				holder.bro_price=(TextView) convertView.findViewById(R.id.bro_listitem_book_price);
//				//holder.libr_press=(TextView) convertView.findViewById(R.id.libr_listitem_book_press);
//				//holder.libr_date=(TextView) convertView.findViewById(R.id.libr_listitem_book_date);
//				//holder.libr_button_reserve=(Button) convertView.findViewById(R.id.libr_listitem_book_reserve);
//				convertView.setTag(holder);//绑定ViewHolder对象
//			}
//			else{
//				holder=(ViewHolder)convertView.getTag();
//			}
//			
//			/******设置对应的动态数组数据*********/
//			 holder.bro_photo.setImageResource(R.drawable.logo);
//			 holder.bro_name.setText(get_list_value().get(position).get("name").toString());
//			 holder.bro_author.setText(get_list_value().get(position).get("author").toString());
//			 holder.bro_price.setText(get_list_value().get(position).get("price").toString());
//			 //holder.libr_press.setText(libr_get_list_value().get(position).get("press").toString());
//			 //holder.libr_date.setText(libr_get_list_value().get(position).get("date").toString());
//			// holder.libr_button_reserve.setText("预约");
//			 return convertView;
//		}
//		
//	}
//	
//	public class ViewHolder{
//		public ImageView bro_photo;
//		public TextView bro_name;
//		public TextView bro_author;
//		public TextView bro_price;
//		//public TextView libr_press;
//		//public TextView libr_date;
//		//public Button libr_button_reserve;
//	}
	
	
	
	

	
}
