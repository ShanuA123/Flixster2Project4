package com.example.flixster2project4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

const val PERSON_EXTRA = "PERSON_EXTRA"
private const val TAG = "TopPeopleAdapter"

class TopPeopleAdapter(private val context: Context, private val peopleTop: List<TopPeople>) :
    RecyclerView.Adapter<TopPeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_top_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val people = peopleTop[position]
        holder.bind(people)
    }
    override fun getItemCount() = peopleTop.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val personImage = itemView.findViewById<ImageView>(R.id.iv_PersonImage)
        private val personName = itemView.findViewById<TextView>(R.id.tv_PersonName)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(person: TopPeople) {
            personName.text = person.personName
            Glide.with(context)
                .load(person.imageUrl)
                .transform(RoundedCorners(100))
                .into(personImage)
        }

        override fun onClick(v: View?) {
            val person = peopleTop[absoluteAdapterPosition]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PERSON_EXTRA,person)
            context.startActivity(intent)
        }
    }


}

