package com.seu.bigocto.setting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.seu.bigocto.R;

public class SettingFragment extends Fragment implements OnClickListener{
	View view;
	TextView land_text;
	TextView quit_text;
	
	
	String login_data;
	String login_name_data;
	Context context;
	SharedPreferences.Editor editor;
	SharedPreferences sharedata ;//数据存储
	
	String set_text[]={"个人信息","我的账户","联系我们"};
	int[]  set_image;
	
	//private MyHandler myHandler;
	public SettingFragment(){
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context=getActivity();
		
		sharedata = context.getSharedPreferences("login_info", 0);
		
		login_data= sharedata.getString("success", "");//登陆状态
		login_name_data=sharedata.getString("name", "");//登陆名
		editor=sharedata.edit();
		
		view=inflater.inflate(R.layout.setting_main_fragment, container,false);
		
		Toast toast=Toast.makeText(getActivity(), "Welcome "+login_name_data, Toast.LENGTH_SHORT);
		toast.show();
		
		ListView list=(ListView) view.findViewById(R.id.set_listview);
		MyAdapter mAdapter=new MyAdapter(getActivity());
		mAdapter.notifyDataSetChanged();
		list.setAdapter(mAdapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int pos,
					long arg3) {
				
				switch(pos){
				
					case 0:{
							Intent intent=new Intent(getActivity(),SettingMyInfoActivity.class);
							startActivity(intent);
							break;
							}
						
					
					case 1:{
						Intent intent=new Intent(getActivity(),SettingAccountActivity.class);
						startActivity(intent);
						break;
					}

					case 2:
						Intent intent=new Intent(getActivity(),SettingContactActivity.class);
						startActivity(intent);
						break;


				}

				
			}
			
		});
		
		
		initview();

		return view;
	}
	
	public void initview(){
	
		/**********land*************/
		String test_value="true";
		if(login_data.equals(test_value)){
			quit_text=(TextView) view.findViewById(R.id.set_main_land);
			quit_text.setText("退出登录");
			quit_text.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					editor.putString("success", "false");
					editor.putString("name", "");
					editor.commit();
					Toast toast=Toast.makeText(getActivity(), "退出成功", Toast.LENGTH_SHORT);
					toast.show();
					quit_text=(TextView) view.findViewById(R.id.set_main_land);
					quit_text.setText("立即登录");
					quit_text.setOnClickListener(SettingFragment.this);
				}
			});
		}else{

			Toast toast1=Toast.makeText(getActivity(),"登陆状态："+login_data, Toast.LENGTH_SHORT);
			toast1.show();
		
			land_text=(TextView) view.findViewById(R.id.set_main_land);
			land_text.setText("立即登录");
			land_text.setOnClickListener(this);
		
		}
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.set_main_land:{
			
			Toast toast=Toast.makeText(getActivity(), "欢迎学弟学妹", Toast.LENGTH_SHORT);
			toast.show();
			Intent intent=new Intent(getActivity(),SettingLoginActivity.class);
			startActivity(intent);
			break;
			}
		case R.id.set_main_land2:{
			Toast toast=Toast.makeText(getActivity(), "退出成功", Toast.LENGTH_SHORT);
			toast.show();
			}
		
		}
	}
	
	/*******************listView1************/
	
	public class MyAdapter extends BaseAdapter{
		
		private LayoutInflater inflater;
		
		public MyAdapter(Context c){
			this.inflater=LayoutInflater.from(c);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return set_text.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			ViewHolder holder;
			if(convertView==null){
				convertView=inflater.inflate(R.layout.setting_set_listview, null);
				holder=new ViewHolder();
				
				holder.set_image=(ImageView) convertView.findViewById(R.id.set_list_image);
				holder.set_text=(TextView) convertView.findViewById(R.id.set_list_text);
				//holder.set_image2=(ImageView) convertView.findViewById(R.id.set_list_image2);
				convertView.setTag(holder);//绑定ViewHolder对象
			}else{
				holder=(ViewHolder)convertView.getTag();
			}
			holder.set_image.setImageResource(R.drawable.set_image1);
			holder.set_text.setText(set_text[position]);
			//holder.set_image2.setImageResource(R.drawable.set_image1);
			return convertView;
		}
		
	}
	
	public class ViewHolder{
		public ImageView set_image;
		public TextView set_text;
		public ImageView set_image2;

	}
	

	protected List< Map<String, Object> > set_get_list_value(){
		
		ArrayList<Map<String, Object>> set_list=new ArrayList<Map<String, Object>>();
		Map<String, Object> map=new HashMap<String ,Object>();

		map.put("personal", R.drawable.personal_iamge);
		map.put("bill", R.drawable.bill_image);
		map.put("record", R.drawable.record_image);
		//map.put("address", R.drawable.address_image);
		map.put("contact", R.drawable.contact_image);
		
		set_image[0]=R.drawable.personal_iamge;
		set_image[1]=R.drawable.bill_image;
		set_image[2]=R.drawable.record_image;
		set_image[3]=R.drawable.address_image;
		set_image[4]=R.drawable.contact_image;

										
		return set_list;
	}


}
