package demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/9  21:07
 */
public class CardDemo {
    private String[] suits={"♥","♠","♣","♦"};
    //买牌
    public List<Card> buyCards(){
        List<Card> ret= new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String rank= "A";
            String suit=suits[i];
            Card card=new Card(suit,rank);
            ret.add(card);
        }
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                String rank= i+"";
                String suit=suits[j];
                Card card=new Card(suit,rank);
                ret.add(card);
            }
        }

        for (int i = 0; i < 4; i++) {
            String rank= "J";
            String suit=suits[i];
            Card card=new Card(suit,rank);
            ret.add(card);
        }
        for (int i = 0; i < 4; i++) {
            String rank= "Q";
            String suit=suits[i];
            Card card=new Card(suit,rank);
            ret.add(card);
        }
        for (int i = 0; i < 4; i++) {
            String rank= "K";
            String suit=suits[i];
            Card card=new Card(suit,rank);
            ret.add(card);
        }
        return ret;
    }

    public void swap(List<Card> cards,int i,int j){
        Card tmp=cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j,tmp);
    }
    //洗牌
    public void shuffle(List<Card> cards){
        Random random=new Random();
        for (int i = cards.size()-1; i >0 ; i--) {
            int r=random.nextInt(i);
            swap(cards,i,r);
        }
    }

    //三个人拿五张牌
    public List<List<Card>> play(List<Card> cards){
        List<List<Card>> ret=new ArrayList<>();
        List<Card> p1=new ArrayList<>();
        List<Card> p2=new ArrayList<>();
        List<Card> p3=new ArrayList<>();
        ret.add(p1);
        ret.add(p2);
        ret.add(p3);
        //拿牌
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < 3; j++) {
                Card card=cards.remove(0);
                ret.get(j).add(card);
            }
        }
        return ret;
    }

}
