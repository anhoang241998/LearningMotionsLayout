package com.annguyenhoang.motionslayoutlearning.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.annguyenhoang.motionslayoutlearning.databinding.ItemMotionsLayoutBinding
import com.annguyenhoang.motionslayoutlearning.model.FoodModel
import com.bumptech.glide.Glide


class FoodAdapter : ListAdapter<FoodModel, FoodAdapter.FoodViewHolder>(FOOD_COMPARATOR) {

    companion object {
        private val FOOD_COMPARATOR = object : DiffUtil.ItemCallback<FoodModel>() {
            override fun areContentsTheSame(oldItem: FoodModel, newItem: FoodModel) =
                oldItem.title == newItem.title

            override fun areItemsTheSame(oldItem: FoodModel, newItem: FoodModel) =
                oldItem == newItem
        }
    }

    override fun submitList(list: MutableList<FoodModel>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    inner class FoodViewHolder(private val binding: ItemMotionsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FoodModel) {
            binding.apply {
                tvTitle.text = item.title
                tvDescription.text = item.description
                tvCalories.text = item.calories
                tvRate.text = item.rate

                Glide.with(binding.root.context)
                    .load(item.imgId)
                    .into(binding.ivFood)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            ItemMotionsLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.bind(item)
    }

}