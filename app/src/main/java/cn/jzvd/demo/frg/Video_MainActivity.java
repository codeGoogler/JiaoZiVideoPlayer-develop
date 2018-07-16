package cn.jzvd.demo.frg;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.jzvd.demo.FragmentDemo;
import cn.jzvd.demo.R;

public class Video_MainActivity extends AppCompatActivity {
	// 布局管理器
	private FragmentManager fManager;

//	private FragmentHome fragment_home;
	private FragmentDemo fragment_home;
	private FragmentHot fragment_hot;
	private FragmentTalk fragment_talk;
	private FragmentMe fragment_me;

	// 首页
	private ImageView iv_menu_home;
	private TextView tv_menu_home;

	// 热点
	private ImageView iv_menu_hot;
	private TextView tv_menu_hot;

	// 留言
	private ImageView iv_menu_talk;
	private TextView tv_menu_talk;

	// 我的
	private ImageView iv_menu_me;
	private TextView tv_menu_me;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_video);

		// 初始化组件
		initViews();
		// 默认先点中第一个“首页”
		clickMenu(findViewById(R.id.ll_menu_home));
	}

	private void initViews() {
		// 布局管理器
		fManager = getSupportFragmentManager();

		iv_menu_home = (ImageView)findViewById(R.id.iv_menu_home);
		tv_menu_home = (TextView)findViewById(R.id.tv_menu_home);

		iv_menu_hot = (ImageView)findViewById(R.id.iv_menu_hot);
		tv_menu_hot = (TextView)findViewById(R.id.tv_menu_hot);

		iv_menu_talk = (ImageView)findViewById(R.id.iv_menu_talk);
		tv_menu_talk = (TextView)findViewById(R.id.tv_menu_talk);

		iv_menu_me = (ImageView)findViewById(R.id.iv_menu_me);
		tv_menu_me = (TextView)findViewById(R.id.tv_menu_me);
	}

	/**
	 * 点击底部菜单事件
	 * @param v
	 */
	public void clickMenu(View v){
		FragmentTransaction trans = fManager.beginTransaction();
		int vID = v.getId();
		// 设置menu样式
		setMenuStyle(vID);
		// 隐藏所有的fragment
		hideFrament(trans);
		// 设置Fragment
		setFragment(vID,trans);
		trans.commit();
	}

	/**
	 * 隐藏所有的fragment(编程初始化状态)
	 * @param trans
	 */
	private void hideFrament(FragmentTransaction trans) {
		if(fragment_home!=null){
			trans.hide(fragment_home);
		}
		if(fragment_hot!=null){
			trans.hide(fragment_hot);
		}
		if(fragment_talk!=null){
			trans.hide(fragment_talk);
		}
		if(fragment_me!=null){
			trans.hide(fragment_me);
		}
	}

	/**
	 * 设置menu样式
	 * @param vID
	 * @param
	 */
	private void setMenuStyle(int vID) {
		// 首页
		if(vID==R.id.ll_menu_home){
			iv_menu_home.setImageDrawable(getResources().getDrawable(R.drawable.menu_home_click));
			tv_menu_home.setTextColor(getResources().getColor(R.color.menu_click));
		}else {
			iv_menu_home.setImageDrawable(getResources().getDrawable(R.drawable.menu_home));
			tv_menu_home.setTextColor(getResources().getColor(R.color.menu_nomarl));
		}
		// 热点
		if(vID==R.id.ll_menu_hot){
			iv_menu_hot.setImageDrawable(getResources().getDrawable(R.drawable.menu_hot_click));
			tv_menu_hot.setTextColor(getResources().getColor(R.color.menu_click));
		}else {
			iv_menu_hot.setImageDrawable(getResources().getDrawable(R.drawable.menu_hot));
			tv_menu_hot.setTextColor(getResources().getColor(R.color.menu_nomarl));
		}
		// 发言
		if(vID==R.id.ll_menu_talk){
			iv_menu_talk.setImageDrawable(getResources().getDrawable(R.drawable.menu_talk_click));
			tv_menu_talk.setTextColor(getResources().getColor(R.color.menu_click));
		}else {
			iv_menu_talk.setImageDrawable(getResources().getDrawable(R.drawable.menu_talk));
			tv_menu_talk.setTextColor(getResources().getColor(R.color.menu_nomarl));
		}
		// 我的
		if(vID==R.id.ll_menu_me){
			iv_menu_me.setImageDrawable(getResources().getDrawable(R.drawable.menu_me_click));
			tv_menu_me.setTextColor(getResources().getColor(R.color.menu_click));
		}else {
			iv_menu_me.setImageDrawable(getResources().getDrawable(R.drawable.menu_me));
			tv_menu_me.setTextColor(getResources().getColor(R.color.menu_nomarl));
		}
	}

	/**
	 * 设置Fragment
	 * @param vID
	 * @param trans
	 */
	private void setFragment(int vID,FragmentTransaction trans) {
		switch (vID) {
			case R.id.ll_menu_home:
				if(fragment_home==null){
					fragment_home = new FragmentDemo();
					trans.add(R.id.content, fragment_home);
				}else{
					trans.show(fragment_home);
				}
				break;
			case R.id.ll_menu_hot:
				if(fragment_hot==null){
					fragment_hot = new FragmentHot();
					trans.add(R.id.content, fragment_hot);
				}else{
					trans.show(fragment_hot);
				}
				break;
			case R.id.ll_menu_talk:
				if(fragment_talk==null){
					fragment_talk = new FragmentTalk();
					trans.add(R.id.content, fragment_talk);
				}else{
					trans.show(fragment_talk);
				}
				break;
			case R.id.ll_menu_me:
				if(fragment_me==null){
					fragment_me = new FragmentMe();
					trans.add(R.id.content, fragment_me);
				}else{
					trans.show(fragment_me);
				}
				break;
			default:
				break;
		}
	}
//	@Override
//	public void onBackPressed() {
//		if (NiceVideoPlayerManager.instance().onBackPressd()) return;
//		super.onBackPressed();
//	}
//	@Override
//	protected void onStop() {
//		super.onStop();
//		NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
//	}


}
