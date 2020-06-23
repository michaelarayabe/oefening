package be.intecbrussel.application;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {

    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList(10,20,25);
        Stock stock = new Stock();

        stock.setIceRockets(1);

        IceCreamSeller iceCreamSellerCar = new IceCreamCar(priceList, stock);
        Eatable[] iceCreamsOrdered = new Eatable[0];

        //Order one
        iceCreamsOrdered = insertInToArray(iceCreamsOrdered, iceCreamSellerCar.orderIceRocket());

        //Order two
        iceCreamsOrdered = insertInToArray(iceCreamsOrdered, iceCreamSellerCar.orderIceRocket());

        for(Eatable x : iceCreamsOrdered){
            x.eat();
        }

        System.out.println("profit is: " + iceCreamSellerCar.getProfit() + " euros");

    }

    private static Eatable[] insertInToArray(Eatable[] iceCreamsOrdered, Eatable iceCream){

        Eatable[] tempArray = new Eatable[iceCreamsOrdered.length + 1];

        int x = 0;
        while(x < iceCreamsOrdered.length){
            tempArray[x] = iceCreamsOrdered[x];
            x++;
        }

        tempArray[iceCreamsOrdered.length] = iceCream;
        return tempArray;
    }
}
