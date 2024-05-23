package com.example.lognormdistr

object InputHandler {
    const val emptyInputMsg = "Не все значения введены"
    const val nonNumericInputMsg = "Одно из значений неверно"

    fun handle(str1: String, str2: String, onSuccess: (String, String) -> Any, onError: (String) -> Any): Any {
        val result =
            if (str1.isEmpty() || str2.isEmpty()) {
                onError(emptyInputMsg)
            } else if (str1.toDoubleOrNull() == null || str2.toDoubleOrNull() == null) {
                onError(nonNumericInputMsg)
            } else {
                onSuccess(str1, str2)
            }
        return result
    }
}
