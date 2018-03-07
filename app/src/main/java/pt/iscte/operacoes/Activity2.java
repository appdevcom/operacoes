package pt.iscte.operacoes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        doMath();
    }

    public void doMath(){
        Bundle bundle= getIntent().getExtras();

        float number1= bundle.getFloat("number1");
        float number2= bundle.getFloat("number2");

        String sOp= bundle.getString("op");


        float result=0;
        String sResponse;

        switch (sOp){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0)
                    result=0;
                else
                    result = number1 + number2;
        }


        if (number2 == 0 && sOp== "/")
            sResponse="Erro: segundo numero nao pode ser 0 na divisao";
         else if ( sOp=="")
            sResponse = "Erro: não definiu operação";
        else
            sResponse = String.format("O resultado de %s entre %s e %s é %.2f", sOp, number1, number2, result);

        TextView result_tv = (TextView) findViewById(R.id.result_tv );

        result_tv.setText(sResponse);



    }

    public void voltar(View view){
        finish();
    }

}
