package demo.texasholdem;

/**
 * Created by zxy94400 on 2016/5/8.
 */
public class CardUtils {

    public final static int CARD_NUMBER = 52;

    public final static int CARD_NUMBER_PER_TYPE = 13;

    public final static String[] cardNames = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A",};

    //heart spade diamond club
    public final static String[] cardTypes = {"h","s","d","c"};

    public final static int[] cardImageRes = {R.drawable.heart,
            R.drawable.spade,
            R.drawable.diamond,
            R.drawable.club};

    public static String getName(int position) {
        return getCardName(position) + getTypeName(position);
    }

    public static String getCardName(int position) {
        return cardNames[position % CARD_NUMBER_PER_TYPE];
    }

    public static String getTypeName(int position) {
        return cardTypes[position / CARD_NUMBER_PER_TYPE];
    }

    public static int getCardResource(int position) {
        return cardImageRes[position / CARD_NUMBER_PER_TYPE];
    }

}
