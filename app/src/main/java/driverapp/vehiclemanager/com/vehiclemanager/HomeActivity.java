package driverapp.vehiclemanager.com.vehiclemanager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.vision.text.Line;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.CacheRequest;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtEmail;
    LinearLayout linear_gas_station, linear_car_repair, linear_car_wash;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private CardView card_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        initUI();
        fireBaseWork();
    }

    private void fireBaseWork() {
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        txtEmail.setText("Welcome "+user.getEmail()+"!");

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

    }

    private void initUI() {
        linear_gas_station = (LinearLayout) findViewById(R.id.linear_gas_station);
        linear_car_repair  = (LinearLayout) findViewById(R.id.linear_car_repair);
        linear_car_wash  = (LinearLayout) findViewById(R.id.linear_car_wash);
        txtEmail = (TextView) findViewById(R.id.email_txt);
        card_view = (CardView) findViewById(R.id.card_view);

        linear_gas_station.setOnClickListener(this);
        linear_car_repair.setOnClickListener(this);
        linear_car_wash.setOnClickListener(this);
        card_view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linear_gas_station:
                if(!checkPermission()){
                   return;
                }
                Intent intentGasStation = new Intent(HomeActivity.this,
                        NearByPlace.class); // explicit intent
                intentGasStation.putExtra("place_type", 0);
                startActivity(intentGasStation);
                break;

            case R.id.linear_car_repair:
                if(!checkPermission()){
                    return;
                }
                Intent intentCarRepair = new Intent(HomeActivity.this,
                        NearByPlace.class); // explicit intent
                intentCarRepair.putExtra("place_type", 1);
                startActivity(intentCarRepair);
                break;

            case R.id.linear_car_wash:
                if(!checkPermission()){
                    return;
                }
                Intent intentCarWash = new Intent(HomeActivity.this,
                        NearByPlace.class); // explicit intent
                intentCarWash.putExtra("place_type", 2);
                startActivity(intentCarWash);
                break;

            case R.id.card_view:
                Toast.makeText(HomeActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;


            default:
                    break;
        }
    }

    private boolean checkPermission() {
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_NETWORK_STATE },
                    13);
            return  false;
        } else {
            return  true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_signout:
                signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //sign out method
    public void signOut() {
        auth.signOut();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }


}
