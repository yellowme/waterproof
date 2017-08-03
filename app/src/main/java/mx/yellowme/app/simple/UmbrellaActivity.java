package mx.yellowme.app.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.yellowme.app.R;

public class UmbrellaActivity extends AppCompatActivity {

    private UmbrellaFragment umbrellaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        if(findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null) {
                return;
            }

            umbrellaFragment = new UmbrellaFragment();
            umbrellaFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, umbrellaFragment).commit();
        }
    }
}
