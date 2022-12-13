package io.mc.mutalk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicWallFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicWallFragment extends Fragment {

    Map<Integer, MusicPost> boards = new LinkedHashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicWallFragment() {
        // Required empty public constructor
        boards.put(29127450, new MusicPost("cOKydzQPXuE", "권오서", "영상 설명 적는곳 가나다", 4));
        boards.put(51670923, new MusicPost("y2ewoCflHhY", "권오서", "마바사아자차", 7));
        boards.put(16983443, new MusicPost("WVuLOk_djws", "이현준", "가가가가나다마", 3));
        boards.put(42356964, new MusicPost("EnyiGmM5M7Y", "이현준", "자차자가나바가아", 5));
        boards.put(29803549, new MusicPost("1fWc6dNKBUo", "용석정", "라가나ㅏ바가나다", 1));
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicWallFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicWallFragment newInstance(String param1, String param2) {
        MusicWallFragment fragment = new MusicWallFragment();
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
        View v = inflater.inflate(R.layout.fragment_music_wall, container, false);
        List<Map.Entry<Integer, MusicPost>> mapEntries = new ArrayList<> (boards.entrySet());

        ListView songList = v.findViewById(R.id.songList);
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MusicPost val = mapEntries.get(i).getValue();

                Intent postIntent = new Intent(v.getContext(), MusicPostActivity.class);
                postIntent.putExtra("id", val.getId());
                postIntent.putExtra("title", val.getTitle());
                postIntent.putExtra("author", val.getAuthor());
                postIntent.putExtra("comment", val.getComment());
                postIntent.putExtra("like", val.getLike());
                startActivity(postIntent);
            }
        });

        MapEntryListAdapter listAdapter = new MapEntryListAdapter(v.getContext(), mapEntries);
        songList.setAdapter(listAdapter);

        return v;
    }
}