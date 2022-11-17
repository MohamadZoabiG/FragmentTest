package com.example.fragmenttest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignIn extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static SignIn newInstance(String param1, String param2) {
        SignIn fragment = new SignIn();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.signin, container, false);
    }
    private FrameLayout Layout;
    private Button register;
    private Button btnLogin;
    private Button btnforgot;
    private EditText emailLogin;
    private EditText passLogin;
    private FirebaseAuth mAuth;
    private FragmentTransaction ft;




    @Override
    public void onStart() {
        super.onStart();
        connect();

    }

    private void connect() {
        mAuth=FirebaseAuth.getInstance();
        register=getView().findViewById(R.id.btnSignupfrag1);
        btnLogin=getView().findViewById(R.id.btnLoginFrag1);
        btnforgot=getView().findViewById(R.id.btnforgotfrag1);
        emailLogin=getView().findViewById(R.id.etEmailLoginfrag1);
        passLogin=getView().findViewById(R.id.etPasswordLoginfrag1);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=emailLogin.getText().toString(),pass=passLogin.getText().toString();
                if(mail.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Email is required!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(pass.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Password is required!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                {
                    Toast.makeText(getActivity(), "Please Provide Valid email!", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length()<6)
                {
                    Toast.makeText(getActivity(), "Min password length should be 6 characters!", Toast.LENGTH_SHORT).show();
                }
                mAuth.signInWithEmailAndPassword(mail, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                        Toast.makeText( getActivity(),"Login successful!", Toast.LENGTH_SHORT).show();
                                        ft = getActivity().getSupportFragmentManager().beginTransaction();
                                        ft.replace(R.id.FrameLayout,new FirstPage());
                                        ft.commit();

                                }
                                else
                                {
                                    Toast.makeText( getActivity(),"Failed to Login!", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }


        });
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayout,new ForgotPass());
                ft.commit();
            }
        });
        register.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayout,new SignUp());
                ft.commit();
            }
        }));

    }


}