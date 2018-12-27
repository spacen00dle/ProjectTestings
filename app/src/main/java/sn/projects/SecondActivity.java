package sn.projects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView mUid;
    private TextView mEmail;
    private ImageView mImage;
    private String Uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();

        mUid = findViewById(R.id.tv_uid);
        mEmail = findViewById(R.id.tv_email);
        mImage = findViewById(R.id.img_user);

        mUid.setText(mAuth.getUid());
        mEmail.setText(user.getEmail());
        updatePhoto(user);
    }

    public void updatePhoto(FirebaseUser user){
        if(user.getPhotoUrl() != null){

        }else {
            mImage.setImageResource(R.drawable.ic_person_outline_black_24dp);
        }
    }
}
