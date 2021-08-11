package com.zhang.onehome.adapter

import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zhang.onehome.R
import com.zhang.onehome.bean.GridBean

class GridAdapter(layoutResId: Int, data: MutableList<GridBean>?) :
    BaseQuickAdapter<GridBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, item: GridBean) {
        holder.setText(com.zhang.onehome.R.id.grid_title,item.title)
        Glide.with(context).load(item.pic).circleCrop().into(holder.getView(com.zhang.onehome.R.id.grid_image))
    }
}