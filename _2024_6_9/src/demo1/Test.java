package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/9  21:07
 */
public class Test {
    public static void main(String[] args) {
        CardDemo cardDemo=new CardDemo();
        List<Card> cards=cardDemo.buyCards();

        System.out.println(cards);
        cardDemo.shuffle(cards);
        for (Card c :
                cards) {
            System.out.println(c);
        }
        List<List<Card>> ret=cardDemo.play(cards);
        System.out.println(ret);

        System.out.println(cards.size());
        System.out.println(cards);
    }
}
