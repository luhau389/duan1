package czzz.luhau.myapplication.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import czzz.luhau.myapplication.Adapter.Bread_Adapter;
import czzz.luhau.myapplication.Model.Bread;
import czzz.luhau.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bread_Fragment extends Fragment {
    DatabaseReference mData;
    FirebaseDatabase fbdb;
    RecyclerView recyclerView;
    ArrayList<Bread> list_bread;
    Bread_Adapter bread_adapter;


    public Bread_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bread, container, false);
        fbdb = FirebaseDatabase.getInstance();
        mData = fbdb.getReference().child("Cate").child("Bread");

        recyclerView=view.findViewById(R.id.rec_bread);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_bread = new ArrayList<>();
                fbdb=FirebaseDatabase.getInstance();

                for(DataSnapshot dataSnapshotl: dataSnapshot.getChildren()) {
                    Bread bread  =  dataSnapshot.getValue(Bread.class);
                    list_bread.add(bread);

                }
                Toast.makeText(getActivity(), ""+list_bread.size(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), ""+list_bread.get(0).getName().toString(), Toast.LENGTH_SHORT).show();
                bread_adapter = new Bread_Adapter(getActivity(),list_bread);
                recyclerView.setAdapter(bread_adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Có gì sai sai rồi em ơi", Toast.LENGTH_SHORT).show();
            }
        });


        return view ;







    }

}
