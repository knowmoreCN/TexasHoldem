package demo.texasholdem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ResultListViewAdapter extends BaseAdapter{

    private List<String> result = new ArrayList<>();
    private Context context;

    public ResultListViewAdapter(Context context) {
        this.context = context;


        result.add("0");
    }

    public void showResult(List<String> result) {
        this.result = result;
        notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = new TextView(context);
            holder = new Holder();
            holder.tv = (TextView) convertView;

            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(result.get(position) + " %");


        return convertView;
    }

    private class Holder {

        TextView tv = null;

        public TextView getTv() {
            return tv;
        }

        public void setTv(TextView tv) {
            this.tv = tv;
        }

    }
}
