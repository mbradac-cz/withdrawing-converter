package space.android_dev.withdrawingconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertFunction (View view) {

        EditText inputForeignCurr = (EditText) findViewById(R.id.inputForeignCurr);
        EditText inputHomeCurr = (EditText) findViewById(R.id.inputHomeCurr);

        String inForeignCurr = inputForeignCurr.getText().toString();
        String inHomeCurr = inputHomeCurr.getText().toString();

        Double rateCZKtoEUR =  0.038;
        Double rateEURtoCZK =  26.11;

        if (inForeignCurr.isEmpty() && !inHomeCurr.isEmpty()) {
            Double HomeCurr = Double.parseDouble(inputHomeCurr.getText().toString());
            Double res = HomeCurr * rateCZKtoEUR;
            inputForeignCurr.setText(res.toString());

        } else if (inHomeCurr.isEmpty() && !inForeignCurr.isEmpty()) {
            Double ForreignCurr = Double.parseDouble(inputForeignCurr.getText().toString());
            Double res = ForreignCurr *rateEURtoCZK;
            inputHomeCurr.setText(res.toString());

        } else if (!inForeignCurr.isEmpty() && !inHomeCurr.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Both inputs cannot be inserted !", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(),"Nothing inserted !", Toast.LENGTH_SHORT).show();

        }
    }

    public void clearFunction (View view){
        EditText inputForeignCurr = (EditText) findViewById(R.id.inputForeignCurr);
        EditText inputHomeCurr = (EditText) findViewById(R.id.inputHomeCurr);

        inputForeignCurr.setText("");
        inputHomeCurr.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
