package com.gdsc.notesapp.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gdsc.notesapp.R

class SettingsViewModel:ViewModel() {
    val settingsLists: MutableLiveData<List<SettingsModel>> by lazy {
        MutableLiveData<List<SettingsModel>>()
    }
    private var settingsList:ArrayList<SettingsModel>
    init{
        settingsList = ArrayList()
        getSettingList()
    }
    private fun getSettingList(){
        fetchList()
        settingsLists.value = settingsList
    }
    private fun fetchList() {
        settingsList.add(SettingsModel(imageId = R.drawable.user1 , imgDis = "Hi UserName"))
        settingsList.add(SettingsModel(imageId = R.drawable.edit_profile , imgDis = "EditProfile"))
        settingsList.add(SettingsModel(imageId = R.drawable.edit_profile , imgDis = "Change Password"))
        settingsList.add(SettingsModel(imageId = R.drawable.toggle_off , imgDis = "Push Notification"))
        settingsList.add(SettingsModel(imageId = R.drawable.toggle_off , imgDis = "Dark Mode"))
        settingsList.add(SettingsModel(imageId = R.drawable.edit_profile , imgDis = "About Us"))
        settingsList.add(SettingsModel(imageId = R.drawable.edit_profile , imgDis = "Privacy Policy"))
        settingsList.add(SettingsModel(imageId = R.drawable.edit_profile , imgDis = "Terms and Conditions"))
        settingsList.add(SettingsModel(imageId = R.drawable.ic_login , imgDis = "LogOut"))

    }
}