package com.yzmsoft.yzmcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    ScrollView ScrollView;

    int typeOp = 0; // 1->add, 2->subtract, 3->multiply, 4->divide
    double var1 = 0.0;
    double var2 = 0.0;
    boolean dot = false;
    boolean showResult = false;
    boolean firstOp = true;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        ScrollView = findViewById(R.id.ScrollView);
    }

    public static String format(double d){
        if(d % 1.0 == 0){
            return String.valueOf((int)d);
        } else return String.valueOf(d);
    }

    public void addDot(View view){

        if (!showResult){
            if (!dot){
                temp = textView.getText().toString();
                textView.setText(temp + ".");
            }
        } else{
            textView.setText("0.");
            showResult = false;
        }
        dot = true;
    }


    public void writeZero(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "1");
            }
        } else{
            textView.setText("0");
            showResult = false;
        }
    }

    public void writeOne(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "1");
            } else textView.setText("1");
        } else{
            textView.setText("1");
            showResult = false;
        }
    }

    public void writeTwo(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "2");
            } else textView.setText("2");
        } else{
            textView.setText("2");
            showResult = false;
        }
    }

    public void writeThree(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "3");
            } else textView.setText("3");
        } else{
            textView.setText("3");
            showResult = false;
        }
    }

    public void writeFour(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "4");
            } else textView.setText("4");
        } else{
            textView.setText("4");
            showResult = false;
        }
    }

    public void writeFive(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "5");
            } else textView.setText("5");
        } else{
            textView.setText("5");
            showResult = false;
        }
    }

    public void writeSix(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "6");
            } else textView.setText("6");
        } else{
            textView.setText("6");
            showResult = false;
        }
    }

    public void writeSeven(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "7");
            } else textView.setText("7");
        } else{
            textView.setText("7");
            showResult = false;
        }
    }

    public void writeEight(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "8");
            } else textView.setText("8");
        } else{
            textView.setText("8");
            showResult = false;
        }
    }

    public void writeNine(View view){
        if (!showResult){
            temp = textView.getText().toString();
            if (!temp.matches("0")){
                textView.setText(temp + "9");
            } else textView.setText("9");
        } else{
            textView.setText("9");
            showResult = false;
        }
    }

    public void clear(View view){
        textView.setText("0");
        typeOp = 0;
        var1 = 0.0;
        var2 = 0.0;
        dot = false;
        showResult = false;
        firstOp = true;
    }

    public void backspace(View view){
        temp = textView.getText().toString();

        if (!showResult){
            if (temp.length() > 1) {
                temp = temp.substring(0, temp.length() - 1);
                textView.setText(temp);
            } else if (temp.length() == 1) textView.setText("0");
        } else{
            textView.setText("0");
            showResult = false;
        }
    }

    public void operate(){
        var2 = Double.parseDouble(textView.getText().toString());
        double result = 0.0;

        if (typeOp == 1){
            result = var1 + var2;
            textView.setText(format(result));
        } else if (typeOp == 2) {
            result = var1 - var2;
            textView.setText(format(result));
        } else if (typeOp == 3){
            result = var1 * var2;
            textView.setText(format(result));
        } else if (typeOp == 4){
            result = var1 / var2;
            textView.setText(format(result));
        }
        var1 = result;
        dot = false;
        showResult = true;
    }

    public void opCommon(){
        if (!firstOp) {
            operate();
        } else{
            var1 = Double.parseDouble(textView.getText().toString());
            showResult = true;
        }
        dot = false;
        firstOp = false;
    }

    public void add(View view){
        if (!showResult){
            opCommon();
        }
        textView2.setText(format(var1) + " + ");
        typeOp = 1;
    }

    public void subtract(View view){
        if (!showResult){
            opCommon();
        }
        textView2.setText(format(var1) + " - ");
        typeOp = 2;
    }

    public void multiply(View view){
        if (!showResult){
            opCommon();
        }
        textView2.setText(format(var1) + " × ");
        typeOp = 3;
    }

    public void divide(View view){
        if (!showResult){
            opCommon();
        }
        textView2.setText(format(var1) + " ÷ ");
        typeOp = 4;
    }

    public void equal(View view){
        if (!showResult){
            operate();
        } else textView.setText(String.valueOf(format(var1)));

        typeOp = 0;
        dot = false;
        firstOp = true;

        temp = textView2.getText().toString();
        textView2.setText(textView2.getText().toString() + format(var2) +" = " + format(var1) +"\n");

    }

}

//                     ####                                          ##
//                         ##                                      ##
//                            ##                                ##
//                              ##                            ##
//                                 ##                      ##
//                                   ##                  ##
//                                      ##            ##
//                                        ##        ##
//                                           ##  ##
//                                             ##
//                                             #
//
//
//
//
//                       ##
//                       ##                    ##                    ##
//                       ##                    ##                    ##
//                       ##                    ##                    ##
//
//                                       YZMSoft © 2023