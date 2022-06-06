package com.example.mysalon.utils

import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern


class TilValidator constructor(til: TextInputLayout) {
    private val til: TextInputLayout = til
    private val value: String = til.editText?.text.toString()
    private var required: Boolean = false
    private var invalid: Boolean = false


    private fun setError(invalid: Boolean, message: String) {
        if (invalid) {
            this.invalid = true
            til.error = message
        } else {
            til.error = null
            til.isErrorEnabled = false
        }

    }

    private fun mustValidate(): Boolean {
        return (!this.required && this.value.isNotEmpty() || !invalid)
    }

    public fun required(): TilValidator {
        this.required = true
        val invalidField = this.value.isEmpty()
        this.setError(invalidField, "Campo requerido")
        return this
    }

    fun email(): TilValidator {
        if (mustValidate()) {
            val invalidField = !Patterns.EMAIL_ADDRESS.matcher(this.value).matches()
            this.setError(invalidField, "Ingrese un email válido")
        }
        return this
    }

    fun validarNombre(): TilValidator {
        if (mustValidate()) {
            val patron = Pattern.compile("^[a-zA-Z]+$")
            val invalidField = !patron.matcher(this.value)
                .matches() || this.value.length > 30 || this.value.length < 2
            this.setError(invalidField, "Ingrese un nombre válido" )
        }
        return this
    }

    fun validarTelefono(): TilValidator {
        if (mustValidate()) {
            val patron = Pattern.compile("\\A(\\+?56)?(\\s?)(0?9)(\\s?)[9876543]\\d{7}\\z")
            val invalidField = !patron.matcher(this.value)
                .matches() || this.value.length > 13
            this.setError(invalidField, "Ingrese número de teléfono válido")
        }
        return this
    }

    fun isValid(): Boolean {
        return !this.invalid
    }


}