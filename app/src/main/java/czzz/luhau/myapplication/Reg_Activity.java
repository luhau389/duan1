package czzz.luhau.myapplication;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Reg_Activity extends AppCompatActivity {
    DatabaseReference mData;
    FirebaseDatabase fb;

    Button btnreg;
    EditText ed_tentk, ed_dnmk, ed_sdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        //Anh xa
        btnreg = findViewById(R.id.btn_re);
        ed_tentk = findViewById(R.id.ed_tentk);
        ed_dnmk = findViewById(R.id.ed_mkdn);
        ed_sdt = findViewById(R.id.ed_sdt);

        //Khoi tao firebase
        fb = FirebaseDatabase.getInstance();
        mData = fb.getReference("User");

        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String username = ed_tentk.getText().toString();
                if (dataSnapshot.child(username).exists()) {
//                    mDialog.dismiss();
                  //  Toast.makeText(Reg_Activity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dialog đợi trong vài giây
                final ProgressDialog mDialog = new ProgressDialog(Reg_Activity.this);
                mDialog.setMessage("Xin đợi....");
                mDialog.show();

                String username = ed_tentk.getText().toString();
                String pass = ed_dnmk.getText().toString();
                String phone = ed_sdt.getText().toString();

//                                     mDialog.dismiss();
                User user = new User(username, pass, phone);

                mData.child(username).setValue(user);

                finish();
                Toast.makeText(Reg_Activity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();


            }
        });


    }
}
