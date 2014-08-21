package at.karmel.karmelexerzitien;

import java.io.IOException;
import java.io.InputStream;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DayFragment extends Fragment implements OnClickListener{
	
	public Day day;

	
	public DayFragment() {
		
	}
	
	public static DayFragment newInstance(Day day) {
		DayFragment fragment = new DayFragment();
		fragment.day = day;
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_day_index, container, false);
		//find all elements in Fragment View
		ImageView poster = (ImageView)rootView.findViewById(R.id.posterImage);
		TextView date = (TextView) rootView.findViewById(R.id.date);
		TextView title = (TextView) rootView.findViewById(R.id.title);
		Button impulseButton = (Button) rootView.findViewById(R.id.impulse);
		Button gospelButton = (Button) rootView.findViewById(R.id.gospel);
		gospelButton.setOnClickListener(this);
		impulseButton.setOnClickListener(this);
		
		date.setText(this.day.dateDescription());
		title.setText(this.day.headline);
		
		try {
			InputStream is = getActivity().getAssets().open(day.number + ".jpg");
			poster.setImageDrawable(Drawable.createFromStream(is, day.number + ".jpg"));
		} catch (IOException e) {
			
		}
		
		return rootView;
	}
	

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(getActivity(), ContentViewActivity.class);
		
		switch (v.getId()) {
		
		case R.id.impulse:
			intent.putExtra(ContentViewActivity.URL, "file:///android_asset/" + day.number + ".html");
			startActivity(intent);
			break;
		
		case R.id.gospel:
			intent.putExtra(ContentViewActivity.URL, "file:///android_asset/" + day.number + "e.html");
			startActivity(intent);
			break;
		
				
		}
		
		
	}
}
