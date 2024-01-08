package cat.insvidreres.inf.cafeteria.afterVerification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cat.insvidreres.inf.cafeteria.afterVerification.drinkFragment.Drink
import cat.insvidreres.inf.cafeteria.afterVerification.mealFragment.Meal
import cat.insvidreres.inf.cafeteria.afterVerification.payFragment.Item
import cat.insvidreres.inf.cafeteria.afterVerification.payFragment.PayViewModel
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.ceil

class OrderSharedViewModel : ViewModel() {
    var customerOrder = mutableListOf<Item>()
    var total: Double = 0.0

    private val _order = MutableLiveData<MutableList<Item>>()
    val order: LiveData<MutableList<Item>> = _order


    fun getOrder() {
        _order.value = customerOrder
    }

    fun addElementToOrder(element: Item) {
        customerOrder.add(element)
    }

    fun calculateTotal() {
        total = 0.0

        for (element: Item in customerOrder) {
            total += element.price
        }

//        total = total.format(2).toDouble()
    }

//    fun Double.format(digits: Int) = "%.${digits}f".format(this)

}