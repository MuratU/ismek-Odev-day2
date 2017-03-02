package com.mturlular.odevday2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void islem(View view) {

        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etSurname = (EditText) findViewById(R.id.etSurname);
        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvOrta = (TextView) findViewById(R.id.tvOrta);
        String stName = etName.getText().toString();
        String stSurname = etSurname.getText().toString();
        Switch swAlt =(Switch)findViewById(R.id.swAlt);
        stName = stName.trim();
        stSurname = stSurname.trim();

//        String isim [] = stName.split(" ");
//        String isim1= isim[0].toUpperCase();
//        String isim2 = isim[1].toUpperCase();
//        int v = isim2.compareTo(isim1);
//
//        if (v>0){
//            tvName.setText(isim1.substring(0,1).toUpperCase() + isim1.substring(1,isim1.length()).toLowerCase() + " " + isim2.replaceAll(isim2.substring(1,isim2.length()),".") + " " +stSurname.toUpperCase());
//        }else{
//            tvName.setText(isim2.substring(0,1).toUpperCase() + isim2.substring(1,isim2.length()).toLowerCase() + " " + isim1.replaceAll(isim1.substring(1,isim1.length()),".") + " " + stSurname.toUpperCase());
//        }

        String isim [] = stName.split(" ");
        Arrays.sort(isim);
        tvName.setText("");
        tvOrta.setText("");
        if (swAlt.isChecked()) {
            for (int b = 0; b < isim.length - 1; ++b)
            {
                if (tvOrta.getText()=="") {
                    tvOrta.setText(tvOrta.getText() + isim[b].substring(0, 1).toUpperCase() + isim[b].substring(1, isim[b].length()).toLowerCase() + " ");
                }
                else {
                    tvOrta.setText(tvOrta.getText()+"\n" + isim[b].substring(0, 1).toUpperCase() + isim[b].substring(1, isim[b].length()).toLowerCase() + " ");
                }
                String son = isim[isim.length - 1].substring(0, 1).toUpperCase() + ".";
                tvName.setText(tvOrta.getText() + "\n" + son + "\n" + stSurname.toUpperCase());
            }
        }else{
            for (int b = 0; b < isim.length -1 ; b++) {
                tvOrta.setText(tvOrta.getText()+isim[b].substring(0,1).toUpperCase()+isim[b].substring(1,isim[b].length()).toLowerCase()+" ");
                String son=isim[isim.length-1].substring(0,1).toUpperCase()+".";
                tvName.setText(tvOrta.getText()+" "+son+" "+stSurname.toUpperCase());
            }
        }

    }
}
