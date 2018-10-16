package com.evertdev.lastfm.views.topalbumslisting;

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
import com.evertdev.lastfm.adapters.TopAlbumsAdapter;
import com.evertdev.lastfm.common.Common;
import com.evertdev.lastfm.models.Album;
import com.evertdev.lastfm.sqlite.SQLiteController;
import com.evertdev.lastfm.views.BaseFragment;
import com.evertdev.lastfm.views.topalbumslisting.di.DaggerTopAlbumsComponent;
import com.evertdev.lastfm.views.topalbumslisting.di.TopAlbumsModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TopAlbumsFragment extends BaseFragment implements TopAlbumsView {
    @BindView(R.id.rclr_albums)
    RecyclerView albumsRecyclerView;
    @BindView(R.id.prgrs_main)
    ProgressBar mainprogressBar;
    @BindView(R.id.empty_layout)
    View emptyLayout;
    @Inject
    TopAlbumsPresenter mPresenter;
    TopAlbumsAdapter mAdapter;
    private OnFragmentInteractionListener mListener;
    SQLiteController sqLiteController;

    public TopAlbumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_albums, container, false);
        ButterKnife.bind(this, view);
        sqLiteController = new SQLiteController(getContext());
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqLiteController = new SQLiteController(getContext());
        DaggerTopAlbumsComponent.builder().topAlbumsModule(new TopAlbumsModule(this)).build().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getTopAlbums(Common.DEFAULT_LASTFM_USER, Common.TOP_ITEMS_LIMIT, Common.API_KEY);
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
    protected void searchUserName(String userName) {
        if (mAdapter != null) {
            mAdapter.clearDataset();
        }
        mPresenter.getTopAlbums(userName, Common.TOP_ITEMS_LIMIT, Common.API_KEY);

    }

    @Override
    public void showProgress() {
        mainprogressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mainprogressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.general_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateData(List<Album> topAlbums) {

        if(Common.getInstance().NetworkStatus(getContext())){
            if (mAdapter == null) {
                for(Album album : topAlbums){
                    savingData(album);
                }

                mAdapter = new TopAlbumsAdapter(topAlbums, getContext(), mOnAlbumClickedListener);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                albumsRecyclerView.setLayoutManager(layoutManager);
                albumsRecyclerView.setHasFixedSize(true);
                albumsRecyclerView.setAdapter(mAdapter);

                mAdapter.notifyDataSetChanged();
            } else {
                mAdapter.setDataset(topAlbums);
            }
        }else{
            List<Album> topAlbumOff = new ArrayList<>();
            for (Album album : topAlbums){
                topAlbumOff.add(sqLiteController.getAlbumDetail(album.getName()));
            }
            mAdapter = new TopAlbumsAdapter(topAlbumOff, getContext(), mOnAlbumClickedListener);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            albumsRecyclerView.setLayoutManager(layoutManager);
            albumsRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

        }
    }

    //Saving data to SQLite for OFFLINE mode
    private boolean savingData(Album album){
        return sqLiteController.SAVE_ALBUM_DATA(album);
    }

    @Override
    public void showEmpty() {
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidEmpty() {
        emptyLayout.setVisibility(View.GONE);
    }

    View.OnClickListener mOnAlbumClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mListener != null) {
                int position = albumsRecyclerView.getChildAdapterPosition(view);
                mListener.onAlbumClicked(mAdapter.getItemByPosition(position));
            }
        }
    };

    public static TopAlbumsFragment newInstance() {
        return new TopAlbumsFragment();
    }

    public interface OnFragmentInteractionListener {

        void onAlbumClicked(Album album);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
