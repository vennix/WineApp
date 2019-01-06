package vennix.tk.wijngilde;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import vennix.tk.wijngilde.activities.EventActivity;
import vennix.tk.wijngilde.activities.KindActivity;
import vennix.tk.wijngilde.activities.MemberActivity;
import vennix.tk.wijngilde.activities.WineActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (menuItem.getItemId()) {
                            case android.R.id.home:
                                mDrawerLayout.openDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_events:
                                startSelectedMenuActivity("events");
                                break;
                            case R.id.nav_wines:
                                startSelectedMenuActivity("wines");
                                break;
                            case R.id.nav_member:
                                startSelectedMenuActivity("member");
                                break;
                            default:
                                return true;
                        }
                        return true;
                    }
                });

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String log;
        switch (item.getItemId()) {
            case android.R.id.home:
                log = "returning home";
                Log.e(log, "index");
                mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void startSelectedMenuActivity(String item){
        Intent intent;
        switch (item) {
            case "events":
                intent = new Intent(this, EventActivity.class);
                this.startActivity(intent);
                break;
            case "wines":
                intent = new Intent(this, KindActivity.class);
                this.startActivity(intent);
                break;
            case "member":
                intent = new Intent(this, MemberActivity.class);
                this.startActivity(intent);
                break;
            default:
                mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    public void onWineButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), WineActivity.class);
        startActivity(myIntent);
    }

}
