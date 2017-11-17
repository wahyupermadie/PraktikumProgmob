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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private EditText inputNama;
    private EditText inputEmail;
    private Button mButtomRegister;
    private CheckBox mBermain;
    private CheckBox mBelajar;
    private String cBox="";
    private static SeekBar mTinggi;
    private static TextView tinggi;
    private String mJenisKelamin;
    int progressChangeValue;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        seekBar();
        mButtomRegister.setOnClickListener(this);

    }
    private void validate(){
        selectedId = mRadioGroup.getCheckedRadioButtonId();
        if (inputNama.getText().toString().length()==0){
            inputNama.setError("Nama diperlukan!");
        }
        else if(inputEmail.getText().toString().length()==0) {
            inputEmail.setError("Email diperlukan!");
        }
        else if(tinggi.getText().toString().length()==0) {
            tinggi.setError("Username diperlukan!");
        }else if(selectedId == -1){
            Toast.makeText(this, "Isi Jenis Kelamin", Toast.LENGTH_SHORT).show();
        }else{
            mRadioButton = (RadioButton) findViewById(selectedId);
            mJenisKelamin = mRadioButton.getText().toString();
            register();
        }

    }
    private void seekBar(){
        tinggi.setText(String.valueOf(mTinggi.getProgress()));
        mTinggi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangeValue = progress;
                tinggi.setText(String.valueOf(progressChangeValue));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tinggi.setText(String.valueOf(progressChangeValue));
            }
        });
    }
    private void init(){
        inputNama = (EditText)findViewById(R.id.ET_your_full_name);
        inputEmail = (EditText) findViewById(R.id.ET_your_email_address);
        mButtomRegister = (Button)findViewById(R.id.ButtomRegister);
        mBelajar = (CheckBox)findViewById(R.id.CB_Belajar);
        mBermain = (CheckBox)findViewById(R.id.CB_Bermain);
        mTinggi = (SeekBar)findViewById(R.id.SB_tinggi);
        tinggi = (TextView)findViewById(R.id.TV_tinggi);
        mRadioGroup = (RadioGroup)findViewById(R.id.RG_jenisKelamin);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.ButtomRegister){
            validate();
        }
    }

    private void register() {
        final String mNama = inputNama.getText().toString();
        final String mEmail = inputEmail.getText().toString();
        final String mTinggiBadan = String.valueOf(progressChangeValue);

        if (mBelajar.isChecked()){
            cBox+="Belajar ";
        }
        if (mBermain.isChecked()){
            cBox+="Bermain ";
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Data Register");
        alertDialogBuilder.setMessage(
                "Nama           : "+mNama+"\n"+
                "Email          : "+mEmail+"\n"+
                "Jenis Kelamin  : "+mJenisKelamin+"\n"+
                "Hoby           : "+cBox+"\n"+
                "Umur           : "+mTinggiBadan);
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent intent = new Intent(getApplicationContext(),MemberActivity.class);
                                intent.putExtra("nama",mNama);
                                intent.putExtra("email",mEmail);
                                intent.putExtra("hobi",cBox);
                                intent.putExtra("kelamin",mJenisKelamin);
                                intent.putExtra("tinggi",mTinggiBadan);
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
