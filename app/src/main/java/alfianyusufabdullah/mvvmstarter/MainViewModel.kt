package alfianyusufabdullah.mvvmstarter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val result = MutableLiveData<MainState>()
    var counter = 0

    fun increment() {
        counter++
        result.value = MainState.OnResult(counter)
    }

    fun decrement() {
        counter--
        result.value = MainState.OnResult(counter)
    }

    fun restore(){
        result.value = MainState.OnResult(counter)
    }
}