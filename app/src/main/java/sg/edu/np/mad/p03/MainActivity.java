package sg.edu.np.mad.p03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button message;
    Boolean followed = false;
    User user = new User("Alfred", "Very cool", 1, false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView9);
        text.setText(user.Name + "\n" + user.Description); // Set text to user class info

        if (user.Followed) {        // Change button text depending on User's follow status
            text = findViewById(R.id.button6);
            text.setText("Unfollow");
        }

        Intent receivingEnd = getIntent();      //Random Int assigned to text in Practical 3
        int randInt = receivingEnd.getIntExtra("randKey",0);

        text = findViewById(R.id.Title);
        text.setText("MAD " + randInt);

        message = findViewById(R.id.message);   //place an event listener on the onclick button
        message.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent msgGrp = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(msgGrp);
            }
        });
    }

    public void Follow(View view){
        text = findViewById(R.id.button6);   //linked to the follow button
        followed = !followed;  //Switches between bool values when pressed
        if (followed){
            text.setText("Unfollow");
            Toast.makeText(getBaseContext(),"Followed",Toast.LENGTH_SHORT).show();
        }
        else {
            text.setText("Follow");
            Toast.makeText(getBaseContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
        }
    }
}