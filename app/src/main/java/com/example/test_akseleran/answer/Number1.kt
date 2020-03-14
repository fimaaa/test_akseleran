package com.example.test_akseleran.answer


object Number1 {
    fun sortAscending(listQuestion: MutableList<Int>):MutableList<Int>{
        var gap = listQuestion.size / 2
        while (gap > 0) {
            var i = gap
            while (i < listQuestion.size) {
                val temp: Int = listQuestion[i]
                var j = i
                while (j >= gap && listQuestion[j - gap]> temp) {
                    listQuestion[j] = listQuestion[j - gap]
                    j -= gap
                }
                listQuestion[j] = temp
                i += 1
            }
            gap /= 2
        }
        return listQuestion
    }

    fun sortDescending(listQuestion: MutableList<Int>):MutableList<Int>{
        var gap = listQuestion.size / 2
        while (gap > 0) {
            var i = gap
            while (i < listQuestion.size) {
                val temp: Int = listQuestion[i]
                var j = i
                while (j >= gap && listQuestion[j - gap]< temp) {
                    listQuestion[j] = listQuestion[j - gap]
                    j -= gap
                }
                listQuestion[j] = temp
                i += 1
            }
            gap /= 2
        }
        return listQuestion
    }
}