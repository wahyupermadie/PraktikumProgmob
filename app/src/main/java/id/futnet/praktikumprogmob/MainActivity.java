package id.futnet.praktikumprogmob;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputNama;
    private EditText inputEmail;
    private EditText inputPassword;
    private Button mButtomRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNama = (EditText)findViewById(R.id.ET_your_full_name);
        inputEmail = (EditText) findViewById(R.id.ET_your_email_address);
        inputPassword = (EditText) findViewById(R.id.ET_create_new_password);
        mButtomRegister = (Button)findViewById(R.id.ButtomRegister);

        mButtomRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.ButtomRegister){
            register();
        }
    }

    private void register() {
        String mNama = inputNama.getText().toString();
        String mEmail = inputEmail.getText().toString();
        Toast.makeText(this, mNama+" "+mEmail, Toast.LENGTH_LONG).show();
    }
}
