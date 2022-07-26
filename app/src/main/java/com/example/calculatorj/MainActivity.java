package com.example.calculatorj;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldN = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldN.substring(0, cursorPos);
        String rightStr = oldN.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void zeroBT (View view){
        updateText("0");
    }

    public void oneBT (View view){
        updateText("1");
    }

    public void twoBT (View view){
        updateText("2");
    }

    public void threeBT (View view){
        updateText("3");
    }

    public void fourBT (View view){
        updateText("4");
    }

    public void fiveBT (View view){
        updateText("5");
    }

    public void sixBT (View view){
        updateText("6");
    }

    public void sevenBT (View view){
        updateText("7");
    }

    public void eightBT (View view){
        updateText("8");
    }

    public void nineBT(View view){
        updateText("9");
    }

    public void clearBT (View view){
        display.setText("");
    }

    public void expBT (View view){
        updateText("^");
    }

    public void devideBT (View view){
        updateText("/");
    }

    public void multBT (View view){
        updateText("×");
    }

    public void subBT (View view){
        updateText("-");
    }

    public void addBT (View view){
        updateText("+");
    }

    public void plusMinusBT(View viwe){
        updateText("-");
    }

    public void equalBT (View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");
        //userExp = userExp.replaceAll("%", "");
        
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }

    public void komaBT (View view){
        updateText(".");
    }
}
