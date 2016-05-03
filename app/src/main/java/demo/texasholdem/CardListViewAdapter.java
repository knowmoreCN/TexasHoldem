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

class CardListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Card> cards = new ArrayList<>();
    private int[] image = {R.drawable.heart,
            R.drawable.spade,
            R.drawable.diamond,
            R.drawable.club};

    public CardListViewAdapter(Context context) {
        this.context = context;
    }
//
//    public int getState(int position) {
//        if(position > data.length) {
//            System.err.println("do not have this");
//            return 0;
//        }
//        return data[position];
//    }

    public void changeDataState(List<Card> cards) {
        this.cards = cards;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return cards.size();
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
        Card card = cards.get(position);
        holder.tv.setText(card.getName());
        int index = 0;
        switch (card.getType()) {
            case HEART:     index= 0; break;
            case SPADE:     index= 1; break;
            case DIAMOND:   index= 2; break;
            case CLUB:      index= 3; break;
        }
        holder.img.setImageResource(image[index]);


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