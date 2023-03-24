package com.example.fragmenttest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllCourses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllCourses extends Fragment {

//  TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllCourses() {
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
    public static AllCourses newInstance(String param1, String param2) {
        AllCourses fragment = new AllCourses();
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
    ArrayList<Course> AddCoursearraylist;
    MyAdapter myAdapter;
    FirebaseFirestore fbs;


    @Override
    public void onStart() {
        super.onStart();
        connect();

    }


    private void connect() {
        recyclerView=getView().findViewById(R.id.recyclerView);
        fbs=FirebaseFirestore.getInstance();
        showallcourses();
        AddCoursearraylist=new ArrayList<Course>();
        myAdapter =new MyAdapter(getActivity(), AddCoursearraylist); // TODO: flip parameters order

    }
    private void showallcourses() {

        fbs.collection("Courses_").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(error!=null)
                {
                    Log.e("Firestore error",error.getMessage());
                    return;
                }

                for(DocumentChange dc:value.getDocumentChanges()){
                    if(dc.getType()==DocumentChange.Type.ADDED){
                        AddCoursearraylist.add(dc.getDocument().toObject((Course.class)));

                    }

                    myAdapter.notifyDataSetChanged();
                }

            }
        });

    }

}