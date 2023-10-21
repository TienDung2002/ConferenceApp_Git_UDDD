package com.example.eventsconferencespj.Activities.Home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.text.Html
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventsconferencespj.Activities.Conf_Detail.ConfeDetail
import com.example.eventsconferencespj.Activities.Location.Location
import com.example.eventsconferencespj.Activities.Users.User_Detail
import com.example.eventsconferencespj.PreventDoubleClick
import com.example.eventsconferencespj.R
import com.example.eventsconferencespj.databinding.ActivityHomeScreenBinding

//class Home_Screen : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
class Home_Screen : AppCompatActivity(){
    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var viewModel: HomeScreenViewModel
    private val List = mutableListOf<ConfeData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // khởi tạo ViewModel
        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)

        // Đổi màu hint của search bar
        val searchItem: SearchView = binding.searchView
        searchItem.setQueryHint(Html.fromHtml("<font color = #ffffff>" + "Tìm kiếm" + "</font>"))
        searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Xử lý tìm kiếm ở đây

                // Ẩn bàn phím
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(searchItem.windowToken, 0)

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Xử lý sự thay đổi văn bản trong ô tìm kiếm (nếu cần)

                return true
            }
        })

        // Nhấn vào nav_location
        binding.navLocation.setOnClickListener {
            if (PreventDoubleClick.checkClick()) {
                val intent = Intent(this, Location::class.java)
                startActivity(intent)
            }
        }

        // Nhấn vào nav_profile
        binding.navProfile.setOnClickListener{
            if (PreventDoubleClick.checkClick()) {
                val intent = Intent(this, User_Detail::class.java)
                startActivity(intent)
            }
        }

        viewModel.addConferenceData(ConfeData(1, "Almaz Convention Center Hà Nội", "Khu đô thị Vinhomes Riverside, Phúc Lợi, Long Biên, Hà Nội", 1600, 120000000, 30, 5.0, R.drawable.almazcenter))
        viewModel.addConferenceData(ConfeData(2, "InterContinental Hanoi Landmark72", "E6, đường Phạm Hùng, khu đô thị mới Cầu Giấy,Yên Hòa, Hà Nội", 2000, 89650000, 25, 4.5, R.drawable.landmark72))
        viewModel.addConferenceData(ConfeData(3, "Trung tâm Hội nghị quốc gia", "Cổng số 1, ĐCT08, Mễ Trì, Nam Từ Liêm, Hà Nội", 700, 100000000, 22, 5.0, R.drawable.trungtamhoinghiqg))
        viewModel.addConferenceData(ConfeData(4, "Trung tâm tổ chức sự kiện Venus", "39 Cầu Diễn, P. Phúc Diễn, Q. Bắc Từ Liêm.", 500, 99250000, 15, 4.5, R.drawable.venus))
        viewModel.addConferenceData(ConfeData(5, "Trống đồng Palace", "65 Quán Sứ, Trần Hưng Đạo, Quận Hoàn Kiếm", 1500, 50000000, 10, 5.0, R.drawable.trongdongplace))
        viewModel.addConferenceData(ConfeData(6, "Tổ chức Tiệc & Sự kiện Vạn Hoa", "Số 20 Ngõ 165 Cầu Giấy, Q. Cầu Giấy.", 500, 13000000, 0, 5.0, R.drawable.trungtamvanhoa))
        viewModel.addConferenceData(ConfeData(7, "Tổ chức Tiệc cưới và Sự kiện Star Galaxy", "Số 87 Láng Hạ, P. Thành Công, Q. Ba Đình.", 400, 24500000, 10, 4.5, R.drawable.stargalaxy))
        viewModel.addConferenceData(ConfeData(8, "Khách sạn Pan Pacific Hanoi", "Số 1 đường Thanh Niên, P. Trúc Bạch, Q. Tây Hồ", 450, 44999000, 12, 5.0, R.drawable.panpacific))
        viewModel.addConferenceData(ConfeData(9, "Khách sạn Sheraton Hanoi", " Số 11 Xuân Diệu, P. Quảng An, Q. Tây Hồ.", 700, 50999000, 40, 5.0, R.drawable.sheratonhanoi))

        // Gán danh sách dữ liệu từ ViewModel cho adapter
        val confDataList = viewModel.getConferenceDataList()
        var adapter = HomeAdapter(confDataList)
        binding.HorizontalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.HorizontalRecyclerView.adapter = adapter

        // Click vào từng item trong recycler
        adapter.setOnItemClickListener(object : HomeAdapter.onItemClickListener{
            override fun onItemClicked(position: Int) {
                val intent = Intent(this@Home_Screen, ConfeDetail::class.java)
                intent.putExtra("name", confDataList[position].confName)
                intent.putExtra("address", confDataList[position].confAdd)
                intent.putExtra("price", confDataList[position].price)
                intent.putExtra("required", confDataList[position].requiredFirstPay)
                intent.putExtra("seat", confDataList[position].seat)
                intent.putExtra("rating", confDataList[position].ratingStar)
                intent.putExtra("image", confDataList[position].image)
                startActivity(intent)
            }
        })
    }
}
