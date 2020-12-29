package com.test.androidtest.model.questionResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseFromServerForQuestions{

	@SerializedName("total")
	private int total;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("page")
	private int page;

	public int getTotal(){
		return total;
	}

	public List<DataItem> getData(){
		return data;
	}

	public int getPage(){
		return page;
	}
}