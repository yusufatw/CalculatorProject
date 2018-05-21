package id.cathode.calculatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private EditText operand;
    private TextView displayOperation;

    //variable to hold the operand and type of the calculations
    private Double operand1 = null;
    private String pendingOperation = "=";

    private static final String STATE_PENDING_OPERATiON = "PendingOperation";
    private static final String STATE_OPERAND1 = "Operand1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.result);
        operand = (EditText) findViewById(R.id.operand);
        displayOperation = (TextView) findViewById(R.id.operation);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        Button buttonDot = (Button) findViewById(R.id.buttonDot);

        Button buttonMultiple = (Button) findViewById(R.id.buttonMultiple);
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button buttonMin = (Button) findViewById(R.id.buttonMin);
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button tap = (Button) view;
                operand.append(tap.getText().toString());
            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button tap = (Button) view;
                String op = tap.getText().toString();
                String value = operand.getText().toString();

                try {
                    Double doubleValue = Double.valueOf(value);
                    performOperation(doubleValue, op);
                } catch (NumberFormatException e){
                    operand.setText("");
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };
        buttonEqual.setOnClickListener(opListener);
        buttonMultiple.setOnClickListener(opListener);
        buttonDivide.setOnClickListener(opListener);
        buttonPlus.setOnClickListener(opListener);
        buttonMin.setOnClickListener(opListener);

        Button buttonNeg = (Button) findViewById(R.id.buttonNeg);

        buttonNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = operand.getText().toString();
                if (value.length()==0){
                    operand.setText("-");
                } else {
                    try {
                        Double doubleValue = Double.valueOf(value);
                        doubleValue *= -1;
                        operand.setText(doubleValue.toString());
                    } catch (NumberFormatException e){
                        //operand was "-" or ".", so clear it
                        operand.setText("");
                    }
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_PENDING_OPERATiON, pendingOperation);
        if (operand1 != null){
            outState.putDouble(STATE_OPERAND1, operand1);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATiON);
        operand1 = savedInstanceState.getDouble(STATE_OPERAND1);
        displayOperation.setText(pendingOperation);
    }

    private void performOperation (Double value, String operation){
        if (null == operand1){
            operand1 = value;
        } else {
            if (pendingOperation.equals("=")){
                pendingOperation = operation;
            }
            switch (pendingOperation){
                case "=":
                    operand1 = value;
                    break;
                case "*":
                    operand1 *=value;
                    break;
                case "/":
                    if (value == 0){
                        operand1 = 0.0;
                    } else {
                        operand1 /= value;
                    }
                    break;
                case "+":
                    operand1 += value;
                    break;
                case "-":
                    operand1 -= value;
                    break;
            }
        }
        result.setText(operand1.toString());
        operand.setText("");
    }
}
