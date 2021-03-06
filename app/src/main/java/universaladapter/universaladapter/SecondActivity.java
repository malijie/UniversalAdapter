package universaladapter.universaladapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.universal.adapter.CommonAdapter;
import com.universal.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private List<TestItem> shareItemList = new ArrayList<>();
    private ListView mListView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.id_list);

        for(int i=28;i>0;i--){
            TestItem item = new TestItem();
            item.setId(i);
            shareItemList.add(item);
        }

        mListView.setAdapter(new CommonAdapter<TestItem>(this, shareItemList,R.layout.test_list_item) {
            @Override
            public void convert(ViewHolder holder, TestItem item) {
               holder.setText(R.id.id_item_title_text,item.getId()+ "");
            }
        });
    }
}
