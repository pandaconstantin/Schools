package org.project.school.schools;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPager;

public class MainActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int tabCount = 4;  //Nombre d'onglets

        this.mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        this.mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return SchoolRecycleViewer.newInstance();
            }

            @Override
            public int getCount() {
                return tabCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getResources().getString(R.string.accueilString);
                    case 1:
                        return getResources().getString(R.string.FormulaireString);
                    case 2:
                        return getResources().getString(R.string.List1);
                    case 3:
                        return getResources().getString(R.string.ListDetail);
                    default:
                        return "Page " + position;
                }
            }

            int oldItemPosition = -1;

            @Override
            public void setPrimaryItem(ViewGroup container, int position, Object object) {
                super.setPrimaryItem(container, position, object);


                if (oldItemPosition != position) {
                    oldItemPosition = position;
                    int color = Color.BLACK;

                    switch (position) {
                        case 0:
                            color = getResources().getColor(R.color.purple);
                            break;
                        case 1:
                            color = getResources().getColor(R.color.orange);
                            break;
                        case 2:
                            color = getResources().getColor(R.color.cyan);
                            break;
                        case 3:
                            color = getResources().getColor(R.color.green);
                            break;
                    }

                    int fadeDuration = 400;
                    mViewPager.setColor(color, fadeDuration);

                }

            }
        });

        this.mViewPager.getViewPager().setOffscreenPageLimit(tabCount);
        this.mViewPager.getPagerTitleStrip().setViewPager(this.mViewPager.getViewPager());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
