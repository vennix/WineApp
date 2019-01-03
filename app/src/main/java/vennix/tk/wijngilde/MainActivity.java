package vennix.tk.wijngilde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import vennix.tk.wijngilde.activities.WineActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onWineButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), WineActivity.class);
        startActivity(myIntent);
    }

}
