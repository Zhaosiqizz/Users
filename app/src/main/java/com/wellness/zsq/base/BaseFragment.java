package com.wellness.zsq.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by wellness on 2018/2/26.
 */

public abstract class BaseFragment extends Fragment{
    public abstract int getContentViewId();
    protected Context context;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView =inflater.inflate(getContentViewId(),container,false);
        ButterKnife.bind(this,mRootView);
        this.context = getActivity();
        return mRootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
