package com.example.googlelogin

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_date_count.*
import java.util.*


class DateCountActivity : AppCompatActivity() {

    var mYear : Int = 0
    var mMonth: Int = 0
    var mDay  :Int = 0

    internal var mTxtDate1: TextView?= null
    internal var mTxtDate2: TextView?= null
    internal var mTxtDate3: TextView?= null


    //날짜 대화상자 리스너 부분
    internal var mDateSetListener1: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            //사용자가 입력한 값을 가져온뒤
            mYear = year
            mMonth = monthOfYear
            mDay = dayOfMonth

            //텍스트뷰의 값을 업데이트함
            UpdateNow1()

        }
    internal var mDateSetListener2: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            //사용자가 입력한 값을 가져온뒤
            mYear = year
            mMonth = monthOfYear
            mDay = dayOfMonth

            //텍스트뷰의 값을 업데이트함
            UpdateNow2()

        }

    internal var mDateSetListener3: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            //사용자가 입력한 값을 가져온뒤
            mYear = year
            mMonth = monthOfYear
            mDay = dayOfMonth

            //텍스트뷰의 값을 업데이트함
            UpdateNow3()

        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_count)

        if (intent.hasExtra("UserName")) {
            date_count_username.text = intent.getStringExtra("UserName")
        } else {
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }


        //다음화면인 HTDActivity로 넘어가기 위한 버튼, intent
        val b = findViewById<View>(R.id.bt_tohtd) as Button
        b.setOnClickListener(View.OnClickListener {
            val HTDintent = Intent(this, HTDActivity::class.java)
            startActivity(HTDintent)
        })


        mTxtDate1 = findViewById<View>(R.id.val_firstdate) as TextView
        mTxtDate2 = findViewById<View>(R.id.val_yourbitrhday) as TextView
        mTxtDate3 = findViewById<View>(R.id.val_loverbithday) as TextView

        //현재 날짜와 시간을 가져오기위한 Calendar 인스턴스 선언
        val cal = GregorianCalendar()

        mYear = cal.get(Calendar.YEAR)
        mMonth = cal.get(Calendar.MONTH)
        mDay = cal.get(Calendar.DAY_OF_MONTH)

        UpdateNow1()//화면에 텍스트뷰에 업데이트 해줌.
        UpdateNow2()
        UpdateNow3()


    }
    fun mOnClick(v: View) {

        when (v.id) {

            //하트 버튼이 눌리면 대화상자를 보여줌

            R.id.bt_emptyheart -> {
                //여기서 리스너도 등록함
                DatePickerDialog(this, mDateSetListener1, mYear, mMonth, mDay).show()
                bt_emptyheart.setSelected(true)
            }

            R.id.bt_emptyheart2 -> {
                DatePickerDialog(this, mDateSetListener2, mYear, mMonth, mDay).show()
                bt_emptyheart2.setSelected(true)
            }
            R.id.bt_emptyheart3 -> {
                DatePickerDialog(this, mDateSetListener3, mYear, mMonth, mDay).show()
                bt_emptyheart3.setSelected(true)
            }
        }
    }

    //텍스트뷰의 값을 업데이트 하는 메소드

    internal fun UpdateNow1() {

        mTxtDate1?.text = String.format("%d/%d/%d", mYear, mMonth + 1, mDay)

    }
    internal fun UpdateNow2(){
        mTxtDate2?.text = String.format("%d/%d/%d", mYear, mMonth + 1, mDay)
    }
    internal fun UpdateNow3(){
        mTxtDate3?.text = String.format("%d/%d/%d", mYear, mMonth + 1, mDay)
    }







}
