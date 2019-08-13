package com.hongyuanzhai.myapplication.Fragment;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hongyuanzhai.myapplication.R;
import com.hongyuanzhai.myapplication.View.StepArcView;
import com.hongyuanzhai.myapplication.View.Windmill;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private View view;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private ImageView imageView;
    private Windmill windmill_big;
    private Windmill windmill_small;
    private Button bt_4;
    private StepArcView step;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        imageView = view.findViewById(R.id.iv);
        bt_1 = view.findViewById(R.id.bt_1);
        bt_2 = view.findViewById(R.id.bt_2);
        bt_3 = view.findViewById(R.id.bt_3);
        step = view.findViewById(R.id.step);
        bt_4 = view.findViewById(R.id.bt_4);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);

    }


    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                goPaoWuLine();
                break;
            case R.id.bt_2:
                // 水平移动  + 旋转
                moveAndRote();
                break;
            case R.id.bt_3:
                initViews();
                break;
            case R.id.bt_4:
                toRoad();
            default:
                break;
        }

    }

    private void toRoad() {
        step.setCurrentCount(7000, 1000);


    }

    private void initViews() {
        windmill_big = (Windmill) view.findViewById(R.id.windmill_big);
        windmill_big.setWindSpeed(6);
        windmill_small = (Windmill) view.findViewById(R.id.windmill_small);
        windmill_small.setWindSpeed(6);

        windmill_big.startAnimation();
        windmill_small.startAnimation();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (windmill_big != null && windmill_small != null) {
            windmill_big.clearAnimation();
            windmill_small.clearAnimation();
        }
    }


    private void moveAndRote() {
        Toast.makeText(getContext(), "hello", Toast.LENGTH_LONG).show();

        // 进行动画的加载
//        AnimatorSet  animator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.fillname);
//        animator.setTarget(imageView);
//        animator.start();

    }

    private void goPaoWuLine() {
        Toast.makeText(view.getContext(), "我要飞了", Toast.LENGTH_LONG).show();
        //抛物线  ---属性动画
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(5000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float v, Object o, Object t1) {
                //chazhiqi 控制X、Y
                PointF pointF = new PointF();
                pointF.x = view.getWidth() * v * 4;
                pointF.y = 200 * (v * 3) * (v * 3);
                return pointF;
            }
        });
        valueAnimator.start();
        //添加动画的监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                imageView.setX(pointF.x);
                imageView.setY(pointF.y);
            }
        });
    }
}
