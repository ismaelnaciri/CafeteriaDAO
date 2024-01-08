package cat.insvidreres.inf.cafeteria.afterVerification.mealFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cat.insvidreres.inf.cafeteria.afterVerification.OrderSharedViewModel
import cat.insvidreres.inf.cafeteria.databinding.FragmentMealBinding


class MealFragment : Fragment() {
    private val viewModel: MealViewModel by viewModels()
    private lateinit var binding: FragmentMealBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealBinding.inflate(inflater)
        val mealRecyclerView = binding.mealReciclerView

        mealRecyclerView.layoutManager = LinearLayoutManager(context)
        mealRecyclerView.setHasFixedSize(true)

        val sharedViewModel: OrderSharedViewModel = ViewModelProvider(requireActivity()).get(
            OrderSharedViewModel::class.java)

        viewModel.getMeals()
        viewModel.meals.observe(viewLifecycleOwner) { mealsList ->
            val mealAdapter = MealAdapter(requireContext(), mealsList, sharedViewModel)
            mealRecyclerView.adapter = mealAdapter
        }

        return binding.root
    }

}