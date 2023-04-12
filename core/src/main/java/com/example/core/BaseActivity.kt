package com.example.core

import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass

abstract class BaseActivity<VM : BaseViewModel<D>, D : BaseData>(
    viewModel: KClass<VM>,
) : AppCompatActivity() {
    protected abstract val viewModel: VM
}