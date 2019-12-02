package com.michael.pan.pagingnetwork;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class ItemViewModel extends ViewModel {

	LiveData<PagedList<Item>> itemPagedList;
	LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;

	public ItemViewModel() {

		ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
		liveDataSource = itemDataSourceFactory.getItemLiveDataSource();
		PagedList.Config config = (new PagedList.Config.Builder())
			.setEnablePlaceholders(false)
			.setPageSize(ItemDataSource.PAGE_SIZE)
			.build();

		itemPagedList = new LivePagedListBuilder(itemDataSourceFactory, config).build();

	}
}
