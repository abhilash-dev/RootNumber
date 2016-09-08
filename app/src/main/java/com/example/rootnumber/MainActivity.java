package com.example.rootnumber;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        btnGenerateRootNo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int sum = 0, rootNo = 0;
        char[] inputArray = etInput.getText().toString().toCharArray();
        Map<String, Integer> charValMap = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
            put("d", 4);
            put("e", 5);
            put("f", 8);
            put("g", 3);
            put("h", 5);
            put("i", 1);
            put("j", 1);
            put("k", 2);
            put("l", 3);
            put("m", 4);
            put("n", 5);
            put("o", 7);
            put("p", 8);
            put("q", 1);
            put("r", 2);
            put("s", 3);
            put("t", 4);
            put("u", 6);
            put("v", 6);
            put("w", 6);
            put("x", 5);
            put("y", 1);
            put("z", 7);
        }};

        for (int i = 0; i < inputArray.length; i++) {
            if (android.text.TextUtils.isDigitsOnly(String.valueOf(inputArray[i]))) {
                sum += Integer.parseInt(String.valueOf(inputArray[i]).toLowerCase());
            } else if (String.valueOf(inputArray[i]).equals(" ")) {
                continue;
            } else {
                sum += charValMap.get(String.valueOf(inputArray[i]).toLowerCase());
            }
        }

        while (sum > 0) {
            rootNo += sum % 10;
            sum /= 10;
        }

        if(rootNo>9){
            sum = rootNo;
            rootNo = 0;
            while (sum > 0) {
                rootNo += sum % 10;
                sum /= 10;
            }
        }


        if (rootNo <= 0 || rootNo > 9) {
            Toast.makeText(MainActivity.this, "Please check the input & try again", Toast.LENGTH_LONG).show();
        } else {
            this.tvOutput.setText(String.valueOf(rootNo));
        }
    }
}
