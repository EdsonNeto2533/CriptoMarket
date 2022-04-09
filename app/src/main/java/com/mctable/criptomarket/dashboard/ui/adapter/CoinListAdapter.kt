package com.mctable.criptomarket.dashboard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.mctable.criptomarket.R
import com.mctable.criptomarket.commons.utils.extensions.formatPriceVariation
import com.mctable.criptomarket.dashboard.domain.model.CoinModel
import com.mctable.criptomarket.databinding.ItemCardDashboardCoinBinding

import java.text.NumberFormat
import java.util.*

class CoinListAdapter :
    ListAdapter<CoinModel, CoinListAdapter.CoinListViewHolder>(CoinListDiffUtils()) {

    companion object {
        private const val PNG = "png"
        private const val SVG = "svg"
    }

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
            setImg(coinModel.icon)
            binding.ivCoinSymbol
            binding.tvCoinLetters.text = coinModel.symbol
            binding.tvCoinName.text = coinModel.name
            setupLineChart(coinModel.variation, getVariationColor(coinModel.priceVariation))
            formatToCurrency(coinModel.price)
            setPriceVariation(coinModel.priceVariation, getVariationColor(coinModel.priceVariation))
        }

        private fun setImg(url: String) {
            when (url.substring(url.length - 3)) {
                PNG -> {
                    loadPngCoinImg(url)
                }
                SVG -> loadSvgCoinImg(url)
            }
        }

        private fun setupLineChart(values: List<String>, @ColorRes lineColor: Int) {
            val entrys = values.mapIndexed { index, value ->
                Entry(index.toFloat(), value.toFloat())
            }
            val lineDataset = LineDataSet(entrys, "")
            lineDataset.setDrawValues(false)
            lineDataset.setDrawCircles(false)
            lineDataset.setDrawCircleHole(true)
            lineDataset.color = itemView.resources.getColor(lineColor, null)

            val dataSetList = mutableListOf<ILineDataSet>()
            dataSetList.add(lineDataset)
            val data = LineData(dataSetList)


            binding.ivCoinGraph.data = data
            binding.ivCoinGraph.legend.isEnabled = false
            binding.ivCoinGraph.axisLeft.isEnabled = false
            binding.ivCoinGraph.axisRight.isEnabled = false
            binding.ivCoinGraph.xAxis.isEnabled = false
            binding.ivCoinGraph.axisLeft.setDrawLabels(false)
            binding.ivCoinGraph.axisRight.setDrawLabels(false)
            binding.ivCoinGraph.xAxis.setDrawLabels(false)
            binding.ivCoinGraph.axisLeft.setDrawGridLines(false)
            binding.ivCoinGraph.axisRight.setDrawGridLines(false)
            binding.ivCoinGraph.xAxis.setDrawGridLines(false)
            binding.ivCoinGraph.setDrawBorders(false)
            binding.ivCoinGraph.setDrawGridBackground(false)
            binding.ivCoinGraph.description.isEnabled = false
            binding.ivCoinGraph.isDragEnabled = false
            binding.ivCoinGraph.setScaleEnabled(false)
            binding.ivCoinGraph.isAutoScaleMinMaxEnabled = true


            binding.ivCoinGraph.invalidate()
        }

        private fun formatToCurrency(value: String) {
            val numberFormat = NumberFormat.getCurrencyInstance(Locale.US)
            binding.tvCoinValue.text = numberFormat.format(value.toDouble())
        }

        private fun loadSvgCoinImg(url: String) {
            val requestBuilder = GlideToVectorYou.init().with(itemView.context).requestBuilder
            requestBuilder.load(url).into(binding.ivCoinSymbol)
        }

        private fun loadPngCoinImg(url: String) {
            Glide.with(itemView.context).load(url).into(binding.ivCoinSymbol)
        }

        private fun setPriceVariation(priceVariation: String, @ColorRes color: Int) {
            binding.tvCoinProfit.setTextColor(
                itemView.resources.getColor(
                    color,
                    null
                )
            )
            binding.tvCoinProfit.text = priceVariation.formatPriceVariation()
        }

        private fun getVariationColor(priceVariation: String): Int {
            val priceVariationFormated = priceVariation.formatPriceVariation()
            return if (priceVariationFormated.startsWith("-"))
                R.color.red_profit
            else
                R.color.green_profit
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