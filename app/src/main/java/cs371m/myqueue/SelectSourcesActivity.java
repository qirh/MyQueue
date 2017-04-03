package cs371m.myqueue;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of using fragments to implement different activity layouts.
 * This sample provides a different layout (and activity flow) when run in
 * landscape.
 */
public class SelectSourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_source_layout);

        final Button continue_button = (Button) findViewById(R.id.sources_continue);
        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startActivity(new Intent(SelectSourcesActivity.this, screen2.class));
            }
        });

        Toolbar screen1Toolbar = (Toolbar)findViewById(R.id.screen1_toolbar);
        setSupportActionBar(screen1Toolbar);

}

            /**
             * This is the "top-level" fragment, showing a list of items that the
             * user can pick.  Upon picking an item, it takes care of displaying the
             * data to the user as appropriate based on the current UI layout.
             */

    public static class TitlesFragment extends ListFragment {

        int mCurCheckPosition = 0;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            String[] rawData = getResources().getStringArray(R.array.sources);
            List<String> sources = new ArrayList(Arrays.asList(rawData));

            // Populate list with our static array of titles.
            setListAdapter(new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,
                    sources));

            if (savedInstanceState != null) {
                // Restore last state for checked position.
                mCurCheckPosition
                        = savedInstanceState.getInt("curChoice", 0);
            }

            getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        }


        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putInt("curChoice", mCurCheckPosition);
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            addSource(position);
        }

        void addSource(int index) {
            mCurCheckPosition = index;

            // Not yet implemented, currently uses only Netflix automatically

        }
    }
}