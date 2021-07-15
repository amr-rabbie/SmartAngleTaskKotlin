package srandroiddeveloper.amrrabbie.smartangletaskk.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import srandroiddeveloper.amrrabbie.smartangletaskk.databinding.TaskItemBinding
import srandroiddeveloper.amrrabbie.smartangletaskk.model.DataItem

//class Adapter(var context: Context,var list: List<DataItem>)  : RecyclerView.Adapter<Adapter.MyViewHolder>() {
class Adapter(var context: Context) : PagingDataAdapter<DataItem, Adapter.MyViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        return MyViewHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {
        var item: DataItem? =getItem(position)
        holder.binding.apply {
            if (item != null) {
                brand.text=item.brand
                isused.text= item.isUsed.toString()
                madedate.text=item.constractionYear

                img.load(item.imageUrl){
                    crossfade(true)
                    crossfade(1000)
                }
            }

        }

        holder.itemView.setOnClickListener {mview->
            if (item != null) {
                Toast.makeText(context,"Car brand: ${item.brand}",Toast.LENGTH_LONG).show()
            }
        }


    }



    inner class  MyViewHolder(val binding: TaskItemBinding):
            RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}