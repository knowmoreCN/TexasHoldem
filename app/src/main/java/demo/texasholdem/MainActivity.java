package demo.texasholdem;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import demo.texasholdem.poker.Equity;
import demo.texasholdem.poker.EquityUtil;
import demo.texasholdem.poker.MEquity;
import demo.texasholdem.poker.Poker;
import demo.texasholdem.poker.impl.HEPoker;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {


    GridViewDialog mDialog;

    GridView boardview;
    CardListViewAdapter boardAdapter;

    GridView handview;
    CardListViewAdapter handAdapter;


    ListView resultview;
    ResultListViewAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {

        mDialog = new GridViewDialog(this);


        resultview = (ListView) findViewById(R.id.resultlist);
        resultview.setClickable(false);
        resultAdapter = new ResultListViewAdapter(this);
        resultview.setAdapter(resultAdapter);


        /*List<Card> boardCard = new ArrayList<>();
        boardCard.add(new Card());
        boardCard.add(new Card());
        boardCard.add(new Card());
        boardCard.add(new Card());
        boardCard.add(new Card());
        boardview = (GridView) findViewById(R.id.boardList);
        boardview.setClickable(false);
        boardAdapter = new CardListViewAdapter(this);
        boardview.setAdapter(boardAdapter);
        boardAdapter.changeDataState(boardCard);

        List<Card> handCard = new ArrayList<>();
        handCard.add(new Card());
        handCard.add(new Card());
        handview = (GridView) findViewById(R.id.handList);
        handview.setClickable(false);
        handAdapter = new CardListViewAdapter(this);
        handview.setAdapter(handAdapter);
        handAdapter.changeDataState(handCard);*/

    }

    private String[] names = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A",};
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text =  names[position % 13];
    }

    public void calculate(View view) {

        List<String> result = new ArrayList<>();

        List<String> board = new ArrayList<>();
        board.add("4s");
        board.add("2s");
        board.add("7s");

        List<String[]> cards = new ArrayList<>();
//        collectCards(cards, cardPanels);
        cards.add(new String[]{"Th","Jh"});
        cards.add(new String[]{"6d","8s"});

        if (cards.size() == 0) {
            System.out.println("no hands");
            return;
        }

        final List<String> blockers = new ArrayList<>();
        int draws = 0;

        Poker poker = new HEPoker( 2 >2 ,false);

        final MEquity[] meqs = poker.equity(board, cards, blockers, draws);

        for (int i = 0; i < meqs.length; i++) {
            MEquity me = meqs[i];
            for (int n = 0; n < me.eqs.length; n++) {
                Equity e = me.eqs[n];
                String et = String.format("Win: %.1f%%", e.won);
                System.out.print(et);

                String[] names = EquityUtil.getRankNames(e.type);
                for (int k = 0; k < names.length; k++) {
                    String res = String.format("%s: %.0f", names[k], e.wonrank[k]);
                    System.out.print(res + " ");
                    result.add(res);
                }
            }
            System.out.println("");
        }

        resultAdapter.showResult(result);
    }

    public void onCardClick(final View view) {
        view.setBackgroundResource(R.drawable.heart);

        mDialog.show();
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                int position = mDialog.getPosition();
                String text =  names[position % 13];
                ((Button)view).setText(text);
            }
        });

    }
}




