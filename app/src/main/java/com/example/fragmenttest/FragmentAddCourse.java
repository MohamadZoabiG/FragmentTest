package com.example.fragmenttest;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAddCourse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAddCourse extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAddCourse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAddCourse.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAddCourse newInstance(String param1, String param2) {
        FragmentAddCourse fragment = new FragmentAddCourse();
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
        return inflater.inflate(R.layout.fragment_add_course, container, false);
    }
    private EditText Title , Producer , Length ,Date;
    private FirebaseServices fbs;
    private Button btnadd;

    @Override
    public void onStart() {
        super.onStart();
        addcourse();
    }

    private void addcourse() {
        fbs=new FirebaseServices().getInstance();
        Title=getView().findViewById(R.id.etTitle);
        Date=getView().findViewById(R.id.etDate);
        Producer=getView().findViewById(R.id.etProducer);
        Length=getView().findViewById(R.id.etLength);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                addtofirestore();
            }
        });

    }

    private void addtofirestore() {
        String title , producer , length ,date;

        title=Title.getText().toString();
        date=Date.getText().toString();
        producer=Producer.getText().toString();
        length=Length.getText().toString();

        if(title.trim().isEmpty() || date.trim().isEmpty() || producer.trim().isEmpty() || length.trim().isEmpty())
        {
            Toast.makeText(getActivity(), "some data is missing", Toast.LENGTH_SHORT).show();
            return;
        }
        AddCourse addcourse = new AddCourse(title,date,producer,length);

        fbs.getFire().collection("course").document("LA")
                .set(addcourse)
                .addOnSuccessListener(new Onsuccess)



                  .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });

    }
}