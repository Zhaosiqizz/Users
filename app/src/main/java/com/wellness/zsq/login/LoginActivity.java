package com.wellness.zsq.login;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;

import com.wellness.zsq.base.BaseActivity;
import com.wellness.zsq.users.R;
import com.wellness.zsq.util.ValidateUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends BaseActivity {


    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.input_phone)
    TextInputLayout inputPhone;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.input_password)
    TextInputLayout inputPassword;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;
    @BindView(R.id.txt_register)
    TextView txtRegister;
    @BindView(R.id.txt_forgetpwd)
    TextView txtForgetpwd;
    @BindView(R.id.input_login)
    TextInputLayout inputLogin;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    private void initView() {
//        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.phone);
//        Drawable drawable = getResources().getDrawable(R.drawable.phone);
//        //参数：左、上、长、宽 边距离
////        drawable.setBounds(50,50,50,0);
//        drawable.setBounds(0, 100, 100,100);
//        //只放左边
//        inputEmail.setCompoundDrawables(drawable,null,null,null);
        //单行显示
        editPhone.setSingleLine();
        editPassword.setSingleLine();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();

    }

    @OnClick(R.id.btn_login)
    public void startHome() {



        final String phone = editPhone.getText().toString();
        String pwd = editPassword.getText().toString();




        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
//            inputLogin.setErrorTextAppearance(Gravity.RIGHT);
            inputLogin.setError("请填写帐号(或密码)");
        }else{

        }



    }
    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        RequestBody formBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .add("","")
                .build();
        Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        System.out.println(response.body().string());
    }



    /* 校验手机号是否合法
                  **/
    private void checkPhone(EditText account) {
        String phoneNumber = account.getText().toString();
        if (!ValidateUtil.isPhone(phoneNumber)) {// 验证手机号是否合法
//
//                drawable.setBounds(new Rect(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight()));
//                Drawable drawable = getResources().getDrawable(R.drawable.img_edit_error);//错误时要显示的图片
            //图片的大小，可调，四个参数为左上右下
            account.setError("手机号不合法");//设置错误的时候不显示文本，只显示图片在android 4.4上的机必须要有类似er


            // r的文本才会显示
        }


    }


}
