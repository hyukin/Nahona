package org.techtwn.nahona;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import shopping.carrot;

public class write_selling_info extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private String title;
    private String price;
    private String explain;
    EditText ed_title, ed_price, ed_explain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_selling_info);

        Button btn_save = (Button)findViewById(R.id.btn_save);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("carrot");

        ed_title = (EditText)findViewById(R.id.editText);
        ed_price = (EditText)findViewById(R.id.editText2);
        ed_explain = (EditText)findViewById(R.id.editText3);

        /*title = ed_title.getText().toString().trim();
        //System.out.println(title);
        price = ed_price.getText().toString();
        eplain = ed_explain.getText().toString();*/



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title = ed_title.getText().toString().trim();
                //System.out.println(title);
                price = ed_price.getText().toString();
                explain = ed_explain.getText().toString();

                carrot c = new carrot(title, price, explain);
            /*HashMap<String, carrot> carrots = new HashMap<>();
            carrots
            hashMap.put("title", title);
            hashMap.put("price", price);
            hashMap.put("explain", explain);
            databaseReference.child(title).setValue(hashMap);*/
                //databaseReference.child().setValue(hashMap);
                /*DatabaseReference carrotRef = */
                databaseReference.push().setValue(c);
                //carrotRef.push().setValue(new carrot(title, price, explain));
            }
        });



    }
}