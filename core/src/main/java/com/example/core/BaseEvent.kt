package com.example.core

import java.util.Observable

open class BaseEvent : Observable() {

    fun notifyChanged() {
        setChanged()
        notifyObservers()
    }
}
