package mx.yellowme.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.yellowme.app.simple.UmbrellaActivity;
import mx.yellowme.app.simple.UmbrellaFragment;

public class MainActivity extends AppCompatActivity {

    private Button example1;
    private Button example2;
    private Button example3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        example1 = (Button) findViewById(R.id.example1);

        example2 = (Button) findViewById(R.id.example2);
        example2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent().setClass(getApplicationContext(), UmbrellaActivity.class);
                startActivity(intent);
            }
        });

        example3 = (Button) findViewById(R.id.example3);
    }
}
