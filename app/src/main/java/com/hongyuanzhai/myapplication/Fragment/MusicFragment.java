package com.hongyuanzhai.myapplication.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.hongyuanzhai.myapplication.R;
import com.hongyuanzhai.myapplication.Service.MyService;


public class MusicFragment extends Fragment {

    private View view;
    private Button bt_1;


//    服务  onCreate -->

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.service_binder_thread, container, false);
        System.out.println("========执行onCreateView==");
        initView();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initView() {
        bt_1 = view.findViewById(R.id.bt_1);
        bt_1.setOnClickListener(view -> {

            Intent i = new Intent(getContext(), MyService.class);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                getActivity().startForegroundService(i);
            } else {
                getActivity().startService(i);
            }
        });
    }


}
