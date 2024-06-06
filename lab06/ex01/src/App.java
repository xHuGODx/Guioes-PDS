 // to complete
 public class App {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");       // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        


        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");    // squared, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        


        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");           // 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        // you should add here other example(s) of CakeBuilder   
        
        //Benfica cake

        CakeBuilder Benfica = new BenficaCakeBuilder();
        cakeMaster.setCakeBuilder(Benfica);
        cakeMaster.createCake(Shape.Rectangular, 2, "Benfica ganha a liga por favor!");           // 2 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
    }
}