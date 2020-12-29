package com.test.androidtest.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.androidtest.R;
import com.test.androidtest.adapter.QuestionSRecyclerAdapter;
import com.test.androidtest.base.BaseFragment;
import com.test.androidtest.model.questionResponse.DataItem;
import com.test.androidtest.model.questionResponse.ResponseFromServerForQuestions;
import com.test.androidtest.newtworking.ApiClient;
import com.test.androidtest.newtworking.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestIonFragment extends BaseFragment {

    RecyclerView mRecycler_view_blogs;
    List<DataItem> mdataQuestionInitial = new ArrayList<>();
    QuestionSRecyclerAdapter mBlogRecyclerAdapter;

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
        mBlogRecyclerAdapter = new QuestionSRecyclerAdapter(mdataQuestionInitial);
        mRecycler_view_blogs.setAdapter(mBlogRecyclerAdapter);




        if(haveNetworkConnection()){

            getQuestins();

        }else {

            showSnackBar(getString(R.string.no_network));
        }

        return view;
    }
    // get blog
    private void getQuestins() {
        showProgressDialog();
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<ResponseFromServerForQuestions> call1 = service.getQuestions();
        call1.enqueue(new Callback<ResponseFromServerForQuestions>() {
            @Override
            public void onResponse(Call<ResponseFromServerForQuestions> call, Response<ResponseFromServerForQuestions> response) {
                hideProgressDialog();
                ResponseFromServerForQuestions responseBlog= response.body();
                if (responseBlog != null) {

                    mdataQuestionInitial.clear();
                    List<DataItem> data = responseBlog.getData();
                    mdataQuestionInitial.addAll(data);

                    mBlogRecyclerAdapter.notifyDataSetChanged();





                }
                else {
                    showSnackBar(getString(R.string.api_error));
                }

            }

            @Override
            public void onFailure(Call<ResponseFromServerForQuestions> call, Throwable t) {
                hideProgressDialog();
                call.cancel();
                showSnackBar(getString(R.string.api_error));

            }
        });
    }

}