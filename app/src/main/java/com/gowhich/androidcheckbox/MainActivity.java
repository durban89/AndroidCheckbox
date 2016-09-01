package com.gowhich.androidcheckbox;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<CheckBox> checkBoxs = new ArrayList<CheckBox>();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        String[] checkBoxText = new String[]{"您喜欢数学嘛？","您喜欢语文嘛？","您喜欢英语嘛？","您喜欢政治嘛？"};
        //动态加载布局
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        //给指定的checkbox赋值
        for(int i = 0; i < checkBoxText.length; i++){
            CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(R.layout.check_box, null);
            checkBoxs.add(checkBox);
            checkBoxs.get(i).setText(checkBoxText[i]);
            linearLayout.addView(checkBox);
        }

        setContentView(linearLayout);
        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        String s = "";
        for(CheckBox checkBox:checkBoxs){
            if(checkBox.isChecked()){
                s += checkBox.getText() + "\n";
            }
        }

        if("".equals(s)){
            s = "还没有选中选项！";
        }

        new AlertDialog.Builder(this).setMessage(s).setPositiveButton("关闭", null);
    }
}
