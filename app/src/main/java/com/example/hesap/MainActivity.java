package com.example.hesap;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    TextView islem_text, sonuc_Text;
    private String islemler, sonuc;

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,toplama_btn,çarpma_btn,çıkar_btn,bölüm_btn,btnnokta,yüzde_btn, üs_btn, eşit_btn, temizle_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        islem_text = findViewById(R.id.islem_text);
        sonuc_Text = findViewById(R.id.sonuc_Text);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        toplama_btn = findViewById(R.id.toplama_btn);
        çarpma_btn = findViewById(R.id.çarpma_btn);
        bölüm_btn = findViewById(R.id.bölüm_btn);
        çıkar_btn = findViewById(R.id.çıkar_btn);
        btnnokta = findViewById(R.id.btnnokta);
        üs_btn = findViewById(R.id.üs_btn);
        eşit_btn = findViewById(R.id.eşit_btn);
        yüzde_btn = findViewById(R.id.yüzde_btn);
        temizle_btn = findViewById(R.id.temizle_btn);



    }

    public void onButtonClicked(View view) {

        Button button = (Button) view;
        String mevcut = button.getText().toString();
        switch (mevcut) {
            case "C":
                islemler = null;
                sonuc=null;
                sonuc_Text.setText("");
                break;

            case "^":
                islem();
                islemler += "^";
                break;
            case "*":
                islem();
                islemler += "*";
                break;

            case "=":
                islem();
                break;

            case "%":
                islemler += "%";
                double d = Double.parseDouble(islem_text.getText().toString()) / 100;
                sonuc_Text.setText(String.valueOf(d));
                break;

            default:
                if (islemler == null) {
                    islemler = "";
                }
                if (mevcut.equals("+") || mevcut.equals("/") || mevcut.equals("-")) {
                    islem();
                }
                islemler += mevcut;
        }
        islem_text.setText(islemler);
    }

    private void islem() {
        if (islemler.split("\\+").length == 2) {
            String sayılar[] = islemler.split("\\+");
            try {
                double d = Double.parseDouble(sayılar[0]) + Double.parseDouble(sayılar[1]);
                sonuc = Double.toString(d);

                sonuc_Text.setText(sonuc);
                islemler = d +"";
            }catch (Exception e) {
                sonuc_Text.setText(e.getMessage().toString());
            }
        }



        if (islemler.split("\\*").length == 2) {
            String sayılar[] = islemler.split("\\*");
            try {
                double d = Double.parseDouble(sayılar[0]) * Double.parseDouble(sayılar[1]);
                sonuc = Double.toString(d);

                sonuc_Text.setText(sonuc);
                islemler = d +"";
            }catch (Exception e){
                sonuc_Text.setText(e.getMessage().toString());
            }
        }


        if (islemler.split("\\/").length == 2) {
            String sayılar[] = islemler.split("\\/");
            try {
                double d = Double.parseDouble(sayılar[0]) / Double.parseDouble(sayılar[1]);
                sonuc = Double.toString(d);

                sonuc_Text.setText(sonuc);
                islemler = d +"";
            }catch (Exception e){
                sonuc_Text.setText(e.getMessage().toString());
            }
        }


        if (islemler.split("\\^").length == 2) {
            String sayılar[] = islemler.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(sayılar[0]), Double.parseDouble(sayılar[1]));
                sonuc = Double.toString(d);

                sonuc_Text.setText(sonuc);
                islemler = d +"";
            }catch (Exception e){
                sonuc_Text.setText(e.getMessage().toString());
            }
        }



        if (islemler.split("\\-").length == 2) {
            String sayılar[] = islemler.split("\\-");
            try {
                if (Double.parseDouble(sayılar[0]) < Double.parseDouble(sayılar[1])){
                    double d = Double.parseDouble(sayılar[1]) - Double.parseDouble(sayılar[0]);
                    sonuc = Double.toString(d);

                    sonuc_Text.setText("-" + sonuc);
                    islemler = d +"";
                }
                else {
                    double d = Double.parseDouble(sayılar[0]) - Double.parseDouble(sayılar[1]);
                    sonuc = Double.toString(d);

                    sonuc_Text.setText(sonuc);
                    islemler = d + "";
                }


            }catch (Exception e){
                sonuc_Text.setText(e.getMessage().toString());
            }
        }
    }

}


