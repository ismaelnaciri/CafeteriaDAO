package cat.insvidreres.inf.cafeteria.afterVerification.drinkFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import cat.insvidreres.inf.cafeteria.afterVerification.OrderSharedViewModel
import cat.insvidreres.inf.cafeteria.afterVerification.payFragment.Item
import cat.insvidreres.inf.cafeteria.databinding.ItemDrinkBinding
import com.bumptech.glide.Glide

class DrinkAdapter(val context: Context, val dataset: List<Drink>, private val sharedViewModel: OrderSharedViewModel) :
    RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    inner class DrinkViewHolder(private val binding: ItemDrinkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(drink: Drink) {
            binding.textViewDrinkName.text = drink.name
            val priceWithCurrency = drink.price.toString() + "€"
            binding.textViewDrinkPrice.text = priceWithCurrency
            binding.textViewDrinkDescription.text = drink.description
            Glide.with(binding.imageViewDrink).load(drink.photo).into(binding.imageViewDrink)
            binding.addDrinkButton.setOnClickListener {
                sharedViewModel.addElementToOrder(Item(drink.name, drink.price, drink.description, drink.photo))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkAdapter.DrinkViewHolder {
        val itemBinding = ItemDrinkBinding.inflate(LayoutInflater.from(context), parent, false)
        return DrinkViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DrinkAdapter.DrinkViewHolder, position: Int) {
        val drink = dataset[position]
        holder.bind(drink)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}