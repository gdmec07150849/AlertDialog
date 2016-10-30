package cn.edu.gdmec.a07150849.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tv1;
    private AlertDialog ad;
    private AlertDialog.Builder builder;
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        tv1 = (TextView) findViewById(R.id.text1);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){

                    case R.id.bt1:
                        dialog1();
                        break;

                    case R.id.bt2:
                        dialog2();
                        break;
                    case R.id.bt3:
                        dialog3();
                        break;
                    case R.id.bt4:
                        dialog4();
                        break;
                    case R.id.bt5:
                        dialog5();
                        break;
                    case R.id.bt6:
                        dialog6();
                        break;
                    case R.id.bt7:
                        dialog7();
                        break;

                }


            }
        };

        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);
        bt7.setOnClickListener(listener);

    }

    private void dialog1(){

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确定退出吗？");
        ad.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener lis1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    ad.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    ad.dismiss();
                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"退出",lis1);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        ad.show();



    }

    private void dialog2(){


        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你最近忙吗？");
        ad.setIcon(android.R.drawable.ic_dialog_info);

        DialogInterface.OnClickListener lis2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = "";


                switch(which){

                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "一丢丢丢丢吧";
                        break;

                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "你想约我？";
                        break;
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "本人很忙!";
                        break;
                }
             tv1.setText(str);

            }
        };

        ad.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",lis2);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"一般",lis2);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"不忙",lis2);
        ad.show();


    }

    private void dialog3(){

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("输入框");
        ad.setMessage("请输入您的获奖感言");
        ad.setIcon(android.R.drawable.ic_dialog_dialer);

       final EditText et1 = new EditText(this);
        ad.setView(et1);

        DialogInterface.OnClickListener lis3 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_NEGATIVE) {
                    tv1.setText("您的感言是：" + et1.getText().toString());
                }
            }
        };

        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis3);
        ad.show();




    }


    private void dialog4(){

       final String item[] = {"北京","上海","广州"};
        final boolean bselect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener lis4 = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
               bselect[which] = isChecked;
            }
        };

        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bselect,lis4);
        ad = builder.create();
        ad.setTitle("多选框");

        DialogInterface.OnClickListener lis41 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";

                for(int i = 0;i<item.length;i++){

                    if(bselect[i]){
                        str = str+item[i]+"\n";
                    }
                }
                tv1.setText(str);

            }
        };


        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis41);
        ad.show();



    }


    private void dialog5(){
        final String item[] = {"北京","上海","广州"};
        final boolean bselect[] = new boolean[item.length];
        DialogInterface.OnClickListener lis5 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                for (int i = 0;i<bselect.length;i++){
                    if(!(which==i)){
                        bselect[i]=false;
                    }else{
                        bselect[i]=true;
                    }
                }

            }
        };

        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,lis5);
        ad = builder.create();
        ad.setTitle("单选框");
        DialogInterface.OnClickListener lis51 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = "你选了:";

                for(int i =0;i<item.length;i++){
                    if(bselect[i]){
                        str = str+item[i]+"\n";
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis51);
        ad.show();




    }


    private void dialog6(){

        final String item[] ={ "北京","上海","广州"};
        DialogInterface.OnClickListener lis6 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了："+item[which];
                tv1.setText(str);
            }

        };

        builder = new AlertDialog.Builder(this);
        builder.setItems(item,lis6);
        ad = builder.create();
        ad.setTitle("列表");
        DialogInterface.OnClickListener lis61 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ad.dismiss();
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis61);
        ad.show();




    }

    private void dialog7(){

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.mylayout,null);
        final EditText et1 = (EditText) layout.findViewById(R.id.editText1);

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);

        DialogInterface.OnClickListener lis7 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你输入的是："+et1.getText().toString());
            }
        };

        ad.setButton(DialogInterface.BUTTON_POSITIVE,"取消",lis7);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"确认",lis7);
        ad.show();


    }










}
