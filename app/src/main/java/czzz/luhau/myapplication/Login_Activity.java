package czzz.luhau.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import czzz.luhau.myapplication.Model.User;

public class Login_Activity extends AppCompatActivity {

    DatabaseReference mData;
    FirebaseDatabase fb;
    public String username, pass;
    Button btnlogin, btnreg;
    EditText ed_tentk, ed_dnmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.btn_login);
        btnreg = findViewById(R.id.btn_re);
        ed_tentk = findViewById(R.id.ed_tentk);
        ed_dnmk = findViewById(R.id.ed_mkdn);


        fb = FirebaseDatabase.getInstance();
        mData = fb.getReference("User");

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(Login_Activity.this);
                mDialog.setMessage("Xin đợi...");
                mDialog.show();

                mData.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        username = ed_tentk.getText().toString();
                        pass = ed_dnmk.getText().toString();

                        if (dataSnapshot.child(username).exists()) {
                            mDialog.dismiss();
                            //get dữ liệu database
                            User user = dataSnapshot.child(username).getValue(User.class);
                            user.getmUserName(username);

                            if (user.getmPass().equals(pass)) {
                                //Trùng pass sẽ login vô main
                                Intent i = new Intent(Login_Activity.this, MainActivity.class);
                                startActivity(i);
                                Toast.makeText(Login_Activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(Login_Activity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(Login_Activity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Login_Activity.this, Reg_Activity.class);
                startActivity(it);
            }
        });


    }
}
