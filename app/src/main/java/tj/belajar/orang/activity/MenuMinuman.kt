package tj.belajar.orang.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_menu_makan.*
import kotlinx.android.synthetic.main.activity_menu_makan.rv_menu
import kotlinx.android.synthetic.main.activity_menu_minum.*
import tj.belajar.orang.R
import tj.belajar.orang.adapter.AdapterMakanan
import tj.belajar.orang.adapter.AdapterMinuman
import tj.belajar.orang.interfaces.onGetResponse
import tj.belajar.orang.model.StaticVariabel
import tj.belajar.orang.model.makan.AllMakanan
import tj.belajar.orang.model.makan.Makanan
import tj.belajar.orang.model.makan.dataMakanan
import tj.belajar.orang.model.minum.AllMinuman
import tj.belajar.orang.model.minum.Minuman
import tj.belajar.orang.task.TaskGetRequest

class MenuMinuman : AppCompatActivity() {
    lateinit var context: Context
    private var list: ArrayList<Minuman> = ArrayList()
    lateinit var listMinum: AdapterMinuman


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_minum)
        initWidget()

        pesanminum.setOnClickListener{
            startActivity(Intent(this, Sukses::class.java))
        }

    }

    fun initWidget() {

        context = this@MenuMinuman

        rv_menu.setHasFixedSize(true)

        btnMakanan1.setOnClickListener {
            startActivity(Intent(this, MenuMakanan::class.java))
            finish()
        }


        showRecyleView()

        TaskGetRequest("${StaticVariabel.baseURL}api/all_minuman.php", object : onGetResponse {
            override fun onError(message: String) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }

            override fun onGetData(body: String) {
                try {
                    val data = Gson().fromJson<AllMinuman>(body, AllMinuman::class.java)
                    list.clear()
                    list.addAll(data.data)
                    //list.addAll(data.data)
                    listMinum.notifyDataSetChanged()

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }).execute()
    }

    private fun showRecyleView() {
        listMinum = AdapterMinuman(list)
        rv_menu.adapter = listMinum
        rv_menu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}

