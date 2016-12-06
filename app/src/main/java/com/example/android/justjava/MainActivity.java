package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Use of global variables.
    TextView textView_price;
    TextView textView_quantity;
    TextView textView_greetings;
    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_price = (TextView)findViewById(R.id.text_view_price);
        textView_quantity = (TextView)findViewById(R.id.text_view_quantity);
        textView_greetings = (TextView)findViewById(R.id.text_view_greetings);
    }

    public void submitOrder(View view) {
        double priceOfCoffee = 5;

        //quantity = getValueFromTextView(textView_quantity);
        displayQuantity(quantity);
        displayPrice(quantity, priceOfCoffee);

        if(quantity>0) {
            textView_greetings.setText("Thank You!");
        }
        else {
            textView_greetings.setText("Order some first");
        }
    }

    public void incrementQuantity(View view) {
        resetTextViewValue(textView_price);
        resetTextViewValue(textView_greetings);

        //int quantity = getValueFromTextView(textView_quantity);
        quantity++;
        displayQuantity(quantity);
    }

    public void decrementQuantity(View view) {
        resetTextViewValue(textView_price);
        resetTextViewValue(textView_greetings);
        //int quantity = getValueFromTextView(textView_quantity);

        if(quantity > 0){
            quantity--;
        }
        else {
            quantity = 0;
        }
        displayQuantity(quantity);
    }

    private void displayQuantity(int quantity) {
        textView_quantity.setText("" + quantity);
    }

    //sets the price
    private void displayPrice(int quantity, double price) {
        textView_price.setText("Total: " + NumberFormat.getCurrencyInstance().format(price*quantity));
    }

    //Initially text view holds string value, it converts it into int and returns it.
    //But we used global variables to keep track of quantity.
    private int getValueFromTextView(TextView textView) {
        return Integer.parseInt(textView.getText().toString());
    }

    private void resetTextViewValue(TextView textView) {
        textView.setText("");
    }
}
