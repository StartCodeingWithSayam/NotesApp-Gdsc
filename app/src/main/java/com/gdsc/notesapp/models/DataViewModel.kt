package com.gdsc.notesapp.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gdsc.notesapp.R

class DataViewModel :ViewModel() {
    val dataLists:MutableLiveData<List<Data>> by lazy {
        MutableLiveData<List<Data>>()
    }
    private var dataList:ArrayList<Data> = ArrayList()

    init{
        getDataList()
    }
    private fun getDataList(){
        fetchList()
        dataLists.value = dataList
    }

    private fun fetchList() {
        dataList.add(Data(imageId = R.drawable.chemistery, imgDis = "Chemistry"))
        dataList.add(Data(imageId = R.drawable.python, imgDis = "Python"))
        dataList.add(Data(imageId = R.drawable.img, imgDis = "Information Technology"))
        dataList.add(Data(imageId = R.drawable.maths, imgDis = "Maths"))
        dataList.add(Data(imageId = R.drawable.book, imgDis = "physics"))
        dataList.add(Data(imageId = R.drawable.java, imgDis = "Java"))
        dataList.add(Data(imageId = R.drawable.cpp, imgDis = "C++"))
    }
}