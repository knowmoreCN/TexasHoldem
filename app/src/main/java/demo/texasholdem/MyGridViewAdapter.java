package demo.texasholdem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    /**
     * 52张牌 1为显示，2为不显示
     * 顺序 红黑方梅
     */
    private int[] data = new int[52];

    public MyGridViewAdapter(Context context) {
        this.context = context;
    }

    public int getState(int position) {
        if(position > data.length) {
            System.err.println("do not have this");
            return 0;
        }
        return data[position];
    }

    public void changeDataState(int[] data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return data.length;
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


            convertView = LayoutInflater.from(context).inflate(R.layout.gridinfo, null);
            holder = new Holder();
            holder.tv = (TextView) convertView.findViewById(R.id.name);
            holder.img = (ImageView) convertView.findViewById(R.id.type);

            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(CardUtils.cardNames[position % 13]);
        holder.img.setImageResource(CardUtils.cardImageRes[position / 13]);

        if(data[position] == 0) {
            holder.tv.setVisibility(View.VISIBLE);
            holder.img.setVisibility(View.VISIBLE);
        } else {
            holder.tv.setVisibility(View.INVISIBLE);
            holder.img.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    private class Holder {

        TextView tv = null;
        ImageView img = null;

        public TextView getTv() {
            return tv;
        }

        public void setTv(TextView tv) {
            this.tv = tv;
        }

        public ImageView getImg() {
            return img;
        }

        public void setImg(ImageView img) {
            this.img = img;
        }

    }
}