package sg.edu.np.mad.p03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent mainAct = new Intent(ListActivity.this, MainActivity.class);
                int randInt = new Random().nextInt(1000000);
                mainAct.putExtra("randKey", randInt);
                startActivity(mainAct);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
            }
        });

        img = findViewById(R.id.Android);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

}