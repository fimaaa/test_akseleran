package com.example.test_akseleran.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_akseleran.R
import com.example.test_akseleran.answer.Number1
import com.example.test_akseleran.model.data.Node
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity:AppCompatActivity() {
    private val list = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeList()
        println("Question = $list")
        tv_list.text = list.toString()


        questionOne()
        questionTwo()
    }

    private fun makeList(){
        list.add(5)
        list.add(8)
        list.add(3)
        list.add(7)
        list.add(6)
        list.add(9)
        list.add(4)
        list.add(1)
    }

    private fun questionOne(){
        list.clear()
        makeList()
        println("Answer Ascending = ${Number1.sortAscending(list)}")
        println("Answer Descending= ${Number1.sortDescending(list)}")
        tv_list_ascending.text = Number1.sortAscending(list).toString()
        tv_list_descending.text = Number1.sortDescending(list).toString()
    }

    private fun questionTwo(){

        //Add Binary
        list.clear()
        makeList()
        val node = Node()
        for(i in 0 until list.size){
            node.add(list[i])
        }

        //Find Value Binary
        println("value 5 is ${node.containsNode(5)}")
        tv_find_one.text = "value 5 is ${node.containsNode(5)}"
        println("value 2 is ${node.containsNode(2)}")
        tv_find_two.text = "value 2 is ${node.containsNode(2)}"

        //Print Binary Search
        println(" Traverese :")
        println(node.traversePreOrder(node,0))
        tv_bfs_design.text = node.traversePreOrderString(node,0)

    }
}