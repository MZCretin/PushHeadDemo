package com.cretin.www.testdemo2;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    public static final String TAG = "LoginFragment";
    private EditText et_phone;
    private EditText et_password;
    private LinearLayout ll;
    private boolean isShow;
    private ImageView login_logo;
    private boolean isEdShow;
    private int height;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        et_password = (EditText) view.findViewById(R.id.et_password);
        et_phone = (EditText) view.findViewById(R.id.et_phone);
        ll = (LinearLayout) view.findViewById(R.id.scrollview_login);
        login_logo = (ImageView) view.findViewById(R.id.login_logo);

        //username_edt.setText(getArguments().getString("msg"));;
        et_phone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        et_phone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e("HHHHHHH", "click isShow " + isShow + "   isEdShow " + isEdShow);
                if (!isEdShow) {
                    if (!isShow) {
                        ObjectAnimator anim = ObjectAnimator.ofFloat(login_logo, "alpha", 1.0f, 0f);
                        anim.setDuration(500);// 动画持续时间
                        anim.start();
                        ObjectAnimator animator = ObjectAnimator.ofFloat(ll, "translationY", 0, -height);
                        animator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                isEdShow = true;
                                Log.e("HHHHHHHH", "-------->over " + System.currentTimeMillis());
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                        animator.setDuration(500);
                        Log.e("HHHHHHHH", "-------->before " + System.currentTimeMillis());
                        animator.start();
                        Log.e("HHHHHHHH", "-------->after " + System.currentTimeMillis());
                    }
                }
                return false;
            }
        });

        et_password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e("HHHHHHH", "click isShow " + isShow + "   isEdShow " + isEdShow);
                if (!isEdShow) {
                    if (!isShow) {
                        ObjectAnimator anim = ObjectAnimator.ofFloat(login_logo, "alpha", 1.0f, 0f);
                        anim.setDuration(500);// 动画持续时间
                        anim.start();
                        ObjectAnimator animator = ObjectAnimator.ofFloat(ll, "translationY", 0, -height);
                        animator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                isEdShow = true;
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                        animator.setDuration(500);
                        animator.start();
                    }
                }
                return false;
            }
        });

        ll.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Log.e("HHHHHHHH", "--------" + System.currentTimeMillis());
                if (isShow) {
                    Log.e("HHHHHHHH", "memeda");
                    ObjectAnimator anim = ObjectAnimator.ofFloat(login_logo, "alpha", 0f, 1f);
                    anim.setDuration(500);// 动画持续时间
                    anim.start();
                    ObjectAnimator animator = ObjectAnimator.ofFloat(ll, "translationY", -height, 0);
                    animator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            isEdShow = false;
                            isShow = !isShow;
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    animator.setDuration(500);
                    animator.start();
                    Log.e("HHHHHHH", "---->isShow " + isShow + "   isEdShow " + isEdShow);
//                    ObjectAnimator.ofFloat(login_logo, "translationY", -300, 0).setDuration(500).start();
                } else {
                    isShow = !isShow;
                }
                Log.e("HHHHHHH", "isShow " + isShow + "   isEdShow " + isEdShow);
            }
        });

        calcuHeight();
    }

    //计算高度
    private void calcuHeight() {
        ViewTreeObserver vto = login_logo.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                login_logo.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height = login_logo.getMeasuredHeight();
                int width = login_logo.getMeasuredWidth();
                Log.e("HHHHHHHH", "h:" + height + "  w:" + width);
            }
        });

    }

}
