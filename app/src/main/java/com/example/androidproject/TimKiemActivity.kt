package com.example.ebook
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.controller.TimKiem.TimKiemController
import com.example.ebook.controller.TimKiem.TimKiemInterface
import com.example.ebook.model.TimKiem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_sach.view.*
import kotlinx.android.synthetic.main.item_timkiem.view.*


class TimKiemActivity: AppCompatActivity() {

//    lateinit var listBookType:MutableList<TimKiem>

    lateinit var mSearchText : EditText
    lateinit var mRecyclerView : RecyclerView

    lateinit var mDatabase : DatabaseReference

    var FirebaseRecyclerAdapter : FirebaseRecyclerAdapter<TimKiem , UsersViewHolder> = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timkiem)

//        TimKiemController.getInstance(this,this)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.nav_timkiem

        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(
                        Intent(
                            applicationContext, HomeActivity::class.java
                        )
                    )
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_timkiem -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_tuychon -> {
                    startActivity(
                        Intent(
                            applicationContext, TuyChonActivity::class.java
                        )
                    )
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        mSearchText =findViewById(R.id.txt_tk)
        mRecyclerView = findViewById(R.id.recycler_tk)


        mDatabase = FirebaseDatabase.getInstance().getReference("Users")


        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))




        mSearchText.addTextChangedListener(object  : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val searchText = mSearchText.getText().toString().trim()

                loadFirebaseData(searchText)
            }
        } )

    }

    private fun loadFirebaseData(searchText : String) {

        if(searchText.isEmpty()){

            FirebaseRecyclerAdapter.cleanup()
            mRecyclerView.adapter = FirebaseRecyclerAdapter

        }else {


            val firebaseSearchQuery = mDatabase.orderByChild("name").startAt(searchText).endAt(searchText + "\uf8ff")

            FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<TimKiem, UsersViewHolder>(

                TimKiem::class.java,
                R.layout.item_timkiem,
                UsersViewHolder::class.java,
                firebaseSearchQuery


            ) {
                private fun populateViewHolder(viewHolder: UsersViewHolder, model: TimKiem?, position: Int) {


                    viewHolder.mview.txt_tensach.setText(model?.tensach)
                    viewHolder.mview.txt_tacgia.setText(model?.tacgia)
                    Picasso.with(applicationContext).load(model?.anhsach).into(viewHolder.mview.img_sach)

                }

            }

            mRecyclerView.adapter = FirebaseRecyclerAdapter

        }
    }


    // // View Holder Class

    class UsersViewHolder(var mview : View) : RecyclerView.ViewHolder(mview) {

    }
}