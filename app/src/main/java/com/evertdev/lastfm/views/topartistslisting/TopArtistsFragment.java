package com.evertdev.lastfm.views.topartistslisting;

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
import com.evertdev.lastfm.adapters.TopArtistsAdapter;
import com.evertdev.lastfm.common.Common;
import com.evertdev.lastfm.models.Artist;
import com.evertdev.lastfm.sqlite.SQLiteController;
import com.evertdev.lastfm.views.BaseFragment;
import com.evertdev.lastfm.views.topartistslisting.di.DaggerTopArtistsComponent;
import com.evertdev.lastfm.views.topartistslisting.di.TopArtistsModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopArtistsFragment extends BaseFragment implements TopArtistsView {
    @BindView(R.id.rclr_artists)
    RecyclerView artistsRecyclerView;
    @BindView(R.id.prgrs_main)
    ProgressBar mainProgressBar;
    private OnFragmentInteractionListener mListener;
    @BindView(R.id.empty_layout)
    View emptyLayout;
    @Inject
    TopArtistsPresenter mPresenter;
    TopArtistsAdapter mAdapter;
    SQLiteController sqLiteController;


    public TopArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    protected void searchUserName(String userName) {
        if (mAdapter != null) {
            mAdapter.clearDataset();
        }
        mPresenter.getUserTopArtists(userName, Common.TOP_ITEMS_LIMIT, Common.API_KEY);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artists, container, false);
        ButterKnife.bind(this, view);
        sqLiteController = new SQLiteController(getContext());
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqLiteController = new SQLiteController(getContext());
        DaggerTopArtistsComponent.builder().topArtistsModule(new TopArtistsModule(this)).build().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getUserTopArtists(Common.DEFAULT_LASTFM_USER, Common.TOP_ITEMS_LIMIT, Common.API_KEY);
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
    public void updateData(List<Artist> topArtists) {

        if(Common.getInstance().NetworkStatus(getContext())){
            if (mAdapter == null) {
                for(Artist artist : topArtists){
                    savingData(artist);
                }
                mAdapter = new TopArtistsAdapter(topArtists, getContext(), onArtistclickedListener);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                artistsRecyclerView.setLayoutManager(linearLayoutManager);
                artistsRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            } else {
                mAdapter.setDataset(topArtists);
            }
        }else{
            List<Artist> topArtistOff = new ArrayList<>();
            for (Artist artist : topArtists){
                topArtistOff.add(sqLiteController.getArtistDetail(artist.getName()));
            }
            mAdapter = new TopArtistsAdapter(topArtistOff, getContext(), onArtistclickedListener);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            artistsRecyclerView.setLayoutManager(layoutManager);
            artistsRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void sqlitedata(List<Artist> topArtists) {
        List<Artist> topArtistOff = new ArrayList<>();
        for (Artist artist : topArtists){
            topArtistOff.add(sqLiteController.getArtistDetail(artist.getName()));
        }
        mAdapter = new TopArtistsAdapter(topArtistOff, getContext(), onArtistclickedListener);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        artistsRecyclerView.setLayoutManager(layoutManager);
        artistsRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    //Saving data to SQLite for OFFLINE mode
    private boolean savingData(Artist artist){
        return sqLiteController.SAVE_ARTIST_DATA(artist);
    }


    View.OnClickListener onArtistclickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = artistsRecyclerView.getChildLayoutPosition(view);
            Artist artist = mAdapter.getItemByPosition(position);
            if (mListener != null) {
                mListener.onArtistClicked(artist);
            }
        }
    };

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.general_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmpty() {
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidEmpty() {
        emptyLayout.setVisibility(View.GONE);

    }

    public static TopArtistsFragment newInstance() {
        return new TopArtistsFragment();
    }

    public interface OnFragmentInteractionListener {

        void onArtistClicked(Artist artist);

    }
}
