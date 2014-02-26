package com.example.test;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ArrayList<String> delteID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView=(ListView) findViewById(R.id.listView1);
		 String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
			        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
			        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
			        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
			        "Android", "iPhone", "WindowsMobile" };
		MySimpleArrayAdapter adapter=new MySimpleArrayAdapter(getApplicationContext(), values);
		listView.setAdapter(adapter);
		
		delteID=new ArrayList<String>();
		
//		Button deleteButton=(Button) findViewById(R.id.deleteBt);
//		deleteButton.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				for (String string : delteID) {
//					Log.i("TAG", string);
//					
//					//U can send the Delete Request from HERE
//				}
//			}
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final String[] values;

	  public MySimpleArrayAdapter(Context context, String[] values) {
	    super(context, R.layout.custom_list, values);
	    this.context = context;
	    this.values = values;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.custom_list, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.text1);
	    CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.check1);
	    textView.setText(values[position]);
	    checkBox.setOnCheckedChangeListener(new CheckUpdateListener(position));
	    // Change the icon for Windows and iPhone
	    String s = values[position];
	   
	    return rowView;
	  }
	  
	  private final class CheckUpdateListener implements OnCheckedChangeListener
		{
			private final int index;
			/**
			 * @param child
			 */
			private CheckUpdateListener(int index)
			{
				this.index = index;
			}
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				
				if(isChecked)
				{
					delteID.add("ID"+index);
					//U may get the id from the actual data u received form the server itself with
					//index data
				}
				else
				{
					delteID.remove("ID"+index);
				}
			}
		}

	} 

}