package cat.insvidreres.inf.cafeteria.afterVerification.drinkFragment

import cat.insvidreres.inf.cafeteria.afterVerification.utils.ItemWithPrice

data class Drink(val name: String, override val price: Double, val description: String, val photo: String): ItemWithPrice
