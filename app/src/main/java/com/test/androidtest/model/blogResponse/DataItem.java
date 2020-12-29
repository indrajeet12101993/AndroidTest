package com.test.androidtest.model.blogResponse;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("image")
	private String image="";

	@SerializedName("userAvatar")
	private String userAvatar;

	@SerializedName("topic")
	private String topic="";

	@SerializedName("id")
	private int id;

	@SerializedName("ageGroup")
	private String ageGroup;

	@SerializedName("userName")
	private String userName="";

	@SerializedName("title")
	private String title="";

	public String getImage(){
		return image;
	}

	public String getUserAvatar(){
		return userAvatar;
	}

	public String getTopic(){
		return topic;
	}

	public int getId(){
		return id;
	}

	public String getAgeGroup(){
		return ageGroup;
	}

	public String getUserName(){
		return userName;
	}

	public String getTitle(){
		return title;
	}
}