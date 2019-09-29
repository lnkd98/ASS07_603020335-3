package com.example.asslab7dialogrv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.std_item_layout.view.*

class EmployeeAdapter (val item: List<Employee>, val context: Context): RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate((R.layout.std_item_layout), parent,false)
        return ViewHolder(view_item)

    }

    override fun getItemCount(): Int {
        return item.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName?.text = "Name : "+item[position] .name
        holder.tvGender?.text = "Gender : "+item[position] .gender
        holder.tvEmail?.text = "Email : "+item[position] .email
        holder.tvSalary?.text = "Salary : "+item[position] .salary.toString()
    }
}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val tvName : TextView = view.tv_name
    val tvGender : TextView = view.tv_gender
    val tvEmail : TextView = view.tv_email
    val tvSalary : TextView = view.tv_salary

}