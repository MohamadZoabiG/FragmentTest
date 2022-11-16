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
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForgotPass#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgotPass extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForgotPass() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgotPassword.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgotPass newInstance(String param1, String param2) {
        ForgotPass fragment = new ForgotPass();
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
        return inflater.inflate(R.layout.forgotpass, container, false);
    }
    private FrameLayout Layout;
    private EditText email;
    private EditText newpass;
    private Button login;
    private FirebaseAuth auth;
    private FragmentTransaction ft;



    @Override
    public void onStart() {
        super.onStart();
        connect();

    }

    private void connect() {
        auth=FirebaseAuth.getInstance();
        email=getView().findViewById(R.id.etemailfrag3);
        login=getView().findViewById(R.id.btnloginfrag3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpassword();


            }
        });


    }

    private void resetpassword() {
        String mail = email.getText().toString();
        if(mail.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Email is required!!", Toast.LENGTH_SHORT).show();
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
        {
            Toast.makeText(getActivity(), "Please Provide Valid email!", Toast.LENGTH_SHORT).show();

        }
        auth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getActivity(), "Check your email to reset password!", Toast.LENGTH_SHORT).show();
                    ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.FrameLayout,new SignIn());  
                    ft.commit();
                }
                else Toast.makeText(getActivity(), "Something wrong happened! , Try again!", Toast.LENGTH_SHORT).show();


            }
        });
    }


}