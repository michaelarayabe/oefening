package be.intecbrussel.eatables;

public class Cone implements Eatable {

    private Flavor[] balls;

    public Cone(){

    }

    public Cone(Flavor[] balls){

        this.balls = balls;
    }


    public enum Flavor{
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        MOKKA,
        PISTACHE
    }



    @Override
    public void eat() {

        System.out.println("I am eating . . . ");

        for(int i = 0; i < balls.length; i++){
            if(i == 0 && balls.length == 1) {
                System.out.println(" " + balls[i]);
            } else if(i == balls.length - 1){
                System.out.println(" " + balls[i]);
            } else if(i == balls.length - 2){
                System.out.println(" " + balls[i]);
            }else{
                System.out.println(" " + balls[i]);
            }
        }
    }
}
