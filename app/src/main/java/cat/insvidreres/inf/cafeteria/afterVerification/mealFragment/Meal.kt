package cat.insvidreres.inf.cafeteria.afterVerification.mealFragment

import cat.insvidreres.inf.cafeteria.afterVerification.utils.ItemWithPrice

data class Meal(val name: String, override val price: Double, val description: String, val photo: String) : ItemWithPrice