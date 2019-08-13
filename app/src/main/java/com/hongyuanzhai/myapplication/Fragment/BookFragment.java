package com.hongyuanzhai.myapplication.Fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hongyuanzhai.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * onAttach()：执行该方法时，Fragment与Activity已经完成绑定，该方法有一个Activity类型的参数，代表绑定的Activity，这时候你可以执行诸如mActivity = activity的操作。
 * onCreate()：初始化Fragment。可通过参数savedInstanceState获取之前保存的值。
 * onCreateView()：初始化Fragment的布局。加载布局和findViewById的操作通常在此函数内完成，但是不建议执行耗时的操作，比如读取数据库数据列表。
 * onActivityCreated()：执行该方法时，与Fragment绑定的Activity的onCreate方法已经执行完成并返回，在该方法内可以进行与Activity交互的UI操作，所以在该方法之前Activity的onCreate方法并未执行完成，如果提前进行交互操作，会引发空指针异常。
 * onStart()：执行该方法时，Fragment由不可见变为可见状态。
 * onResume()：执行该方法时，Fragment处于活动状态，用户可与之交互。
 * onPause()：执行该方法时，Fragment处于暂停状态，但依然可见，用户不能与之交互。
 * onSaveInstanceState()：保存当前Fragment的状态。该方法会自动保存Fragment的状态，比如EditText键入的文本，即使Fragment被回收又重新创建，一样能恢复EditText之前键入的文本。
 * onStop()：执行该方法时，Fragment完全不可见。
 * onDestroyView()：销毁与Fragment有关的视图，但未与Activity解除绑定，依然可以通过onCreateView方法重新创建视图。通常在ViewPager+Fragment的方式下会调用此方法。
 * onDestroy()：销毁Fragment。通常按Back键退出或者Fragment被回收时调用此方法。
 * onDetach()：解除与Activity的绑定。在onDestroy方法之后调用。
 */
public class BookFragment extends androidx.fragment.app.Fragment {

    private View view;
    private TabLayout tb;
    private ViewPager mVp;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>(Arrays.asList("书架", "热门", "我的"));
    private Toolbar mToolBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bookread_root, container, false);
        initView();
        return view;
    }

    private void initView() {
        tb = view.findViewById(R.id.tb);
        mVp = view.findViewById(R.id.vp);
        mToolBar = view.findViewById(R.id.toolbar);
        initToolBar();
        initFragment();
        // connect with ViewPage
        tb.setupWithViewPager(mVp);
        mVp.setOffscreenPageLimit(3);
        mVp.setAdapter(new mTabLayoutAdapter(getFragmentManager()));
    }

    private void initToolBar() {
        if (mToolBar != null) {
            setUpToolbar(mToolBar);
        }
    }

    /**
     * @param mToolBar 处理ToolBar
     */
    private void setUpToolbar(Toolbar mToolBar) {
        mToolBar.setLogo(R.mipmap.biker);
        mToolBar.setTitle("00");

    }

    private void initFragment() {
        Fragment bookShelfFragment = new BookShelfFragment();
        Fragment communityFragment = new CommunityFragment();
        Fragment discoveryFragment = new FindFragment();
        mFragmentList.add(bookShelfFragment);
        mFragmentList.add(communityFragment);
        mFragmentList.add(discoveryFragment);
    }


    /**
     * inner class
     * FragmentPagerAdapter
     */

    private class mTabLayoutAdapter extends FragmentPagerAdapter {
        public mTabLayoutAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            CharSequence title = titles.get(position);
            return title;
        }
    }
}
