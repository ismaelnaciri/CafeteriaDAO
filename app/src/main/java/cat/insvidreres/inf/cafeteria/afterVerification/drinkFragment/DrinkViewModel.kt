package cat.insvidreres.inf.cafeteria.afterVerification.drinkFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DrinkViewModel : ViewModel() {

    private val _drinks = MutableLiveData<List<Drink>>()
    val drinks: LiveData<List<Drink>> = _drinks

    fun getDrinks() {
        _drinks.value = DrinkProvider.loadDrinks()
    }
}