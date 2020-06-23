package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {

    PriceList priceList;
    Stock stock;
    double profit;

    public IceCreamCar(PriceList priceList, Stock stock){

        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) throws NoMoreIceCreamException {

        if(stock.getCones() == 0 && stock.getBalls() == 0 && stock.getIceRockets() == 0 && stock.getMagni() == 0){
            throw new NoMoreIceCreamException("We are out of stock!");
        } else if(stock.getCones() == 0 || stock.getBalls() < balls.length){
            throw new NoMoreIceCreamException("Not enough cones or balls!");
        }

        return prepareCone(balls);
    }

    private Cone prepareCone(Cone.Flavor[] balls){
        stock.setCones(stock.getCones() - 1);
        stock.setBalls(stock.getBalls() - balls.length);
        profit += priceList.getBallPrice() * balls.length;
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException{
        if(stock.getCones() == 0 && stock.getBalls() == 0 && stock.getIceRockets() == 0 && stock.getMagni() == 0) {
            throw new NoMoreIceCreamException("We are out of stock!");
        }else if(stock.getIceRockets() == 0){
            throw new NoMoreIceCreamException("No more raketijsjes available");
        }
        return prepareIceRocket();
    }

    private IceRocket prepareIceRocket(){
        stock.setIceRockets(stock.getIceRockets() - 1);
        profit += priceList.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        if(stock.getCones() == 0 && stock.getBalls() == 0 && stock.getIceRockets() == 0 && stock.getMagni() == 0) {
            throw new NoMoreIceCreamException("We are out of stock!");
        } else if(stock.getMagni() == 0){
            throw new NoMoreIceCreamException("No more magnum available");
        }
        return prepareMagnum(type);
    }

    private Magnum prepareMagnum(Magnum.MagnumType type){

        stock.setMagni(stock.getMagni() - 1);
        profit += priceList.getMagnumPrice(type) * type.getFactor();
        return new Magnum(type);
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
