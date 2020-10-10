package com.example.minhastarefas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class TarefaAdapter(var context: Context, var lista: ArrayList<Tarefa>) : BaseAdapter() {
    override fun getItem(position: Int): Any {
        return this.lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return this.lista.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View

        if (convertView != null) {
            view = convertView
        } else {
            val inflate =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflate.inflate(R.layout.layout_listview, null)
        }
        val ivIcon = view.findViewById<ImageView>(R.id.ivListViewIcon)
        val tvDescricao = view.findViewById<TextView>(R.id.tvListViewDescricao)
        val tvPrioridade = view.findViewById<TextView>(R.id.tvListViewPrioridade)

        val tarefa = this.lista.get(position)

        tvDescricao.text = tarefa.descricao
        tvPrioridade.text = "${tarefa.prioridade}"

        when(tarefa.status){
            "aberto" -> ivIcon.setImageResource(R.drawable.aberto)
            "executando" -> ivIcon.setImageResource(R.drawable.executando)
            "concluido" -> ivIcon.setImageResource(R.drawable.concluido)
        }

        return view
    }
}
