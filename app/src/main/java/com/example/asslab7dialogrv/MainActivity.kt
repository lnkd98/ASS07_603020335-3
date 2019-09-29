package com.example.asslab7dialogrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*

class MainActivity : AppCompatActivity() {

    val employeeList  = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        testEmployeeData()

        recycle_view.adapter = EmployeeAdapter(this.employeeList, applicationContext)
        recycle_view.layoutManager = LinearLayoutManager(applicationContext) as RecyclerView.LayoutManager?
        recycle_view.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?
    }

    fun addEmployee(view: View) {

        val mDialogView  = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val mBuilder = AlertDialog.Builder(this)

        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener {

            var radioGroup: RadioGroup = mDialogView.radioGroup
            var selectedId:Int = radioGroup.checkedRadioButtonId
            var radioButton: RadioButton = mDialogView.findViewById(selectedId)

            employeeList.add ( Employee(
                mDialogView.edt_name.text.toString(),
                        radioButton.text.toString(),
                mDialogView.edt_email.text.toString()
                ,mDialogView.edt_salary.text.toString().toInt()
            )
            )
            recycle_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext,"The Employee is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()


        }

        mDialogView.btnCancel.setOnClickListener() {
            mAlertDialog.dismiss()

        }

    }

    fun testEmployeeData() {
        employeeList.add(Employee("Danny","Male ", "Danny@kkumail.com",30000))
        employeeList.add(Employee("sara","Female ", "Sara@kkumail.com",34000))

    }
}


