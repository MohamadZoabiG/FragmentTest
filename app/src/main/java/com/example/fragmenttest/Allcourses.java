package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Allcourses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Allcourses extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Allcourses() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Allcourses.
     */
    // TODO: Rename and change types and number of parameters
    public static Allcourses newInstance(String param1, String param2) {
        Allcourses fragment = new Allcourses();
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
        return inflater.inflate(R.layout.fragment_allcourses, container, false);
    }

    private RecyclerView recyclerView;
    ArrayList<AddCourse> AddCoursearraylist;
    MyAdapter myAdapter;
    FirebaseFirestore db;


    @Override
    public void onStart() {
        super.onStart();
        connect();
        showallcourses();

    }


    private void connect() {
        recyclerView=getView().findViewById(R.id.recyclerView);
        db=FirebaseFirestore.getInstance();
        AddCoursearraylist=new ArrayList<AddCourse>();
        myAdapter =new MyAdapter(allcourses,this.AddCoursearraylist);
    }
    private void showallcourses() {

    }

}