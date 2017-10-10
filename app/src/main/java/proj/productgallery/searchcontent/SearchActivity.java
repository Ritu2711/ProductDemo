package proj.productgallery.searchcontent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import proj.productgallery.MainActivity;
import proj.productgallery.R;
import proj.productgallery.productdetail.ItemDetailsFragment;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    AutoCompleteTextView textView=null;
    TextView toolbar_ivNavigation;
    ImageView img;
    LinearLayout linearLayout;
    private ArrayAdapter<String> adapter;

    //These values show in autocomplete
    String item[]={
            "Product 1", "Product 2", "Product 3", "Product 4",
            "Product 5", "Product 6", "Product 7", "Product 8",
            "Product 9", "Product 10", "Product 11", "Product 12"
    };
    ImageView search_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_back= (ImageView) findViewById(R.id.search_back);
        img= (ImageView) findViewById(R.id.img);
        linearLayout= (LinearLayout) findViewById(R.id.lc);
        toolbar_ivNavigation= (TextView) findViewById(R.id.toolbar_ivNavigation);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchActivity.this, "Pending", Toast.LENGTH_SHORT).show();
            }
        });
        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                finish();
            }
        });
        textView = (AutoCompleteTextView) findViewById(R.id.search_box);

        //Create adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);

        textView.setThreshold(1);

        //Set adapter to AutoCompleteTextView
        textView.setAdapter(adapter);
        textView.setOnItemSelectedListener(this);
        textView.setOnItemClickListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {
        // TODO Auto-generated method stub
        //Log.d("AutocompleteContacts", "onItemSelected() position " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub

        // Show Alert
        img.setVisibility(View.VISIBLE);

        toolbar_ivNavigation.setText(""+arg0.getItemAtPosition(arg2));
        linearLayout.setClickable(true);


    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}
