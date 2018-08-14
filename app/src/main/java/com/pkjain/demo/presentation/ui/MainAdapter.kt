package com.pkjain.demo.presentation.ui

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pkjain.demo.R
import com.pkjain.demo.domain.models.Restaurant
import com.pkjain.demo.presentation.ui.base.BaseDiffAdapter
import com.pkjain.demo.presentation.ui.base.VIEW_TYPE_NORMAL
import kotlinx.android.synthetic.main.item_repo.view.*
import com.pkjain.demo.utils.media.LoadImageFromUrl;

class MainAdapter(var listener: ItemClickListener) : BaseDiffAdapter<Restaurant, RecyclerView.ViewHolder>() {
    interface ItemClickListener {
        fun onItemClicked(restaurents: Restaurant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_NORMAL)
            MainViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_repo, parent, false))
        else LoadingViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loading, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_NORMAL) {
            var restaurents = getItem(position)
            var viewHolder = holder as MainViewHolder

            viewHolder.titleTextView.text = restaurents?.name
            viewHolder.subTitleTextView.text = restaurents?.description
            viewHolder.durationTextView.text = "12 mins"
            if (!TextUtils.isEmpty(restaurents?.cover_img_url)) {
                LoadImageFromUrl().execute( viewHolder.imageView, restaurents?.cover_img_url );
            }
            viewHolder.itemView.setOnClickListener({ v -> listener.onItemClicked(restaurents!!) })
        }
    }



    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.list_item_image
        val titleTextView = view.list_item_title
        val subTitleTextView = view.list_item_sub_title
        val durationTextView = view.list_item_duration
    }

}