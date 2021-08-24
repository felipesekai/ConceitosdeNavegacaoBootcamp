package com.sekai.conceitosdenavegao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cardview_contatos.view.*

class ContactAdapter(
    var clickContato : ContactItemClickListener
): RecyclerView.Adapter<ContactViewHolder>() {

   private val list : MutableList<Contact> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder =
       ContactViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_contatos, parent, false))

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindContato(list[position])
        holder.cardView.setOnClickListener {
           clickContato.contactItemClickListener(list[position])
        }


    }

    override fun getItemCount(): Int = list.size

    fun updateList(list : List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()

    }




}
class ContactViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    val nome  = itemView.item_contact_nome
    val fone  = itemView.item_contact_fone
    val img  = itemView.imageView_img
    val cardView = itemView.cardview_item_contato

    fun bindContato(contact: Contact){
        nome.text = contact.nome
        fone.text = contact.phone

    }
}
