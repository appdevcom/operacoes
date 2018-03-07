package pt.iscte.operacoes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
    }

    public void doOperation (View view){
        EditText number1_txt= (EditText) findViewById(R.id.number1_txt);
        EditText number2_txt= (EditText) findViewById(R.id.number2_txt);
        String op="";

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);


        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton= (RadioButton) findViewById(selectedId);
        op= radioButton.getText().toString();

        int number1 = Integer.parseInt(number1_txt.getText().toString());
        int number2 = Integer.parseInt(number2_txt.getText().toString());

        Intent intent = new Intent(this, Activity2.class);

        Bundle bundle= new Bundle();

        bundle.putFloat("number1", number1);
        bundle.putFloat("number2", number2);
        bundle.putString("op", op);

        intent.putExtras(bundle);

        startActivity(intent);

        /*you should use putInt */

    }
}
