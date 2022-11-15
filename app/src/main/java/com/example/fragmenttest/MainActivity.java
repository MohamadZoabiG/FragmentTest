package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private Button Fragment1;
    private Button Fragment2;
    private FrameLayout Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();

    }

    private void connect() {
    Fragment1=findViewById(R.id.btnFrag1);
    Fragment2=findViewById(R.id.btnFrag2);
    Layout=findViewById(R.id.FrameLayout);
    }

    public void Frag1(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayout,new SignIn());
        ft.commit();
    }

    public void Frag2(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayout,new SignUp());
        ft.commit();
    }
}