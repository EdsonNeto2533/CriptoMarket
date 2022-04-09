package com.mctable.criptomarket.dashboard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.Description
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
            setupLineChart(coinModel.variation)
            formatToCurrency(coinModel.price)
            setPriceVariation(coinModel.priceVariation)
        }

        private fun setupLineChart(values: List<String>) {
            val entrys = values.mapIndexed { index, value ->
                Entry(index.toFloat(), value.toFloat())
            }
            val lineDataset = LineDataSet(entrys.subList(0 , 7), "")
            lineDataset.setDrawValues(false)
            lineDataset.setDrawCircles(false)
            lineDataset.setDrawCircleHole(true)
            lineDataset.color = R.color.black

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

        private fun setPriceVariation(priceVariation: String) {
            val priceVariationFormated = priceVariation.formatPriceVariation()
            if (priceVariationFormated.startsWith("-")) {
                binding.tvCoinProfit.setTextColor(
                    itemView.resources.getColor(
                        R.color.red_profit,
                        null
                    )
                )
            }
            binding.tvCoinProfit.text = priceVariationFormated
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