package id.futnet.praktikumprogmob;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputNama;
    private EditText inputEmail;
    private EditText inputPassword;
    private EditText retypePassword;
    private Button mButtomRegister;
    private CheckBox mBermain;
    private CheckBox mBelajar;
    private String cBox="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNama = (EditText)findViewById(R.id.ET_your_full_name);
        inputEmail = (EditText) findViewById(R.id.ET_your_email_address);
        inputPassword = (EditText) findViewById(R.id.ET_create_new_password);
        retypePassword = (EditText) findViewById(R.id.ET_create_new_repassword);
        mButtomRegister = (Button)findViewById(R.id.ButtomRegister);
        mBelajar = (CheckBox)findViewById(R.id.CB_Belajar);
        mBermain = (CheckBox)findViewById(R.id.CB_Bermain);
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
        final String mNama = inputNama.getText().toString();
        final String mEmail = inputEmail.getText().toString();

        if (mBelajar.isChecked()){
            cBox+="Belajar ";
        }
        if (mBermain.isChecked()){
            cBox+="Bermain ";
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Data Register");
        alertDialogBuilder.setMessage("Nama     : "+mNama+"\n"+"Email      : "+mEmail+"\n"+"Hoby : "+cBox );
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent intent = new Intent(getApplicationContext(),MemberActivity.class);
                                intent.putExtra("nama",mNama);
                                intent.putExtra("email",mEmail);
                                intent.putExtra("hobi",cBox);
                                startActivity(intent);
                            }
                        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
