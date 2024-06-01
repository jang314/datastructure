package chapter03;

import javax.naming.Name;

public class Ex02 {
    public static void main(String[] args) {
        SimpleList<NameCard> cards = new SimpleList<>(NameCard.class);
        NameCard cardA = new NameCard("김연희", "01012345678");
        NameCard cardB = new NameCard("장혜진", "01022223333");
        NameCard cardC = new NameCard("김한나", "01045670987");
        cards.LInsert(cardA);
        cards.LInsert(cardB);
        cards.LInsert(cardC);

        if(cards.LFirst()) {
            if(cards.getData().NameCompare(cardA)) {
                cards.getData().ShowNameCardInfo();
            }
        }
        while (cards.LNext()) {
            if(cards.getData().NameCompare(cardA)) {
                cards.getData().ShowNameCardInfo();
            }
        }


        if(cards.LFirst()) {
            if(cards.getData().NameCompare(cardB)) {
                cards.getData().ChanePhoneNum("01099999999");
            }
        }
        while (cards.LNext()) {
            if(cards.getData().NameCompare(cardB)) {
                cards.getData().ChanePhoneNum("01099999999");
            }
        }

        if(cards.LFirst()) {
            if(cards.getData().NameCompare(cardC)) {
                cards.LRemove();
            }
        }
        while (cards.LNext()) {
            if(cards.getData().NameCompare(cardC)) {
                cards.LRemove();
            }
        }

        if(cards.LFirst()) {
                cards.getData().ShowNameCardInfo();
        }
        while (cards.LNext()) {
                cards.getData().ShowNameCardInfo();
        }
    }

    static class NameCard {
        private String names = null;
        private String phones = null;

        public NameCard(String names, String phones) {
            this.names = names;
            this.phones = phones;
        }


        public void ShowNameCardInfo() {
            System.out.println("name = " + names + ", phone = " + phones);
        }

        public Boolean NameCompare(NameCard card) {
            return this.names.equals(card.names);
        }

        public void ChanePhoneNum(String phone) {
            this.phones = phone;
        }

    }

}
