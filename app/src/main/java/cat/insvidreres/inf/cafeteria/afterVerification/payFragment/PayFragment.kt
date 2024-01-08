package cat.insvidreres.inf.cafeteria.afterVerification.payFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cat.insvidreres.inf.cafeteria.R
import cat.insvidreres.inf.cafeteria.afterVerification.OrderSharedViewModel
import cat.insvidreres.inf.cafeteria.afterVerification.drinkFragment.DrinkViewModel
import cat.insvidreres.inf.cafeteria.afterVerification.mealFragment.MealViewModel
import cat.insvidreres.inf.cafeteria.databinding.FragmentPayBinding

class PayFragment : Fragment() {
    private val viewModel: PayViewModel by viewModels()
    private lateinit var binding: FragmentPayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPayBinding.inflate(inflater)
        val totalTextView = binding.TotalTextView

        val sharedViewModel: OrderSharedViewModel = ViewModelProvider(requireActivity())[OrderSharedViewModel::class.java]

        val combinedRecyclerView = binding.combinedRecyclerView
        combinedRecyclerView.layoutManager = LinearLayoutManager(context)
        combinedRecyclerView.setHasFixedSize(true)

        sharedViewModel.getOrder()
        sharedViewModel.order.observe(viewLifecycleOwner) { orderList ->
            Log.d("RecyclerView", "OrderList size: ${orderList.size}")

            val itemAdapter = ItemAdapter(requireContext(), orderList, sharedViewModel)
            combinedRecyclerView.adapter = itemAdapter

            viewModel.getTotal(sharedViewModel)
            viewModel.total.observe(viewLifecycleOwner) {orderTotal ->
                totalTextView.text = getString(R.string.total, "%.2f".format(orderTotal))
            }
        }

        return binding.root
    }
}