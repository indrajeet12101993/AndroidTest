package com.test.androidtest.newtworking;



import com.test.androidtest.model.blogResponse.ResponseFromServerBlogResponse;
import com.test.androidtest.model.questionResponse.ResponseFromServerForQuestions;


import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("blogs/1")
    Call<ResponseFromServerBlogResponse> getBlogs();

    @GET("questions/1")
    Call<ResponseFromServerForQuestions> getQuestions();


}

