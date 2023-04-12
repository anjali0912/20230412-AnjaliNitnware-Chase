package com.example.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel<D : BaseData>(
    application: Application,
    protected val data: D
) : AndroidViewModel(application) {
}