package com.example.notification.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VIEW_BINDING: ViewBinding>(
    private val inflate: InflateFragment<VIEW_BINDING>
) : Fragment() {

    private var _binding: VIEW_BINDING? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T