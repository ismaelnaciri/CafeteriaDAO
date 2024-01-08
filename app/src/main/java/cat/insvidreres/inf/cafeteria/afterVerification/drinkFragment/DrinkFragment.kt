package cat.insvidreres.inf.cafeteria.afterVerification.drinkFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cat.insvidreres.inf.cafeteria.afterVerification.OrderSharedViewModel
import cat.insvidreres.inf.cafeteria.databinding.FragmentDrinkBinding

class DrinkFragment : Fragment() {

    private val viewModel: DrinkViewModel by viewModels()
    private lateinit var binding: FragmentDrinkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDrinkBinding.inflate(inflater)
        val drinkRecyclerView = binding.drinkReciclerView

        drinkRecyclerView.layoutManager = LinearLayoutManager(context)
        drinkRecyclerView.setHasFixedSize(true)

        val sharedViewModel: OrderSharedViewModel = ViewModelProvider(requireActivity()).get(
            OrderSharedViewModel::class.java)

        viewModel.getDrinks()
        viewModel.drinks.observe(viewLifecycleOwner) { drinksList ->
            val drinkAdapter = DrinkAdapter(requireContext(), drinksList, sharedViewModel)
            drinkRecyclerView.adapter = drinkAdapter
        }

        return binding.root
    }

}