package com.example.github
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Callback
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
val TAG:String="welcome"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        GlobalScope.launch  (Dispatchers.Main) {
            val a= withContext(Dispatchers.IO) {

                getresuult("https://api.github.com/search/users?q=shubhanshu%22")

            }
            val githubadapter = GithubAdapter(a)
            rcv.layoutManager = LinearLayoutManager(this@MainActivity)

            rcv.adapter = githubadapter
        }
        }
    }
    suspend fun getresuult(url:String):List<Item>{
        val okHttpClient= OkHttpClient()
        val request=Request.Builder().url(url).build()
        val response=okHttpClient.newCall(request).execute()
        val res=response.body?.string()
        val gson=Gson()
        val githubuser=gson.fromJson<githubuser>(res,githubuser::class.java)
        return githubuser.items

    }
