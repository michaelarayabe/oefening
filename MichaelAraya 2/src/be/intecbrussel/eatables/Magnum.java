package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    MagnumType type;

    public Magnum(){

    }

    public Magnum(MagnumType type){

        this.type = type;
    }



    public enum MagnumType{
        MILKCHOCOLATE(2.5),
        WHITECHOCOLATE(2.0),
        BLACKCHOCOLATE(3.0),
        ALPINENUTS(1.5),
        ROMANTICSTRAWBERRIES(5.0);

        private double factor;

        MagnumType(double factor){
            this.factor = factor;
        }

        public double getFactor(){
            return factor;
        }
    }


    public MagnumType getType() {
        return type;
    }

    @Override
    public void eat() {

        System.out.println("I am eating . . . " + getType() + "magnum" );
    }
}
