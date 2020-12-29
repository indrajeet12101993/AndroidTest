package com.test.androidtest.model.questionResponse;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("expertName")
	private String expertName;

	@SerializedName("question")
	private String question="";

	@SerializedName("answer")
	private String answer="";

	@SerializedName("expertAvatar")
	private String expertAvatar="";

	@SerializedName("id")
	private int id;

	@SerializedName("expertDesignation")
	private String expertDesignation;

	public String getExpertName(){
		return expertName;
	}

	public String getQuestion(){
		return question;
	}

	public String getAnswer(){
		return answer;
	}

	public String getExpertAvatar(){
		return expertAvatar;
	}

	public int getId(){
		return id;
	}

	public String getExpertDesignation(){
		return expertDesignation;
	}
}