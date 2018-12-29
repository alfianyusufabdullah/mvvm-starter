package alfianyusufabdullah.mvvmstarter

sealed class MainState {
    data class OnResult(val result: Int) : MainState()
}