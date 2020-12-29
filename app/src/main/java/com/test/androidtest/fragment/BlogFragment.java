package com.test.androidtest.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.androidtest.R;
import com.test.androidtest.adapter.BlogRecyclerAdapter;
import com.test.androidtest.base.BaseFragment;
import com.test.androidtest.model.blogResponse.DataItem;
import com.test.androidtest.model.blogResponse.ResponseFromServerBlogResponse;
import com.test.androidtest.newtworking.ApiClient;
import com.test.androidtest.newtworking.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BlogFragment extends BaseFragment {

    RecyclerView mRecycler_view_blogs;
    List<DataItem> mdataBlogInitial= new ArrayList<>();
    BlogRecyclerAdapter mBlogRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_blog, container, false);



        // intilazie view

        mRecycler_view_blogs = view.findViewById(R.id.recycler_view_blogs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecycler_view_blogs.setLayoutManager(linearLayoutManager);
        mRecycler_view_blogs.setHasFixedSize(true);
        mBlogRecyclerAdapter = new BlogRecyclerAdapter(mdataBlogInitial);
        mRecycler_view_blogs.setAdapter(mBlogRecyclerAdapter);




        if(haveNetworkConnection()){

            getBlogs();

        }else {

            showSnackBar(getString(R.string.no_network));
        }

        return  view;
    }




    // get blog
    private void getBlogs() {
        showProgressDialog();
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<ResponseFromServerBlogResponse> call1 = service.getBlogs();
        call1.enqueue(new Callback<ResponseFromServerBlogResponse>() {
            @Override
            public void onResponse(Call<ResponseFromServerBlogResponse> call, Response<ResponseFromServerBlogResponse> response) {
              hideProgressDialog();
                ResponseFromServerBlogResponse responseBlog= response.body();
                if (responseBlog != null) {

                    mdataBlogInitial.clear();
                    List<DataItem> data = responseBlog.getData();
                    mdataBlogInitial.addAll(data);
                    mBlogRecyclerAdapter.notifyDataSetChanged();





                }
                else {
                    showSnackBar(getString(R.string.api_error));
                }

            }

            @Override
            public void onFailure(Call<ResponseFromServerBlogResponse> call, Throwable t) {
                hideProgressDialog();
                call.cancel();
                showSnackBar(getString(R.string.api_error));

            }
        });
    }


}