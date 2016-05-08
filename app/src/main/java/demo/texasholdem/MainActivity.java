package demo.texasholdem;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import demo.texasholdem.poker.Equity;
import demo.texasholdem.poker.EquityUtil;
import demo.texasholdem.poker.MEquity;
import demo.texasholdem.poker.Poker;
import demo.texasholdem.poker.impl.HEPoker;

public class MainActivity extends Activity {


    GridViewDialog mDialog;

    Button boardcard1;
    Button boardcard2;
    Button boardcard3;
    Button boardcard4;
    Button boardcard5;

    Button handcard1;
    Button handcard2;


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


        boardcard1 = (Button) findViewById(R.id.boardcard1);
        boardcard2 = (Button) findViewById(R.id.boardcard2);
        boardcard3 = (Button) findViewById(R.id.boardcard3);
        boardcard4 = (Button) findViewById(R.id.boardcard4);
        boardcard5 = (Button) findViewById(R.id.boardcard5);

        handcard1 = (Button) findViewById(R.id.handcard1);
        handcard2 = (Button) findViewById(R.id.handcard2);



    }

    public String getButtonText(Button button) {

        String text = (String) button.getText();

        if(text != null && text.length() > 0) {
            return text;
        }

        return null;
    }


    public void calculate(View view) {

        List<String> result = new ArrayList<>();

        List<String> board = new ArrayList<>();
        String text = getButtonText(boardcard1);
        if(text != null)
            board.add(text);
        text = getButtonText(boardcard2);
        if(text != null)
            board.add(text);
        text = getButtonText(boardcard3);
        if(text != null)
            board.add(text);
        text = getButtonText(boardcard4);
        if(text != null)
            board.add(text);
        text = getButtonText(boardcard5);
        if(text != null)
            board.add(text);


        List<String[]> cards = new ArrayList<>();

        String hand1 = getButtonText(handcard1);
        String hand2 = getButtonText(handcard2);
        if(hand1 != null && hand2 != null) {

            cards.add(new String[]{hand1,hand2});
        } else {
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


    private String[] types = {"h","s","d","c"};

    public void onCardClick(final View view) {
//        view.setBackgroundResource(R.drawable.heart);

        mDialog.show();
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                int position = mDialog.getPosition();
                //小于0 表示点击不正确
                if(position >= 0) {
                    String text = CardUtils.getName(position);
                    ((Button) view).setText(text);
                    view.setBackgroundResource(CardUtils.getCardResource(position));
                }
            }
        });

    }
}




