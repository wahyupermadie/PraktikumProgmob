package id.futnet.praktikumprogmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.futnet.praktikumprogmob.adapter.MemberAdapter;
import id.futnet.praktikumprogmob.api.ApiInterface;
import id.futnet.praktikumprogmob.api.MemberApi;
import id.futnet.praktikumprogmob.model.MemberResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberActivity extends AppCompatActivity {
    String nama;
    String email;
    String mHobi;
    String mTinggi;
    String mJenisKelamin;
    RecyclerView rvMember;
    MemberAdapter memberAdapter;
    List<MemberResult> memberList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        nama = getIntent().getStringExtra("nama");
        email = getIntent().getStringExtra("email");
        mHobi = getIntent().getStringExtra("hobi");
        mTinggi = getIntent().getStringExtra("tinggi");
        mJenisKelamin = getIntent().getStringExtra("kelamin");
        rvMember = (RecyclerView)findViewById(R.id.RV_member);
        rvMember.setLayoutManager(new LinearLayoutManager(this));
        getMember();
    }

    public void getMember(){
        MemberResult memberResult1= new MemberResult();
        memberResult1.setNama(nama);
        memberResult1.setEmail(email);
        memberResult1.setTinggi(mTinggi);
        memberResult1.setHobi(mHobi);
        memberResult1.setKelamin(mJenisKelamin);
        memberList.add(memberResult1);
        memberAdapter = new MemberAdapter(memberList, this);
        rvMember.setAdapter(memberAdapter);
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(),"16. onDestroy()", Toast.LENGTH_SHORT).show();
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
