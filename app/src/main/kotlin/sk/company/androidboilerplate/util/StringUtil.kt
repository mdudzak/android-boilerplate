package sk.company.androidboilerplate.util


object StringUtil {

    fun isNullOrEmpty(str: String?): Boolean {
        if (str == null) {
            return true
        } else {
            if (str.isEmpty()) return true
        }

        return false
    }

}
