/*
package com.example.estudos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


// DAPTACAP ENTRE O DATA CLASS E O ITEM_LIST LAYOUT
class ContactListAdapter: ListAdapter<Contact, ContactListAdapter.ContactViewHolder>(
    ContactDiffUtils()
) {

    //CRIAR UM VIEWHOLDER
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle, parent, false)
        return ContactViewHolder(view)
    }


    //BIND - ATRELAR O DADO COM A UI/VIEWS
    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
        val contact = getItem(position)
        holder.bind(contact)

    }


    //VIEW HOLDER - VIEW QUE SEGURA OS DADOS
    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val tvName = view.findViewById<TextView>(R.id.rvName)
        private val tvPhone = view.findViewById<TextView>(R.id.tv_contact)
        private val image = view.findViewById< ImageView>(R.id.rvImage)

        //  para criar o bind da view holder precisamos criar uma função aqui
        fun bind(contact:Contact){
            tvName.text = contact.nome
            tvPhone.text = contact.telefone
            image.setImageResource(contact.iconeImagem)

        }
    }



    //COMPARA A DIFERENÇA QUANDO NOSSA LISTA É ATUALIZADA

    class ContactDiffUtils: DiffUtil.ItemCallback<Contact>(){
        override fun areItemsTheSame(
            oldItem: Contact,
            newItem: Contact
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Contact,
            newItem: Contact
        ): Boolean {
            return oldItem.nome == newItem.nome
        }
    }
}*/
