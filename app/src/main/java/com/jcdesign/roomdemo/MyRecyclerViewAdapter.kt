package com.jcdesign.roomdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jcdesign.roomdemo.databinding.ListItemBinding
import com.jcdesign.roomdemo.db.Subscriber
import com.jcdesign.roomdemo.generated.callback.OnClickListener

class MyRecyclerViewAdapter(private val clickListener: (Subscriber)->Unit) : RecyclerView.Adapter<MyViewHolder>() {

    private val subscribersList = ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribersList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    fun setList(subscribers: List<Subscriber>) {
        subscribersList.clear()
        subscribersList.addAll(subscribers)
    }

}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(subscriber: Subscriber, clickListener: (Subscriber)->Unit){
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)}
    }

}