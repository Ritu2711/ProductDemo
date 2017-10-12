package proj.productgallery.wishlist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import proj.productgallery.R;

public class DialogWish extends AppCompatActivity {
    ArrayList<Data> arrayList = new ArrayList<>();

    ListView listdata;
    ImageButton btn;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_wish);

        listdata = (ListView) findViewById(R.id.listdata);
        editText = (EditText) findViewById(R.id.editText);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {


                if (((keyEvent.getAction()==KeyEvent.ACTION_DOWN)) && (i==KeyEvent.KEYCODE_ENTER)){
                    if (editText.getText().toString()!=null && !editText.getText().toString().isEmpty()) {
                        Data data = new Data(editText.getText().toString(), false);
                        arrayList.add(data);
                        MyCustomAdapter dataAdapter = new MyCustomAdapter(DialogWish.this,
                                R.layout.row, arrayList);
                        listdata.setAdapter(dataAdapter);
                        editText.setText("");
                        editText.setSingleLine(true);

                    }
                }
                return false;
            }
        });


    }

    private class MyCustomAdapter extends ArrayAdapter<Data> {

        private ArrayList<Data> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Data> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<Data>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.wishrow, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        Data country = (Data) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Data country = countryList.get(position);
            holder.code.setText(" (" + country.getName() + ")");
            holder.name.setText(country.getName());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);

            return convertView;

        }

    }

    private void checkButtonClick() {


        /*Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Country> countryList = dataAdapter.countryList;
                for(int i=0;i<countryList.size();i++){
                    Country country = countryList.get(i);
                    if(country.isSelected()){
                        responseText.append("\n" + country.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }
*/
    }

}