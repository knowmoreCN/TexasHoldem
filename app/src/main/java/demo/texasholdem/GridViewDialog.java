package demo.texasholdem;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
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

    @Override
    protected void onStart() {
        super.onStart();
        //初始化位置为-1，防止进入点击窗口外面消失的情况
        position = -1;
    }

    public int getPosition() {
        return position;
    }

    private int position;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(gridViewAdapter.getState(position) != 0) {
            //had been choosen
            this.position = -1;
            dismiss();
            return;
        }
        this.position = position;
        gridViewAdapter.changeDateState(position,1);
        dismiss();
    }
}
