package com.michael.pan.pagingnetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private TextView textView;
	private RecyclerView recyclerView;
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = findViewById(R.id.textView);

		recyclerView = findViewById(R.id.recyclerView);
		final ItemAdapter adapter = new ItemAdapter();
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setHasFixedSize(true);


		ItemViewModel viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

		viewModel.itemPagedList.observe(this, new Observer<PagedList<Item>>() {
			@Override
			public void onChanged(PagedList<Item> items) {
				adapter.submitList(items);
			}
		});

		recyclerView.setAdapter(adapter);
	}
}
