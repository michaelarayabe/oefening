package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

import java.util.Arrays;

public class IceCreamApp {

    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList(10,20,25);
        IceCreamSeller iceCreamSeller = new IceCreamSalon(priceList);
        Eatable[] iceCreamsOrdered = new Eatable[0];

        iceCreamsOrdered = insertInToArray(iceCreamsOrdered,iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE));
        iceCreamsOrdered = insertInToArray(iceCreamsOrdered, iceCreamSeller.orderIceRocket());
        iceCreamsOrdered = insertInToArray(iceCreamsOrdered, iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA, Cone.Flavor.MOKKA}));


        for(Eatable x : iceCreamsOrdered){
            x.eat();
        }

        System.out.println("profit is: " + iceCreamSeller.getProfit() + " euros");

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
