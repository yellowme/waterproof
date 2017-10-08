package mx.yellowme.waterproof.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by luisburgos on 9/28/17.
 */
interface Bindable<Model> {
    fun bind(item: Model)
}

abstract class BindableViewHolder<Model>(itemView: View?) : RecyclerView.ViewHolder(itemView), Bindable<Model>