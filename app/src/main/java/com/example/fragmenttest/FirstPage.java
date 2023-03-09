package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstPage.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstPage newInstance(String param1, String param2) {
        FirstPage fragment = new FirstPage();
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
        return inflater.inflate(R.layout.fragment_first_page, container, false);
    }


    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private FragmentTransaction ft;



    @Override
    public void onStart() {
        super.onStart();
        connect();

    }

    private void connect() {

        txt1 = getView().findViewById(R.id.txt1);
        txt2 = getView().findViewById(R.id.txt2);
        txt3 = getView().findViewById(R.id.txt3);
        img1=getView().findViewById(R.id.mgpc);
        img2=getView().findViewById(R.id. mgmath);
        img3=getView().findViewById(R.id. mgphysics);
        btn1=getView().findViewById(R.id.buttonpc2);
        btn2=getView().findViewById(R.id.buttonmath);
        btn3=getView().findViewById(R.id.buttonphysics);

        btn1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayout,new FragmentAddCourse());
                ft.commit();
            }
        }));
        btn2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayout,new FragmentAddCourse());
                ft.commit();
            }
        }));
        btn3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayout,new FragmentAddCourse());
                ft.commit();
            }
        }));

    }

}