package com.example.viewmodel.Util

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    var isCreated = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCreated = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isCreated = false
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
