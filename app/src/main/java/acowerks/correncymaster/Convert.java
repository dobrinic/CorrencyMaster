package acowerks.correncymaster;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Convert extends AppCompatActivity {

    private EditText firstCurrencyInput;
    private EditText secondCurrencyInput;

    private FloatingActionButton fab;

    private Spinner spinnerOne;
    private Spinner spinnerTwo;

    private String spinnerOneSelection;
    private String spinnerTwoSelection;

    private String spinnerOneInitialSelection;
    private String spinnerTwoInitialSelection;

    RestService restService = new RestService();
    private Double currencyMultiplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.refreshbutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstCurrencyInput.getText().length() > 0 && secondCurrencyInput.getText().length() > 0){
                    fab.animate().rotationBy(360);
                    restService.makeJsonObjectRequest(spinnerOneSelection + spinnerTwoSelection);
                    operacija();
                }
            }
        });


        initWidgets();

        startSpinners();

        restService.makeJsonObjectRequest(spinnerOneInitialSelection + spinnerTwoInitialSelection);
//        currencyMultiplier = Double.valueOf(restService.currencyMultiplier);

//        setForRest(spinnerOneInitialSelection + spinnerTwoInitialSelection);

        spinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerOneSelection = spinnerOne.getItemAtPosition(position).toString();
                spinnerTwoInitialSelection = spinnerTwo.getSelectedItem().toString();

//                setForRest(spinnerOneSelection + spinnerTwoInitialSelection);
                if (spinnerOneSelection != null && spinnerTwoSelection != null) {
                    restService.makeJsonObjectRequest(spinnerOneSelection + spinnerTwoInitialSelection);
                    Toast.makeText(Convert.this, "PRVO:  " + spinnerOneSelection + spinnerTwoInitialSelection, Toast.LENGTH_SHORT).show();

                    operacija();
                }
//                operacija();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initWidgets(){

        firstCurrencyInput = (EditText)findViewById(R.id.firstCurrencyInput);
        firstCurrencyInput.setKeyListener(null);

        secondCurrencyInput = (EditText) findViewById(R.id.secondCurrencyInput);
        secondCurrencyInput.setKeyListener(null);

        spinnerOne = (Spinner) findViewById(R.id.spinnerOne);
        spinnerTwo = (Spinner)findViewById(R.id.spinnerTwo);
    }


//    private void setForRest (String cur){
//        restService.makeJsonObjectRequest(cur);
//        restService.clickForCurrency(cur);
//    }


    private void startSpinners(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, R.layout.support_simple_spinner_dropdown_item);
        spinnerOne.setAdapter(adapter);
        spinnerOneInitialSelection = spinnerOne.getSelectedItem().toString();

        ArrayAdapter<CharSequence> adapterSecond = ArrayAdapter.createFromResource(this, R.array.currenciesSecond, R.layout.support_simple_spinner_dropdown_item);
        spinnerTwo.setAdapter(adapterSecond);
        spinnerTwoInitialSelection = spinnerTwo.getSelectedItem().toString();

        Toast.makeText(Convert.this, "ZADNJE:  " + spinnerOneInitialSelection+spinnerTwoInitialSelection, Toast.LENGTH_SHORT).show();

//        spinnerOneClick();
        spinnerTwoClick();
    }

    private void spinnerOneClick (){

    }

    private void spinnerTwoClick (){
        spinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerTwoSelection = spinnerTwo.getItemAtPosition(position).toString();
                spinnerOneInitialSelection = spinnerOne.getSelectedItem().toString();

                if (restService.currencyMultiplier != null) {
                    restService.makeJsonObjectRequest(spinnerOneInitialSelection + spinnerTwoSelection);
                    Toast.makeText(Convert.this, "DRUGO:  " + spinnerOneInitialSelection + spinnerTwoSelection, Toast.LENGTH_SHORT).show();

                    operacija();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    private void operacija(){

        currencyMultiplier = Double.valueOf(restService.currencyMultiplier);

        if (firstCurrencyInput.isFocused()) {
            double currencyInputDouble = Double.valueOf(firstCurrencyInput.getText().toString());
            double resultDouble = currencyInputDouble * currencyMultiplier;

            DecimalFormat df = new DecimalFormat();
            df.setGroupingSize(3);
            String resultDoubleIspis = df.format(resultDouble);
            secondCurrencyInput.setText(String.valueOf(resultDoubleIspis));
        }
        else if(secondCurrencyInput.isFocused()) {
            double currencyInputDouble = Double.valueOf(secondCurrencyInput.getText().toString());
            double resultDouble = currencyInputDouble / currencyMultiplier;

            DecimalFormat df = new DecimalFormat();
            df.setGroupingSize(3);
            String resultDoubleIspis = df.format(resultDouble);
            firstCurrencyInput.setText(String.valueOf(resultDoubleIspis));
        }
    }



    public void addNumber(View view){

        EditText editableCurrencyField = null;

        if (firstCurrencyInput.isFocused()) {
            editableCurrencyField = firstCurrencyInput;
        }
        else if(secondCurrencyInput.isFocused()) {
            editableCurrencyField = secondCurrencyInput;
        }

        String lastInput = editableCurrencyField.getText().toString();

        switch (view.getId()){
            case R.id.one:
                editableCurrencyField.setText(lastInput + "1");
                operacija();
                break;
            case R.id.two:
                editableCurrencyField.setText(lastInput + "2");
                operacija();
                break;
            case R.id.three:
                editableCurrencyField.setText(lastInput + "3");
                operacija();
                break;
            case R.id.four:
                editableCurrencyField.setText(lastInput + "4");
                operacija();
                break;
            case R.id.five:
                editableCurrencyField.setText(lastInput + "5");
                operacija();
                break;
            case R.id.six:
                editableCurrencyField.setText(lastInput + "6");
                operacija();
                break;
            case R.id.seven:
                editableCurrencyField.setText(lastInput + "7");
                operacija();
                break;
            case R.id.eight:
                editableCurrencyField.setText(lastInput + "8");
                operacija();
                break;
            case R.id.nine:
                editableCurrencyField.setText(lastInput + "9");
                operacija();
                break;
            case R.id.zero:
                if (lastInput.equals("")){
                    editableCurrencyField.setText(lastInput + "0.");
                }else {
                    editableCurrencyField.setText(lastInput + "0");
                    operacija();
                }
                break;
            case R.id.point:
                if (lastInput.equals("")){
                    editableCurrencyField.setText(lastInput + "0.");
                }else if (lastInput.contains(".")){
                    editableCurrencyField.setText(lastInput + "");
                }else {
                    editableCurrencyField.setText(lastInput + ".");
                }
                break;
            default:
                break;
        }
    }

    public void removeLast(View view){

        EditText editableCurrencyField = null;
        EditText resultCurrencyField = null;

        if (firstCurrencyInput.isFocused()) {
            editableCurrencyField = firstCurrencyInput;
            resultCurrencyField = secondCurrencyInput;
        }
        else if(secondCurrencyInput.isFocused()) {
            editableCurrencyField = secondCurrencyInput;
            resultCurrencyField = firstCurrencyInput;
        }

        String lastInput = editableCurrencyField.getText().toString();

        if (lastInput.equals("")){
            Toast.makeText(this, R.string.removeLastError, Toast.LENGTH_LONG).show();
        }else{
            editableCurrencyField.setText(lastInput.substring(0, (lastInput.length()) - 1));
            if (editableCurrencyField.getText().length()>0){
                operacija();
            }else {
                resultCurrencyField.setText("");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convert, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
