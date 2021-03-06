package com.santamaria.dronehere.Dronedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.santamaria.dronehere.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabDrone extends Fragment {

    SelectCategory selectCategory;
    RecyclerView recyclerView;
    MySpinner spinner;
    TabDroneAdapter db2;
    EditText editText;

    int cnt = 0;
    LinearLayoutManager layoutManager;

   // JJSearchView mJJSearchView;
    Boolean mSearchBarAnimBool = true;

    public TabDrone() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db2 = new TabDroneAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_db, container, false);
        spinner = (MySpinner) view.findViewById(R.id.spinner);
        recyclerView = (RecyclerView) view.findViewById(R.id.ryview);
        editText = (EditText) view.findViewById(R.id.drone_search);
        //button=(Button)view.findViewById(R.id.drone_search_btn);
        //gone_text=(TextView)view.findViewById(R.id.gone_text);
        //logo=(ImageView)view.findViewById(R.id.imageView6);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.sort, R.layout.spinner_view);
        adapter.setDropDownViewResource(R.layout.setting_list_view_2);
        spinner.setAdapter(adapter);
        /** 픽셀 = dp 곱하기 3 **/
        spinner.setDropDownVerticalOffset(105);
        spinner.setDropDownWidth(300);
        recyclerView.setAdapter(db2);
        recyclerView.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        //mJJSearchView = (JJSearchView) view.findViewById(R.id.jjsv);
        //mJJSearchView.setController(new JJBarWithErrorIconController());

       /* editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mSearchBarAnimBool==true) {
                    mJJSearchView.startAnim();
                    mSearchBarAnimBool = false;
                }
                else {
                    mJJSearchView.resetAnim();
                    mSearchBarAnimBool = true;
                }
            }
        });*/
        editText.setHint(R.string.drone_pick);
        selectCategory = new SelectCategory(getContext(), spinner, editText, db2, layoutManager, recyclerView);

        /** 텍스트 변화 감지 **/
        selectCategory.text_listener();
        /** 초기화면 이름 순으로 드론 출력**/
        selectCategory.recommand_list();

        /** 리사이클러 뷰 아이템 선택 시 상세 드론 페이지 이동 **/
        db2.setOnItemClickListener(new TabDroneAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(TabDroneViewholder holder, View view, String s, int position) {
                Intent intent = new Intent(getActivity(), DroneDetail.class);
                intent.putExtra("_id", s);
                startActivity(intent);
            }
        });





        return view;  //

    }

    @Override
    public void onResume() {
        super.onResume();
        //cnt=0;
        //logo.setVisibility(View.VISIBLE);
        //gone_text.setVisibility(View.VISIBLE);
        //layoutManager.setStackFromEnd(false);

        /** 스피너 아이템 선택 리스너 **/
        selectCategory.select_spinner();
    }
}
