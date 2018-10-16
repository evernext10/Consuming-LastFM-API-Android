package com.evertdev.lastfm.views.toptrackslisting;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.evertdev.lastfm.R;
import com.evertdev.lastfm.adapters.TopTracksAdapter;
import com.evertdev.lastfm.common.Common;
import com.evertdev.lastfm.models.Track;
import com.evertdev.lastfm.sqlite.SQLiteController;
import com.evertdev.lastfm.views.BaseFragment;
import com.evertdev.lastfm.views.toptrackslisting.di.DaggerTopTracksComponent;
import com.evertdev.lastfm.views.toptrackslisting.di.TopTracksModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopTracksFragment extends BaseFragment implements TopTracksView {
    private OnFragmentInteractionListener mListener;
    @BindView(R.id.rclr_tracks)
    RecyclerView tracksRecyclerView;
    @BindView(R.id.prgrs_main)
    ProgressBar mainProgressBar;
    @BindView(R.id.empty_layout)
    View emptyLayout;
    @Inject
    TopTracksPresenter mPresenter;
    TopTracksAdapter mAdapter;
    SQLiteController sqLiteController;

    public TopTracksFragment() {
        // Required empty public constructor
    }


    public static TopTracksFragment newInstance() {
        TopTracksFragment fragment = new TopTracksFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqLiteController = new SQLiteController(getContext());
        DaggerTopTracksComponent.builder().topTracksModule(new TopTracksModule(this)).build().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getTopTracks(Common.DEFAULT_LASTFM_USER, Common.TOP_ITEMS_LIMIT, Common.API_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_tracks, container, false);
        ButterKnife.bind(this, view);
        sqLiteController = new SQLiteController(getContext());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgress() {
        mainProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mainProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.general_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateData(List<Track> tracks) {

        if(Common.getInstance().NetworkStatus(getContext())){
            if (mAdapter == null) {
                for(Track track : tracks){
                    savingData(track);
                }
                mAdapter = new TopTracksAdapter(tracks, getContext(), onTrackClickedListener);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                tracksRecyclerView.setLayoutManager(linearLayoutManager);
                tracksRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            } else {
                mAdapter.setDataset(tracks);
            }
        }else{
            List<Track> topTrackOff = new ArrayList<>();
            for (Track track : tracks){
                topTrackOff.add(sqLiteController.getTrackDetail(track.getName()));
            }
            mAdapter = new TopTracksAdapter(topTrackOff, getContext(), onTrackClickedListener);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            tracksRecyclerView.setLayoutManager(layoutManager);
            tracksRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

        }

    }

    //Saving data to SQLite for OFFLINE mode
    private boolean savingData(Track track){
        return sqLiteController.SAVE_TRACK_DATA(track);
    }


    @Override
    public void showEmpty() {
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidEmpty() {
        emptyLayout.setVisibility(View.GONE);
    }

    @Override
    protected void searchUserName(String userName) {
        if (mAdapter != null) {
            mAdapter.clearDataset();
        }
        mPresenter.getTopTracks(userName, Common.TOP_ITEMS_LIMIT, Common.API_KEY);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void onTrackClicked(Track track);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    View.OnClickListener onTrackClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mListener != null) {
                int position = tracksRecyclerView.getChildAdapterPosition(view);
                Track track = mAdapter.getItemAt(position);
                mListener.onTrackClicked(track);
            }
        }
    };
}
