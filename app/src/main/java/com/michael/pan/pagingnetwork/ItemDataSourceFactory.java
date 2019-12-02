package com.michael.pan.pagingnetwork;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ItemDataSourceFactory extends DataSource.Factory {

	private MutableLiveData<PageKeyedDataSource<Integer, Item>> itemLiveDataSource = new MutableLiveData<>();
	@NonNull
	@Override
	public DataSource create() {
		ItemDataSource itemDataSource = new ItemDataSource();
		itemLiveDataSource.postValue(itemDataSource);
		return itemDataSource;
	}

	public MutableLiveData<PageKeyedDataSource<Integer, Item>> getItemLiveDataSource(){
		return itemLiveDataSource;
	}
}
