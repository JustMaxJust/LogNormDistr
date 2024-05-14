package com.example.lognormdistr

object InputHandler {
    const val emptyInputMsg = "Не все значения введены"
    const val nonNumericInputMsg = "Одно из значений неверно"

    fun handle(str1: String, str2: String, onSuccess: (String, String) -> Any, onError: (String) -> Any): Any {
        println("str1: \"$str1\"\nstr2: \"$str2\"")
        if (str1.isEmpty() || str2.isEmpty()) {
            return onError(emptyInputMsg)
        }
        if (str1.toDoubleOrNull() == null || str2.toDoubleOrNull() == null) {
            return onError(nonNumericInputMsg)
        }
        return onSuccess(str1, str2)
    }
}