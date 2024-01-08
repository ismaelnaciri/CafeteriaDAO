package cat.insvidreres.inf.cafeteria.afterVerification.mealFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cat.insvidreres.inf.cafeteria.afterVerification.OrderSharedViewModel
import cat.insvidreres.inf.cafeteria.afterVerification.payFragment.Item
import cat.insvidreres.inf.cafeteria.databinding.ItemMealBinding
import com.bumptech.glide.Glide

class MealAdapter(val context: Context, val dataset: List<Meal>, private val sharedViewModel: OrderSharedViewModel) :
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    inner class MealViewHolder(private val binding: ItemMealBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            binding.textViewMealName.text = meal.name
            val priceWithCurrency = meal.price.toString() + "€"
            binding.textViewMealPrice.text = priceWithCurrency
            binding.textViewMealDescription.text = meal.description
            Glide.with(binding.imageViewMeal.context).load(meal.photo).into(binding.imageViewMeal)
            binding.addMealButton.setOnClickListener{
                sharedViewModel.addElementToOrder(Item(meal.name, meal.price, meal.description, meal.photo))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealAdapter.MealViewHolder {
        val itemBinding = ItemMealBinding.inflate(LayoutInflater.from(context), parent, false)
        return MealViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MealAdapter.MealViewHolder, position: Int) {
        val meal = dataset[position]
        holder.bind(meal)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}