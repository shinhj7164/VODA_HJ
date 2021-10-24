package com.example.voda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainmenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainmenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView menuListView;
    private MenuCustomAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainmenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainmenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainmenuFragment newInstance(String param1, String param2) {
        MainmenuFragment fragment = new MainmenuFragment();
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
        View view = inflater.inflate(R.layout.fragment_mainmenu, container, false);
        menuListView = view.findViewById(R.id.rv_mainMenuFragment);
        GridLayoutManager gm = new GridLayoutManager(getActivity(),4,GridLayoutManager.VERTICAL,false);
        menuListView.setLayoutManager(gm);

        ArrayList<MenuItem> items = new ArrayList<>();

        //파이어베이스 값들고오는 과정
        database = FirebaseDatabase.getInstance();// 연동

        databaseReference = database.getReference("voda_handy");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //파베의 데베를 받아오는곳
                items.clear();//방지차원에서 초기화

                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    MenuItem menuItem = snapshot1.getValue(MenuItem.class);//만들어둔 객체에 데이터 담기
                    items.add(menuItem); //담은 데이터를 쭉 추가
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //에러발생시
            }
        });

        adapter = new MenuCustomAdapter(getContext(), items);
        menuListView.setAdapter(adapter);

        return view;
    }
}