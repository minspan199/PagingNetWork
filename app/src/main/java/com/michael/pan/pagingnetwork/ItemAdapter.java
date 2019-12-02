package com.michael.pan.pagingnetwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItemAdapter extends PagedListAdapter<Item, ItemAdapter.ItemViewHolder> {

	private static DiffUtil.ItemCallback<Item> DIFF_CALLBACK =
		new DiffUtil.ItemCallback<Item>() {
			@Override
			public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
				return oldItem.answer_id == newItem.answer_id;
			}

			@Override
			public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
				return oldItem.equals(newItem);
			}
		};

	public ItemAdapter() {
		super(DIFF_CALLBACK);
	}

	@NonNull
	@Override
	public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
		return new ItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
		Item item = getItem(position);
		if (item != null){
			Glide.with(holder.imageView.getContext())
				.load(item.owner.profile_image)
				.into(holder.imageView);
			holder.textView.setText(item.owner.display_name);
		} else {
			holder.textView.setText("Item is null at position: "+position);
		}
	}


	public class ItemViewHolder extends RecyclerView.ViewHolder {

		private ImageView imageView;
		private TextView textView;
		public ItemViewHolder(@NonNull View itemView) {
			super(itemView);
			textView = itemView.findViewById(R.id.name);
			imageView = itemView.findViewById(R.id.imageView);
		}
	}
}
