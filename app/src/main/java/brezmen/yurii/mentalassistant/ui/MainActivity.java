package brezmen.yurii.mentalassistant.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import brezmen.yurii.mentalassistant.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartSearch = (Button) findViewById(R.id.buttonStart);
        Button buttonStartTest = (Button) findViewById(R.id.button);
        Button buttonExit = (Button) findViewById(R.id.buttonExit);

        buttonStartSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStartDiagnostics = new Intent(MainActivity.this, DiagnosticsActivity.class);
                startActivity(intentStartDiagnostics);
            }
        });

        buttonStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStartTest = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intentStartTest);
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}