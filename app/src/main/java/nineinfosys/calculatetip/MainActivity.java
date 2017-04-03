package nineinfosys.calculatetip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView billTextView,percentageTextView,splitTextView,totalTextView;
    TextView personpayTextview,totalBillTextview;

    EditText billEditText,percentageEditText,splitEditText;


    //tipCalc tipCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billTextView=(TextView)findViewById(R.id.textViewBill);
        percentageTextView=(TextView)findViewById(R.id.textViewPercentage);
        splitTextView=(TextView)findViewById(R.id.textViewSplit);
        totalTextView=(TextView)findViewById(R.id.textViewTotal);
        personpayTextview=(TextView)findViewById(R.id.textViewPersonPays);
        totalBillTextview=(TextView)findViewById(R.id.textViewTotalBill);


        billEditText=(EditText)findViewById(R.id.edittextBill);
        percentageEditText=(EditText)findViewById(R.id.edittextPercentage);
        splitEditText=(EditText)findViewById(R.id.edittextSplit);


        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);


        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(billEditText.getText().toString().trim())) {
                    billEditText.setError("enter the Bill Amount");
                    return;
                }
                if (TextUtils.isEmpty(percentageEditText.getText().toString().trim())) {
                    percentageEditText.setError("enter the Tip Percentage");
                    return;
                }
                if (TextUtils.isEmpty(splitEditText.getText().toString().trim())) {
                    splitEditText.setError("How many Persons would you like to split the bill");
                    return;
                }



                double billAmountValue=Double.parseDouble(billEditText.getText().toString().trim());
                double tipPercentageValue=Double.parseDouble(percentageEditText.getText().toString().trim());
                double splitPersonValue=Double.parseDouble(splitEditText.getText().toString().trim());


                String billAmountValue1 = Double.toString((double) billAmountValue);
                String tipPercentageValue1 = Double.toString((double) tipPercentageValue);
                String splitPersonValue1 = Double.toString((double) splitPersonValue);

                tipCalc Calculator = new tipCalc();
                tipCalc Calculator1 = new tipCalc();


                tipCalc.calBill( billAmountValue );
                Calculator.percTip(billAmountValue,tipPercentageValue);


                //  tipCalculator=new tipCalc();
              double resultgrossDomesticProductValue=Calculator.percTip(billAmountValue,tipPercentageValue);
                double resultgrossDomesticProductValue1=tipCalc.calBill( billAmountValue);

                //   String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);
                totalTextView.setText( "Bill Amount:".toString()+Double.toString((double) resultgrossDomesticProductValue1)+"Rs");
                totalBillTextview.setText( " Total Tip Value:".toString()+Double.toString((double) resultgrossDomesticProductValue)+"Rs");


                Calculator1.Split(resultgrossDomesticProductValue,splitPersonValue);

                double billPerPerson= Calculator1.Split(resultgrossDomesticProductValue,splitPersonValue);

                personpayTextview.setText( " Each Person Tip Value:".toString()+Double.toString((double) billPerPerson)+"Rs");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billEditText.getText().clear();
                percentageEditText.getText().clear();
                splitEditText.getText().clear();
                totalTextView.setText("");
                totalBillTextview.setText("");
                personpayTextview.setText("");


            }
        });
    }
}
