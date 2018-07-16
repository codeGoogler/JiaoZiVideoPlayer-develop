package cn.jzvd.demo.frg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.jzvd.demo.R;


public class FragmentHome extends Fragment{

	private View view;// 需要返回的布局

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		if (view == null) {// 优化View减少View的创建次数
			view = inflater.inflate(R.layout.frag_home, null);
			return view;
		}
		return view;
	}



}
