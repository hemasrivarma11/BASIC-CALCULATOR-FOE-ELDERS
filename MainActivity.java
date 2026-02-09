package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnMul.setOnClickListener(v -> calculate('*'));
        btnDiv.setOnClickListener(v -> calculate('/'));
    }


    private void calculate(char operator) {

        if (etNum1.getText().toString().isEmpty() ||
                etNum2.getText().toString().isEmpty()) {

            Toast.makeText(this, "PLEASE ENTER BOTH NUMBERS", Toast.LENGTH_SHORT).show();

            new AlertDialog.Builder(this)
                    .setTitle("Input Error")
                    .setMessage("PLEASE ENTER BOTH NUMBERS BEFORE CALCULATING")
                    .setPositiveButton("OK", null)
                    .show();
            return;
        }

        double num1 = Double.parseDouble(etNum1.getText().toString());
        double num2 = Double.parseDouble(etNum2.getText().toString());
        double result;
        String operation = "";

        Toast.makeText(this, "NUMBERS HAVE BEEN INSERTED", Toast.LENGTH_SHORT).show();

        switch (operator) {
            case '+':
                result = num1 + num2;
                operation = "Addition";
                Toast.makeText(this, "ADDITION IS PERFORMED", Toast.LENGTH_SHORT).show();
                break;

            case '-':
                result = num1 - num2;
                operation = "Subtraction";
                Toast.makeText(this, "SUBTRACTION IS PERFORMED", Toast.LENGTH_SHORT).show();
                break;

            case '*':
                result = num1 * num2;
                operation = "Multiplication";
                Toast.makeText(this, "MULTIPLICATION IS PERFORMED", Toast.LENGTH_SHORT).show();
                break;

            case '/':
                if (num2 == 0) {
                    Toast.makeText(this, "CANNOT DIVIDE BY ZERO", Toast.LENGTH_SHORT).show();

                    new AlertDialog.Builder(this)
                            .setTitle("Math Error")
                            .setMessage("Division by zero is not allowed.")
                            .setPositiveButton("OK", null)
                            .show();
                    return;
                }
                result = num1 / num2;
                operation = "Division";
                Toast.makeText(this, "DIVISION IS PERFORMED", Toast.LENGTH_SHORT).show();
                break;

            default:
                return;
        }

        tvResult.setText("Result: " + result);
        Toast.makeText(this, "RESULT IS DISPLAYED", Toast.LENGTH_SHORT).show();

        // 🔔 ALERT DIALOG RESULT POPUP
        new AlertDialog.Builder(this)
                .setTitle(operation + " Result")
                .setMessage("Result = " + result)
                .setPositiveButton("OK", null)
                .show();
    }
}
