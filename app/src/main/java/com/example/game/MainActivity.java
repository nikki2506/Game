package com.example.game;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    ImageView curView=null;
    private int countPair=0;
    final int[ ] drawable=new int[]{R.drawable.image0,R.drawable.image1
            ,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.
            image8};

    int[ ] pos={5,4,3,1,6,2,8,0,7,0,5,3,7,4,2,1,8,6};
    int currentpos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView=(GridView)findViewById(R.id.gridView);
        ImageAdapter imageAdapter=new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentpos < 0)
                {

                    currentpos = position;
                     curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);

                }
                else
                {
                    if( currentpos==position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.sample);
                    }
                    else if( pos[currentpos]!=pos[position])
                    {
                        curView.setImageResource(R.drawable.sample);
                        Toast.makeText(getApplicationContext(),"not match",Toast.LENGTH_SHORT).show( );
                    }
                    else
                    {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if(countPair==8)
                        {
                            Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_SHORT).show();
                        }
                    }
                    currentpos=-1;

                }
            }


        });



    }
}
