package com.mctable.criptomarket.dashboard.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.mctable.criptomarket.R
import com.mctable.criptomarket.commons.utils.extensions.formatPriceVariation
import com.mctable.criptomarket.commons.utils.extensions.formatToCurrencyValue
import com.mctable.criptomarket.dashboard.domain.model.CoinModel
import com.mctable.criptomarket.databinding.ItemCardDashboardCoinBinding
import java.text.NumberFormat
import java.util.*

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
            loadSvgCoinImg(coinModel.icon)
            binding.ivCoinSymbol
            binding.tvCoinLetters.text = coinModel.symbol
            binding.tvCoinName.text = coinModel.name
            formatToCurrency(coinModel.price)
            setPriceVariation(coinModel.priceVariation)
        }

        private fun formatToCurrency(value: String) {
            val numberFormat = NumberFormat.getCurrencyInstance(Locale.US)
            binding.tvCoinValue.text = numberFormat.format(value.toDouble())
        }

        private fun loadSvgCoinImg(url: String) {
            val requestBuilder = GlideToVectorYou.init().with(itemView.context).requestBuilder
            requestBuilder.load(url).into(binding.ivCoinSymbol)
        }

        private fun setPriceVariation(priceVariation: String) {
            if (priceVariation.startsWith("-")) {
                binding.tvCoinProfit.setTextColor(
                    itemView.resources.getColor(
                        R.color.red_profit,
                        null
                    )
                )
            }
            binding.tvCoinProfit.text = priceVariation.formatPriceVariation()
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