/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.observabledata.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.observabledata.R
import com.example.observabledata.databinding.ActivityMainLivedataBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_livedata)

    // Set up the viewModel
    val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    viewModel.showRegistrationSuccessDialog.observe(this, { showRegistrationSuccessDialog ->
      if (showRegistrationSuccessDialog) {
        showBottomSheetDialog()
      }
    })

    // Set up data binding
    val binding = DataBindingUtil.setContentView<ActivityMainLivedataBinding>(
      this,
      R.layout.activity_main_livedata
    ) // 1
    binding.lifecycleOwner = this // 2
    binding.viewmodel = viewModel // 3

    /**
      Demo lifecycleOwner
     **/
//    lifecycle.addObserver(viewModel)
  }

  /** Displays a [BottomSheetDialog] after a successful registration */
  private fun showBottomSheetDialog() {
    val dialog = BottomSheetDialog(this)
    dialog.setContentView(R.layout.bottom_sheet_dialog_registration_success)
    dialog.show()
  }
}
