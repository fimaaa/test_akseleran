package com.example.test_akseleran.model.data

data class Node(
    var value:Int? = null,
    var left:Node? = null,
    var right:Node? = null,
    var duplicate:Int = 0
){


    //Add Node Binary
    fun add(value:Int){
        val root = addRecursive(this,value)
        this.value = root.value
        this.left = root.left
        this.right = root.right
        this.duplicate = root.duplicate
    }

    private fun addRecursive(
        current: Node?,
        value: Int
    ): Node {
        if (current?.value == null) {
            println("add in $value")
            return Node(value)
        }
        val gap:Int? = current.value
        // value already exists
        when {
            gap == null -> return current
            value < gap ->{
                println("add in left is $value")
                current.left = addRecursive(current.left, value)
            }
            value > gap -> {
                println("add in Right is $value")
                current.right = addRecursive(current.right, value)
            }
            else -> {
                current.duplicate ++
            }
        }
        return current
    }

    //Find Value Binary
    fun containsNode(value: Int): Boolean {
        return containsNodeRecursive(this, value)
    }

    private fun containsNodeRecursive(
        current: Node?,
        value: Int
    ): Boolean {
        if (current == null) {
            return false
        }
        if (value == current.value) {
            return true
        }
        val gap:Int? = current.value
        return when {
            gap == null -> {
                false
            }
            value < gap -> containsNodeRecursive(
                current.left,
                value
            )
            else -> containsNodeRecursive(current.right, value)
        }
    }

    //Print Logcat
    fun traversePreOrder(node:Node?,childNode:Int){
        if(node != null) {
            var pad = "Node --"
            for(i in 0 until childNode){
                pad += if(i == childNode-1){
                    "└──"
                }else {
                    "   "
                }
            }
            println(pad+node.value)
            traversePreOrder(node.left,(childNode+1))
            traversePreOrder(node.right,(childNode+1))
        }
    }

    //print String
    fun traversePreOrderString(node:Node?,childNode:Int):String{
        var answer = ""
        if(node != null) {
            var pad = "Node --"
            for(i in 0 until childNode){
                pad += if(i == childNode-1){
                    "└──"
                }else {
                    "   "
                }
            }
            answer = (pad+node.value)+"\n"
            answer += traversePreOrderString(node.left,(childNode+1))
            answer += traversePreOrderString(node.right,(childNode+1))
        }
        return answer
    }
}