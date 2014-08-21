package at.karmel.karmelexerzitien;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class DayIndexActivity extends ActionBarActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private ViewPager mViewPager;

	private ImageView mBackgorund;
	
	private Day mDays[];
	private int today = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Generate daily content:
		createDayArray();
		//TODO: Implement!
		setNotifications();
		today = getTodayIndex();

		setContentView(R.layout.activity_day_index);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		mViewPager.setCurrentItem(today, true);

		mBackgorund = (ImageView) findViewById(R.id.imageView1);
		mBackgorund.setBackgroundColor(0xFFBABDE9);

	}
	
	protected void onResume() {
		super.onResume();
		//recalculate the actual shown slide:
		today = getTodayIndex();
	}

	@Override
	public void onBackPressed() {
		if (mViewPager.getCurrentItem() == 0) {
			// If the user is currently looking at the first step, allow the
			// system to handle the
			// Back button. This calls finish() on this activity and pops the
			// back stack.
			super.onBackPressed();
		} else {
			// Otherwise, select the previous step.
			mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.day_index, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		if (id == R.id.about) {
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public int getTodayIndex() {
		int result = 0;
		Date now = new Date();
		
		for(Day day : mDays) {
			if(day.date.before(now)) {
				result = Math.max(result, day.number);
			}
		}
		
		return result;
	}
	
	public void setNotifications() {
		/*
		for(Day day : mDays) {
			
		}*/
		
	}

	public void createDayArray() {

		Calendar cal = new GregorianCalendar();

		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 5);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		// Date startDate = cal.getTime();
		int startNumber = 1;

		Day day1 = new Day();
		day1.name = "Aschermittwoch";
		day1.headline = "Innere Umkehrbewegung";
		day1.number = startNumber++;
		day1.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		Day day2 = new Day();
		day2.name = "";
		day2.headline = "Weckruf von … Gott?…";
		day2.number = startNumber++;
		day2.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day3 = new Day();
		day3.name = "";
		day3.headline = "Höre mich und hilf mir!";
		day3.number = startNumber++;
		day3.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day4 = new Day();
		day4.name = "";
		day4.headline = "In Gottes Herzen";
		day4.number = startNumber++;
		day4.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day5 = new Day();
		day5.name = "Erster Fastensonntag";
		day5.headline = "Mir kann an keinem Ort der Welt etwas fehlen!";
		day5.number = startNumber++;
		day5.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day6 = new Day();
		day6.name = "";
		day6.headline = "Heilsame Sachlichkeit";
		day6.number = startNumber++;
		day6.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day7 = new Day();
		day7.name = "";
		day7.headline = "Jeder soll darauf achten, wie er weiterbaut.";
		day7.number = startNumber++;
		day7.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day8 = new Day();
		day8.name = "";
		day8.headline = "Das Bild des Herrn";
		day8.number = startNumber++;
		day8.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day9 = new Day();
		day9.name = "";
		day9.headline = "Eucharistie im Alltag";
		day9.number = startNumber++;
		day9.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day10 = new Day();
		day10.name = "";
		day10.headline = "Göttliche Barmherzigkeit";
		day10.number = startNumber++;
		day10.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day11 = new Day();
		day11.name = "";
		day11.headline = "Gottesbeziehung";
		day11.number = startNumber++;
		day11.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		Day day12 = new Day();
		day12.name = "Zweiter Fastensonntag";
		day12.headline = "Sehnen und Suchen";
		day12.number = startNumber++;
		day12.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day13 = new Day();
		day13.name = "";
		day13.headline = "Ewigkeit und Zeit";
		day13.number = startNumber++;
		day13.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day14 = new Day();
		day14.name = "";
		day14.headline = "Meine Lebensregel?";
		day14.number = startNumber++;
		day14.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day15 = new Day();
		day15.name = "Hl. Josef";
		day15.headline = "Ich bin getauft…";
		day15.number = startNumber++;
		day15.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day16 = new Day();
		day16.name = "";
		day16.headline = "Sei besiegelt durch den Hl. Geist";
		day16.number = startNumber++;
		day16.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day17 = new Day();
		day17.name = "";
		day17.headline = "Zwischen Tiefe und Oberfläche";
		day17.number = startNumber++;
		day17.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day18 = new Day();
		day18.name = "";
		day18.headline = "Christsein im Alltag";
		day18.number = startNumber++;
		day18.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day19 = new Day();
		day19.name = "Dritter Fastensonntag";
		day19.headline = "Ausstrahlung";
		day19.number = startNumber++;
		day19.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day20 = new Day();
		day20.name = "";
		day20.headline = "Vorhöfe und Grenzen";
		day20.number = startNumber++;
		day20.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day21 = new Day();
		day21.name = "Verkündigung des Herrn";
		day21.headline = "Wenn Ihr fastet";
		day21.number = startNumber++;
		day21.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		Day day22 = new Day();
		day22.name = "";
		day22.headline = "Im bergenden Arm";
		day22.number = startNumber++;
		day22.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day23 = new Day();
		day23.name = "";
		day23.headline = "Lebensquell";
		day23.number = startNumber++;
		day23.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day24 = new Day();
		day24.name = "";
		day24.headline = "Gott, Du allein";
		day24.number = startNumber++;
		day24.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day25 = new Day();
		day25.name = "";
		day25.headline = "Zeit – Krankheit";
		day25.number = startNumber++;
		day25.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day26 = new Day();
		day26.name = "Vierter Fastensonntag";
		day26.headline = "Auf dem Weg zur Quelle";
		day26.number = startNumber++;
		day26.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day27 = new Day();
		day27.name = "";
		day27.headline = "Ich bin durchaus keine Heilige…";
		day27.number = startNumber++;
		day27.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day28 = new Day();
		day28.name = "";
		day28.headline = "Die Gesegnete vom Kreuz";
		day28.number = startNumber++;
		day28.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day29 = new Day();
		day29.name = "";
		day29.headline = "Nahrung für die Seele";
		day29.number = startNumber++;
		day29.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day30 = new Day();
		day30.name = "";
		day30.headline = "Aug' in Aug' mit Gott";
		day30.number = startNumber++;
		day30.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day31 = new Day();
		day31.name = "zufrieden mit dem Balken im Auge?";
		day31.headline = "";
		day31.number = startNumber++;
		day31.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		Day day32 = new Day();
		day32.name = "";
		day32.headline = "Boden unter den Füßen";
		day32.number = startNumber++;
		day32.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day33 = new Day();
		day33.name = "Fünfter Fastensonntag";
		day33.headline = "Du bist mein starker Gott";
		day33.number = startNumber++;
		day33.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day34 = new Day();
		day34.name = "";
		day34.headline = "Wege zur inneren Stille";
		day34.number = startNumber++;
		day34.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day35 = new Day();
		day35.name = "";
		day35.headline = "";
		day35.number = startNumber++;
		day35.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day36 = new Day();
		day36.name = "";
		day36.headline = "Bei Gott ist nichts unmöglich";
		day36.number = startNumber++;
		day36.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day37 = new Day();
		day37.name = "";
		day37.headline = "Ewige Liebe";
		day37.number = startNumber++;
		day37.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day38 = new Day();
		day38.name = "";
		day38.headline = "Ich muss immer wieder an die Königin Esther denken";
		day38.number = startNumber++;
		day38.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day39 = new Day();
		day39.name = "";
		day39.headline = "Wir lieben Gott und die Menschen mit ein und demselben Herzen";
		day39.number = startNumber++;
		day39.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day40 = new Day();
		day40.name = "Palmsonntag";
		day40.headline = "Hosanna!";
		day40.number = startNumber++;
		day40.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day41 = new Day();
		day41.name = "";
		day41.headline = "";
		day41.number = startNumber++;
		day41.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		Day day42 = new Day();
		day42.name = "";
		day42.headline = "Leben für die Ewigkeit";
		day42.number = startNumber++;
		day42.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day43 = new Day();
		day43.name = "";
		day43.headline = "Hingabe an den Willen Gottes";
		day43.number = startNumber++;
		day43.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day44 = new Day();
		day44.name = "Gründonnerstag";
		day44.headline = "Im Kreuz ist Heil";
		day44.number = startNumber++;
		day44.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day45 = new Day();
		day45.name = "Karfreitag";
		day45.headline = "Im Kreuz ist Leben";
		day45.number = startNumber++;
		day45.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day46 = new Day();
		day46.name = "Karsamstag";
		day46.headline = "Neues Leben nach und nach";
		day46.number = startNumber++;
		day46.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day47 = new Day();
		day47.name = "Ostersonntag";
		day47.headline = "Strahlend jubelt die Natur dem Auferstandenen";
		day47.number = startNumber++;
		day47.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		Day day48 = new Day();
		day48.name = "Ostermontag";
		day48.headline = "…und bliebe unser Herz brennend davon!";
		day48.number = startNumber++;
		day48.date = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		this.mDays = new Day[] { day1, day2, day3, day4, day5, day6, day7, day8, day9, day10,
				day11, day12, day13, day14, day15, day16, day17, day18, day19, day20,
				day21, day22, day23, day24, day25, day26, day27, day28, day29, day30,
				day31, day32, day33, day34, day35, day36, day37, day38, day39, day40,
				day41, day42, day43, day44, day45, day46, day47, day48,};
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).

			if (position == 0) {
				return new IntroFragment();
			}
			return DayFragment.newInstance(mDays[position - 1]);
		}

		@Override
		public int getCount() {
			return today + 1;
		}

	}

}
