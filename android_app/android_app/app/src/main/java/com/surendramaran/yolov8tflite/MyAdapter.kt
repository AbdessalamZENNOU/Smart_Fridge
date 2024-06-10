package com.surendramaran.yolov8tflite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var items: List<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = items[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(newList: List<Product>) {
        items = newList
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.textView)
        private val imageView: ImageView = view.findViewById(R.id.imageView)
        private val quantityView: TextView = view.findViewById(R.id.quantityView)

        fun bind(product: Product) {
            textView.text = product.name
            imageView.setImageResource(product.imageResId)
            quantityView.text = "Quantity: ${product.quantity}"
        }
    }
}
