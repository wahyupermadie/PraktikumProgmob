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
import id.futnet.praktikumprogmob.model.MemberResult;

public class MemberActivity extends AppCompatActivity {
    String nama;
    String email;
    String mHobi;
    String mTinggi;
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
        rvMember = (RecyclerView)findViewById(R.id.RV_member);
        rvMember.setLayoutManager(new LinearLayoutManager(this));
        getMember();
    }

    public void getMember(){
        MemberResult memberResult1= new MemberResult();
        memberResult1.setNama(nama);
        memberResult1.setEmail(email);
        memberResult1.setTinggi(mTinggi);
        memberList.add(memberResult1);
        memberAdapter = new MemberAdapter(memberList, this);
        rvMember.setAdapter(memberAdapter);
    }

}
