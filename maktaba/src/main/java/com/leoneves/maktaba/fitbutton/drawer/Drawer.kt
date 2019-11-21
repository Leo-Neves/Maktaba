package com.leoneves.maktaba.fitbutton.drawer

internal abstract class Drawer<V, T> constructor(private val view: V, private val button: T) {

    companion object {
        const val MAX_ALPHA = 255
        const val ALPHA_PERCENTS = 75
    }

    abstract fun draw()

    abstract fun isReady() : Boolean

    open fun getAlpha() : Float = MAX_ALPHA * ALPHA_PERCENTS / 100f

    abstract fun updateLayout()

}