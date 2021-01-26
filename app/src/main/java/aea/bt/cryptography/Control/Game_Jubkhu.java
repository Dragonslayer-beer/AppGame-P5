package aea.bt.cryptography.Control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import aea.bt.cryptography.ImageAdater;
import aea.bt.cryptography.R;

public class Game_Jubkhu extends AppCompatActivity {
ImageView curView = null;
private int conunt = 0 ;
    private int quizCount = 1;
    final static private int Quiz_Count = 10;
final int[] drawable  = new int[]{
        R.drawable.animals_1,R.drawable.animals_2,R.drawable.animals_3,R.drawable.animals_4,R.drawable.animals_5,R.drawable.animals_6};
int [] pos = {0,1,2,3,4,5,0,1,2,3,4,5};
int currentPos = -1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game__jubkhu);
        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdater imageAdater = new ImageAdater(this);
        gridView.setAdapter(imageAdater);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentPos < 0 ){
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }else {
                    if (currentPos == position){
                        ((ImageView)view).setImageResource(R.drawable.bg_test);

                    }else if (pos[currentPos]!=pos[position]){
                        curView.setImageResource(R.drawable.bg_test);
                        Toast.makeText(Game_Jubkhu.this, "No Match", Toast.LENGTH_SHORT).show();
                    }else {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        currentPos++;
                        if (conunt == 0 ){
                            Toast.makeText(Game_Jubkhu.this, "Your Win", Toast.LENGTH_SHORT).show();
                        }
                    }
                    currentPos = -1 ;

                }
            }
        });

    }
}