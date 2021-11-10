package com.example.advweek4.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.example.advweek4.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.student_list_item.view.*

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
            .load(url)
            .resize(400, 400)
            .centerCrop()
            .error(R.drawable.ic_baseline_error_24)
            .into(this,  object: Callback {
                    override fun onSuccess() {
                            progressBar.visibility = View.GONE
                    }
                    override fun onError(e: Exception?) {
                    }
            })
}
@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoURL(view: ImageView, url:String, pb:ProgressBar){
        view.loadImage(url, pb)
}
