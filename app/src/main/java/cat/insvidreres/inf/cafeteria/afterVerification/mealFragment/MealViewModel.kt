package cat.insvidreres.inf.cafeteria.afterVerification.mealFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MealViewModel : ViewModel() {

    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> = _meals

    fun getMeals() {
        _meals.value = MealProvider.loadMeals()
    }
}