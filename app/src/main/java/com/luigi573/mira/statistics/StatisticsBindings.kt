package com.luigi573.mira.statistics

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("app:refreshing")
fun setItems(refreshLayout: SwipeRefreshLayout, isRefreshing : Boolean) {
    refreshLayout.isRefreshing = isRefreshing
}