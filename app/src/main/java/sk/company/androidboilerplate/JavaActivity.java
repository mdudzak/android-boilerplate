package sk.company.androidboilerplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;


public class JavaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}