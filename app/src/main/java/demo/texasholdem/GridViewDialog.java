package demo.texasholdem;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by zxy94400 on 2016/5/2.
 */
public class GridViewDialog extends Dialog implements AdapterView.OnItemClickListener {

    GridView gridView;
    MyGridViewAdapter gridViewAdapter;
    Context context;

    public GridViewDialog(Context context) {
        super(context);
        this.context = context;
    }

    public GridViewDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected GridViewDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);


        gridView = (GridView) findViewById(R.id.gridView);
        gridViewAdapter = new MyGridViewAdapter(context);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(this);
    }

    public int getPosition() {
        return position;
    }

    private int position;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.position = position;
        dismiss();
    }
}
