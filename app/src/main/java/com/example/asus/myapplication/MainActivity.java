package com.example.asus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextA;
    private EditText editTextB;


    private Button Cong;
    private Button Tru;

    private TextView tvKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
        setEventClickViews();
    }

    public void initWidget(){
        editTextA=(EditText) findViewById(R.id.edtA);
        editTextB=(EditText) findViewById(R.id.edtB);

        Cong=(Button) findViewById(R.id.btnCong);

        tvKQ=(TextView) findViewById(R.id.tvKQ);
    }

    public void setEventClickViews(){
        Cong.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String a=editTextA.getText().toString();
        String b=editTextB.getText().toString();
        int c=Integer.parseInt(a);
        int d=Integer.parseInt(b);
        switch (v.getId()){
            case R.id.btnCong:
                RadioGroup group=(RadioGroup) findViewById(R.id.radioGroup);
                int idChecked=group.getCheckedRadioButtonId();
                if(idChecked==-1)
                {
                    Toast.makeText(this,"Phải Chọn Phép Tính",Toast.LENGTH_LONG).show();
                    return;
                }
                RadioButton rad=(RadioButton) findViewById(idChecked);
                String pheptinh=rad.getText().toString();
                int k=0;
                String aa="";

                if(editTextA.equals("") || editTextB.equals("")|| editTextA.equals("") && editTextB.equals(""))
                {
                    Toast.makeText(this,"Phải Nhập 2 Số A và B",Toast.LENGTH_LONG).show();
                    return;
                }


                if(pheptinh.equals("Chia"))k=c/d;
                else if (pheptinh.equals("Cộng"))k=c+d;
                else if (pheptinh.equals("Trừ"))k=c-d;
                else if (pheptinh.equals("Nhân"))k=c*d;

                tvKQ.setText(Integer.toString(k));
                break;
                default:
                    break;
        }

    }
}
