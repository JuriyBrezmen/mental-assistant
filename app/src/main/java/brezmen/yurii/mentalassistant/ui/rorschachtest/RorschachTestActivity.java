package brezmen.yurii.mentalassistant.ui.rorschachtest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import brezmen.yurii.mentalassistant.R;

public class RorschachTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rorschach_test);

        // show RorschachQuestionFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, RorschachQuestionFragment.newInstance(), RorschachQuestionFragment.TAG);
        transaction.commitAllowingStateLoss();
    }
}

