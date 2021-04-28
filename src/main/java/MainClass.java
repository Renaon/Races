import java.util.ArrayList;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        ArrayList<Thread> bag = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        Car.createLoad();
        for (int i = 0; i < cars.length; i++) {
            bag.add(new Thread(cars[i]));
            bag.get(i).start();
        }

        for (int i = 0; i < cars.length; i++){
            bag.get(i).join();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

