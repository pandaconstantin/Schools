package org.project.school.schools;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SchoolRecycleViewer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SchoolRecycleViewer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SchoolRecycleViewer extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView mRecyclerView ;
    private RecyclerView.Adapter mAdapter ;

    private OnFragmentInteractionListener mListener;


    
    // TODO: Rename and change types and number of parameters
    public static SchoolRecycleViewer newInstance() {
        SchoolRecycleViewer fragment = new SchoolRecycleViewer();
        Bundle args = new Bundle();
       // args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        ///fragment.setArguments(args);
        return new SchoolRecycleViewer();
    }

    public SchoolRecycleViewer() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_school_recycle_viewer, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView  = (RecyclerView) view.findViewById(R.id.schoolRecycleViewer);
        RecyclerView.LayoutManager layoutManager  =  new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Affichage de 5 contenu
        List<Object> mContentsItems = new ArrayList<>();
        for(int i=0 ;i < 5 ; i++)
            mContentsItems.add(new Object());

        mAdapter =  new RecyclerViewMaterialAdapter(new SchoolRecycleViewerAdapter(mContentsItems));
        mRecyclerView.setAdapter(mAdapter);

        MaterialViewPagerHelper.registerRecyclerView(getActivity(),mRecyclerView,null);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
