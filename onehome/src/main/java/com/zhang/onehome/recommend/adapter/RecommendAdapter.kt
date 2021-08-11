package com.zhang.onehome.recommend.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.TransitionOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zhang.onehome.R
import com.zhang.onehome.recommend.bean.RecommendBean

class RecommendAdapter(layoutResId: Int, data: MutableList<RecommendBean.DataBean>?) :
    BaseQuickAdapter<RecommendBean.DataBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, item: RecommendBean.DataBean) {
        Glide.with(context).load(item.pictUrl).into(holder.getView(R.id.recommend_image))
        holder.setText(R.id.recommend_title,item.shortTitle)
        holder.setText(R.id.recommend_price,item.reservePrice)
    }
}