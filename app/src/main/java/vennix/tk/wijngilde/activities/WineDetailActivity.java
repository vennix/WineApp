package vennix.tk.wijngilde.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import vennix.tk.wijngilde.R;
import vennix.tk.wijngilde.entities.Wine;

public class WineDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_detail);
    }

    public void onBackButtonClick(View v){
        /*
        Intent thisIntent = new Intent(getBaseContext(), WineDetailActivity.class);
        thisIntent
        */
        this.finish();
        Intent previousIntent = new Intent(getBaseContext(), WineActivity.class);
        previousIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(previousIntent);
    }
}
