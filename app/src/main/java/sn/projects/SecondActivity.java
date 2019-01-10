package sn.projects;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView mUid;
    private TextView mEmail;
    private ImageView mImage;
    private Button uChange;
    private String Uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //initializing firebase
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();

        mUid = findViewById(R.id.tv_uid);
        mEmail = findViewById(R.id.tv_email);
        mImage = findViewById(R.id.img_user);
        uChange = findViewById(R.id.chng_btn);


        //Displaying user information from firebase
        mUid.setText(mAuth.getUid());
        mEmail.setText(user.getEmail());
        //updating the image view to reflect if the user has an image or not
        updatePhoto(user);

        uChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfileChangeRequest pupdate = new UserProfileChangeRequest.Builder()
                        .setPhotoUri(Uri.parse("https://firebasestorage.googleapis.com/v0/b/projecttestings.appspot.com/o/userIMG%2F6.jpg?alt=media&token=b379b7e2-2040-4c21-95c7-20bf66cf9b43)"))
                                .build();
                user.updateProfile(pupdate);
                updatePhoto(user);
            }
        });
    }

    public void updatePhoto(FirebaseUser user){
        if(user.getPhotoUrl() != null){
            Toast.makeText(this, "You seem to have a picture stored", Toast.LENGTH_SHORT).show();

        }else {
            mImage.setImageResource(R.drawable.ic_person_outline_black_24dp);
        }
    }
}
