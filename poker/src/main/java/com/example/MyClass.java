package com.example;

import java.util.ArrayList;
import java.util.List;

import demo.texasholdem.poker.Equity;
import demo.texasholdem.poker.EquityUtil;
import demo.texasholdem.poker.MEquity;
import demo.texasholdem.poker.Poker;
import demo.texasholdem.poker.impl.HEPoker;

public class MyClass {

    public static void main (String[] args) {
        String[] str = Poker.deck();

        //洗牌
//        ArrayUtil.shuffle(str, new Random());
//        for(int i =0;i<str.length;i++)
//            System.out.println(str[i] + " ");

        calc();
    }


    /** calc button pressed */
    protected static void calc() {
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

//        final List<String> blockers = blockersCardPanel.getCards();
        final List<String> blockers = new ArrayList<>();
//        final PokerItem pokerItem = (PokerItem) pokerCombo.getSelectedItem();
        int draws = 0;
//        if (drawsSpinner != null) {
//            draws = ((SpinnerNumberModel) drawsSpinner.getModel()).getNumber().intValue();
//        }

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
                }
//                AllPanels p = panels[n];
//                p.setBorder(e.curwin ? new LineBorder(Color.green) : e.curtie ? new LineBorder(Color.yellow) : null);
//                p.equityPanel.setEquity(e);
//                p.equityPanel.setVisible(true);
//                p.rankPanel.setEquity(e);
//                p.rankPanel.setVisible(true);
//                p.outsPanel.setEquity(e, me.remCards);
            }
            System.out.println("");
////            cardPanels.get(n).setEquity(meqs[n]);
        }

    }

}
