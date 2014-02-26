package com.seu.bigocto.mainframe;

import java.util.ArrayList;
import java.util.List;

import com.seu.bigocto.R;
import com.seu.bigocto.browse.BrowseFragment;
import com.seu.bigocto.collection.CollectionFragment;
import com.seu.bigocto.favorite.FavoriteFragment;
import com.seu.bigocto.setting.SettingFragment;

import android.support.v4.app.Fragment;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainFrameActivity extends FragmentActivity{
	private ViewPager mPager;
	//private List<View> listViews;
	private List<Fragment> listViews;
	private TextView t1,t2,t3,t4;//set top tab labels
	
	private ImageView cursor;
	private int offset = 0;
	private int currIndex = 0;
	private int bmpW;

	public void onCreate(Bundle save){
		super.onCreate(save);
		this.setTitle("图书");
		
		//ActionBar actionBar = this.getActionBar();  
        //actionBar.setDisplayHomeAsUpEnabled(true);
        
		setContentView(R.layout.mainframe_activity);
		InitImageView();
		InitTextView();
		InitViewPager();

	}
	/***show the header content*******/
	
	private void InitTextView(){
		t1=(TextView) findViewById(R.id.mainframe_text1);
		t2=(TextView) findViewById(R.id.mainframe_text2);
		t3=(TextView) findViewById(R.id.mainframe_text3);
		t4=(TextView) findViewById(R.id.mainframe_text4);
		
		t1.setOnClickListener(new MainFrameMyOnClickListener(0));
		t2.setOnClickListener(new MainFrameMyOnClickListener(1));
		t3.setOnClickListener(new MainFrameMyOnClickListener(2));
		t4.setOnClickListener(new MainFrameMyOnClickListener(3));
	}
	
	private void InitViewPager(){
		mPager=(ViewPager) findViewById(R.id.mainframe_Pager);
		//listViews=new ArrayList<View>();
		listViews=new ArrayList<Fragment>();
		LayoutInflater mInfalter=getLayoutInflater();
	
		listViews.add(new FavoriteFragment());
		listViews.add(new BrowseFragment());
		listViews.add(new CollectionFragment());
		listViews.add(new SettingFragment());
		mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), listViews));
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
		
		
	}
	
	
	public class MyPagerAdapter extends FragmentPagerAdapter{
		
		private List<Fragment> fragmentList;
		public MyPagerAdapter(android.support.v4.app.FragmentManager fm, List<Fragment> fragmentList) {
			super(fm);
			this.fragmentList=fragmentList;
		}

		@Override
		public Fragment getItem(int arg0) {
			if (fragmentList==null || fragmentList.size()==0)
				return null;
			else
				return fragmentList.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if(fragmentList==null){
				return 0;
			}else{
				return fragmentList.size();
			}
			
		}
		
	}
	
    /******click to jump a different page*************/
    public class MainFrameMyOnClickListener implements View.OnClickListener {
		
		private int index=0;
		public MainFrameMyOnClickListener(int i){
			index=i;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mPager.setCurrentItem(index);
		}
	
	}
    
    
    /**
     * 初始化动画
     */
    private void InitImageView() {
        cursor = (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.mainframe_underline)
                .getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW /4 - bmpW) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        cursor.setImageMatrix(matrix);// 设置动画初始位置
    }
  
    
    /**
     * 页卡切换监听
     */
    public class MyOnPageChangeListener implements OnPageChangeListener {

        int one = offset * 2 + bmpW;
        int two = one * 2;
        int three=one*3;

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
            case 0:
                if (currIndex == 1) {
                    animation = new TranslateAnimation(one, 0, 0, 0);
                } else if (currIndex == 3) {
                    animation = new TranslateAnimation(three, 0, 0, 0);
                }else if(currIndex==2){
                	animation=new TranslateAnimation(two,0,0,0);
                }
                break;
            case 1:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(0, one, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, one, 0, 0);
                }else if(currIndex==3){
                	animation=new TranslateAnimation(three,one,0,0);
                }
                break;
            case 2:
                if (currIndex == 1) {
                    animation = new TranslateAnimation(one, two, 0, 0);
                } else if (currIndex == 3) {
                    animation = new TranslateAnimation(three, two, 0, 0);
                }else if(currIndex==0){
                	animation=new TranslateAnimation(0,two,0,0);
                }
                break;
            case 3:
            	if(currIndex==0){
            		animation=new TranslateAnimation(0,three,0,0);
            	}else if(currIndex==1){
            		animation=new TranslateAnimation(one,three,0,0);
            	}else if(currIndex==2){
            		animation=new TranslateAnimation(two,three,0,0);
            	}
            	break;
            }
    	
    
            currIndex = arg0;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            cursor.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
        
        
    }
    
 
    
}
