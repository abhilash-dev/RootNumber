package com.example.rootnumber;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvTitleMessage, tvOutput;
    private EditText etInput;
    private Button btnGenerateRootNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitleMessage = (TextView) findViewById(R.id.tvTitleMessage);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/FHACondFrenchNC.ttf");
        tvTitleMessage.setTypeface(tf);

        tvOutput = (TextView) findViewById(R.id.tvOutput);
        tvOutput.setTypeface(tf);

        etInput = (EditText) findViewById(R.id.etInput);

        btnGenerateRootNo = (Button) findViewById(R.id.btnGenerateRootNo);
        btnGenerateRootNo.setOnClickListener(new myClickListener());

    }

    int generateRootNo(String input) {
        int sum = 0, rootNo;
        char[] inputArray = input.toCharArray();

        for (int i = 0; i < inputArray.length; i++) {
            if (android.text.TextUtils.isDigitsOnly(String.valueOf(inputArray[i]))) {
                sum += Integer.parseInt(String.valueOf(inputArray[i]));
            }else if(String.valueOf(inputArray[i]) == " "){
                continue;
            }
        }

        return rootNo;
    }

    private class myClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int rootNo = generateRootNo(etInput.getText().toString());

            if (rootNo <= 0 || rootNo > 9) {
                tvOutput.setText(rootNo);
            } else {
                Toast.makeText(MainActivity.this, "Please check the input & try again", Toast.LENGTH_LONG).show();
            }
        }
    }
}
