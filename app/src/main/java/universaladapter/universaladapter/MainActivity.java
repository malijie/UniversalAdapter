package universaladapter.universaladapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.universal.adapter.CommonAdapter;
import com.universal.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<TestItem> shareItemList = new ArrayList<>();
    private ListView mListView = null;
    private int[] mImageRes = {R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4,R.mipmap.image5,R.mipmap.image6,R.mipmap.image7,R.mipmap.image8,R.mipmap.image9,R.mipmap.image10,R.mipmap.image11,R.mipmap.image12,R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4,R.mipmap.image5,R.mipmap.image6,R.mipmap.image7,R.mipmap.image8,R.mipmap.image9,R.mipmap.image10,R.mipmap.image11,R.mipmap.image12};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.id_list);

        for(int i=0;i<24;i++){
            TestItem item = new TestItem();
            item.setId(i);
            item.setContent("test item content " + i);
            item.setImageRes(mImageRes[i]);
            shareItemList.add(item);
        }

        mListView.setAdapter(new CommonAdapter<TestItem>(this, shareItemList,R.layout.test_list_item) {
            @Override
            public void convert(ViewHolder holder, TestItem item) {
               holder.setText(R.id.id_item_title_text,item.getId()+ "");
               holder.setText(R.id.id_item_content_text,item.getContent());
               holder.setImageResId(R.id.id_item_image,item.getImageRes());
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this,"position=" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
