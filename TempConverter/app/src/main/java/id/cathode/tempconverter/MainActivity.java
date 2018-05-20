package id.cathode.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Spinner spinner1;
    public static final String[]paths = {"Celcius","Farenheit","Reamure","Kelvin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerTempBeforeConv);

        spinner1 = (Spinner) findViewById(R.id.spinnerTempAfterConv);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
    }

    public void  onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        switch (pos){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
