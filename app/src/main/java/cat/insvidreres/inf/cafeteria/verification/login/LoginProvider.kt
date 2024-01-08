package cat.insvidreres.inf.cafeteria.verification.login

class LoginProvider {
    companion object {
        fun loadLogins(): MutableList<LoginModel> {
            return mutableListOf<LoginModel>(
                LoginModel(
                    "isma@gmail.com",
                    "isma1234"
                ),
                LoginModel(
                    "pepe@gmail.com",
                    "pepe1234"
                ),
                LoginModel(
                    "jose@gmail.com",
                    "jose1234"
                ),
                LoginModel(
                    "adria@gmail.com",
                    "adria1234"
                ),
                LoginModel(
                    "pau@gmail.com",
                    "pau1234"
                ),
                LoginModel(
                    "aram@gmail.com",
                    "aram1234"
                ),
                LoginModel(
                    "dani@gmail.com",
                    "dani1234"
                ),
                LoginModel(
                    "alex@gmail.com",
                    "alex1234"
                ),
                LoginModel(
                    "admin",
                    "admin"
                )
            )
        }

        fun checkIfEntryExists(login: LoginModel): Boolean {
            val currentEntries = loadLogins()
            for (entry in currentEntries) {
                if (entry.email == login.email)
                    return true
            }

            return false
        }
    }
}