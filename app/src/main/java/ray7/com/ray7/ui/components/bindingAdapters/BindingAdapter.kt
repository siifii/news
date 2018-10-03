package ray7.com.ray7.ui.components.bindingAdapters

import android.widget.ImageView

import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }
}
