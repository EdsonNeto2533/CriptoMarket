package com.mctable.criptomarket.dashboard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mctable.criptomarket.R
import com.mctable.criptomarket.dashboard.domain.model.CoinModel
import com.mctable.criptomarket.databinding.ItemCardDashboardCoinBinding

class CoinListAdapter :
    ListAdapter<CoinModel, CoinListAdapter.CoinListViewHolder>(CoinListDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_dashboard_coin, parent, false)
        return CoinListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        getItem(position).apply {
            holder.bind(this)
        }
    }

    inner class CoinListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCardDashboardCoinBinding.bind(itemView)

        fun bind(coinModel: CoinModel) {
            Glide.with(binding.root).load(coinModel.icon).into(binding.ivCoinSymbol)
            binding.ivCoinSymbol
            binding.tvCoinLetters.text = coinModel.symbol
            binding.tvCoinName.text = coinModel.name
            binding.tvCoinProfit.text = coinModel.priceVariation
            binding.tvCoinValue.text = coinModel.price
        }
    }

}


class CoinListDiffUtils : DiffUtil.ItemCallback<CoinModel>() {

    override fun areItemsTheSame(oldItem: CoinModel, newItem: CoinModel): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItem: CoinModel, newItem: CoinModel): Boolean {
        return newItem == oldItem
    }

}