package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private TextView textField,result_text,a;
    private int firstValue;
    private String selectedOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textField=findViewById(R.id.result);
        a = findViewById(R.id.result);
        result_text = findViewById(R.id.result);
        List<Button> x=new ArrayList();

        for(int i=0;i<=9;i++)
        {
            String string ="button"+i;
            int resid=getResources().getIdentifier(string,"id",getPackageName());
            x.add(findViewById(resid));
            listener(x.get(i));
        }
        //Button minus=findViewById((R.id.buttonminus));
        //listener(minus);
        //Button add=findViewById((R.id.buttonadd));
        findViewById(R.id.buttonadd).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttonminus).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttondivide).setOnClickListener(view -> operandSelected((Button) view));
        findViewById(R.id.buttonx).setOnClickListener(view -> operandSelected((Button) view));
        /*
        Button multiply=findViewById((R.id.buttonx));
        listener(multiply);
        Button divide=findViewById((R.id.buttondivide));
        listener(divide);

        listener(clear);
        Button equate=findViewById((R.id.buttonequate));
        */
        Button clear=findViewById((R.id.buttonclear));
        clear.setOnClickListener(view->textField.setText(""));

        findViewById(R.id.buttonequate).setOnClickListener(view -> performCalculation());
    }


    public void listener(Button a) {
            a.setOnClickListener(view -> {
            Button b=(Button) view;
            Log.d(TAG,"button clicked "+ b.getText());
            textField.append(b.getText());
            });
    }

    private void operandSelected(Button button) {
        firstValue = Integer.parseInt(textField.getText().toString());
        selectedOperator = button.getText().toString();
        boolean flag=true;
        
        textField.setText("");

    }

    private void performCalculation() {
        int val = 0;
        if(textField.getText().equals(""))
        {return ;}

        switch (selectedOperator){
            case "+":
                val = firstValue + Integer.parseInt(textField.getText().toString());
                break;
            case "-":
                val = firstValue - Integer.parseInt(textField.getText().toString());
                break;
            case "x":
                val = firstValue * Integer.parseInt(textField.getText().toString());
                break;
            case "/":
                val = firstValue / Integer.parseInt(textField.getText().toString());
                break;
            case "C":
                val = firstValue / Integer.parseInt(textField.getText().toString());
                break;
            default:
                result_text.setText(String.valueOf(val));
                break;

        }
        result_text.setText(String.valueOf(val));
    }


}