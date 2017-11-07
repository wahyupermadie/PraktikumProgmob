package id.futnet.praktikumprogmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MemberActivity extends AppCompatActivity {
    String nama;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        nama = getIntent().getStringExtra("nama");
        email = getIntent().getStringExtra("email");
        Toast.makeText(this, "Nama "+nama+" Email "+email, Toast.LENGTH_SHORT).show();
    }
}
