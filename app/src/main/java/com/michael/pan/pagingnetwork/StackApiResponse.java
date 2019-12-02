package com.michael.pan.pagingnetwork;

import android.content.ClipData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class Owner{

	public int	reputation;
	public long ser_id;
	public String user_type;
	public int accept_rate;
	public String profile_image;
	public String display_name;
	public String link;

}

class Item{

	public Owner owner;

	public boolean is_accepted;
	public int score;
	public long last_activity_date;
	public long last_edit_date;
	public long creation_date;
	public long answer_id;
	public long question_id;

}

public class StackApiResponse {

	@SerializedName("items")
	public List<Item> items;

	@SerializedName("has_more")
	public boolean hasMore;

	@SerializedName("backoff")
	public int backoff;

	@SerializedName("quota_max")
	public int quotaMax;

	@SerializedName("quota_remaining")
	public int quotaRemaining;


}
