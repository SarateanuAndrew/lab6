package cars.mvc;

import cars.clients.GoodCar;
import cars.clients.StandardCar;
import cars.clients.VipCars;
import cars.company.*;

import java.util.*;

public class Model implements ModelInterface{
    @Override
    public List<Integer> getIncome(int foodIncome, int gasIncome, int mechanicIncome, int washIncome, int paintIncome) {
        return new ArrayList<>(List.of(foodIncome, gasIncome, mechanicIncome, washIncome, paintIncome));
    }
    @Override
    public List<Integer> getUse(int foodUse, int gasUse, int mechanicUse, int washUse, int paintUse) {
        return new ArrayList<>(List.of(foodUse, gasUse, mechanicUse, washUse, paintUse));
    }
    @Override
    public void refreshResources(Departments foodMarket, Departments gasStation, Departments mechanicalDepartment, Departments washing, Departments designDepartment, Map<Departments, Integer> map) {
        map.put(foodMarket, 600);
        map.put(gasStation, 800);
        map.put(mechanicalDepartment, 100);
        map.put(washing, 600);
        map.put(designDepartment, 200);
    }
    @Override
    public int getClients(int isHappy, int isMoody, int isSad, int clients) {
        if (isHappy > 100) {
            clients += 2;
        } else if ((isSad >= 3) || (isMoody >= 5)) {
            clients -= 2;
        }
        if (clients > 20) {
        }
        return clients;
    }
    @Override
    public int getPaintIncome(Departments designDepartment, int paintQuantity, int paintIncome) {
        paintIncome += paintQuantity * designDepartment.getPrice();
        return paintIncome;
    }
    @Override
    public int getWashIncome(Departments washing, int showerQuantity, int washIncome) {
        washIncome += showerQuantity * washing.getPrice();
        return washIncome;
    }
    @Override
    public int getMechanicIncome(Departments mechanicalDepartment, int piecesQuantity, int mechanicIncome) {
        mechanicIncome += piecesQuantity * mechanicalDepartment.getPrice();
        return mechanicIncome;
    }
    @Override
    public int getGasIncome(Departments gasStation, int gasQuantity, int gasIncome) {
        gasIncome += gasQuantity * gasStation.getPrice();
        return gasIncome;
    }
    @Override
    public int getFoodIncome(Departments foodMarket, int foodQuantity, int foodIncome) {
        foodIncome += foodQuantity * foodMarket.getPrice();
        return foodIncome;
    }
    @Override
    public int getDayPaint(int daySum, int paintQuantity) {
        daySum += paintQuantity;
        return daySum;
    }
    @Override
    public int getDayWash(Departments washing, int showerQuantity, int daySum) {
        daySum += showerQuantity * washing.getPrice();
        return daySum;
    }
    @Override
    public int getDayPieces(Departments mechanicalDepartment, int piecesQuantity, int daySum) {
        daySum += piecesQuantity * mechanicalDepartment.getPrice();
        return daySum;
    }
    @Override
    public int getDayGas(Departments gasStation, int gasQuantity, int daySum) {
        daySum += gasQuantity * gasStation.getPrice();
        return daySum;
    }
    @Override
    public int getDayFood(Departments foodMarket, int foodQuantity, int daySum) {
        daySum += foodQuantity * foodMarket.getPrice();
        return daySum;
    }
    @Override
    public int getPaintUse(int paintUse) {
        paintUse += 1;
        return paintUse;
    }
    @Override
    public int getWashUse(int washUse) {
        washUse += 1;
        return washUse;
    }
    @Override
    public int getMechanicUse(int mechanicUse) {
        mechanicUse += 1;
        return mechanicUse;
    }
    @Override
    public int getGasUse(int gasUse) {
        gasUse += 1;
        return gasUse;
    }
    @Override
    public int getFoodUse(int foodUse) {
        foodUse += 1;
        return foodUse;
    }
    @Override
    public void designBuy(Departments designDepartment, Map<Departments, Integer> map, int paintQuantity, StandardCar car) {
        map.replace(designDepartment, map.get(designDepartment) - paintQuantity);
        ((VipCars) car).setTuning(1);
        car.setMoney(car.getMoney() - paintQuantity * designDepartment.getPrice());
    }
    @Override
    public void washBuy(Departments washing, Map<Departments, Integer> map, int showerQuantity, StandardCar car) {
        map.replace(washing, map.get(washing) - showerQuantity);
        car.setClean(1);
        car.setMoney(car.getMoney() - showerQuantity * washing.getPrice());
    }
    @Override
    public void piecesBuy(Departments mechanicalDepartment, Map<Departments, Integer> map, int piecesQuantity, StandardCar car) {
        map.replace(mechanicalDepartment, map.get(mechanicalDepartment) - piecesQuantity);
        car.setRepair(1);
        car.setMoney(car.getMoney() - piecesQuantity * mechanicalDepartment.getPrice());
    }
    @Override
    public void gasBuy(Departments gasStation, Map<Departments, Integer> map, int gasQuantity, StandardCar car) {
        map.replace(gasStation, map.get(gasStation) - gasQuantity);
        car.setFuel(1);
        car.setMoney(car.getMoney() - gasQuantity * gasStation.getPrice());
    }
    @Override
    public void foodBuy(Departments foodMarket, Map<Departments, Integer> map, int foodQuantity, StandardCar car) {
        map.replace(foodMarket, map.get(foodMarket) - foodQuantity);
        car.setFood(1);
        car.setMoney(car.getMoney() - foodQuantity * foodMarket.getPrice());
    }
    @Override
    public void setCarMoney(Random random, StandardCar car) {
        if (car.getClass().equals(VipCars.class)) {
            ((VipCars) car).setTuning(random.nextInt(0, 2));
            car.setMoney(random.nextInt(300, 500));
        } else if (car.getClass().equals(StandardCar.class)) {
            car.setMoney(random.nextInt(100, 300));
        } else {
            car.setMoney(random.nextInt(200, 400));
        }
    }
    @Override
    public int getPaintQuantity(Random random) {
        int paintQuantity;
        paintQuantity = random.nextInt(2, 5);
        return paintQuantity;
    }
    @Override
    public int getShowerQuantity(Random random) {
        int showerQuantity;
        showerQuantity = random.nextInt(3, 6);
        return showerQuantity;
    }
    @Override
    public int getPiecesQuantity(Random random) {
        int piecesQuantity;
        piecesQuantity = random.nextInt(1, 4);
        return piecesQuantity;
    }
    @Override
    public int getGasQuantity(Random random) {
        int gasQuantity;
        gasQuantity = random.nextInt(10, 15);
        return gasQuantity;
    }
    @Override
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
    @Override
    public Map<Departments, Integer> getDepartmentsIntegerMap(Departments foodMarket, Departments gasStation, Departments mechanicalDepartment, Departments washing, Departments designDepartment) {
        Map<Departments, Integer> map = new HashMap<>();
        map.put(foodMarket, 600);
        map.put(gasStation, 800);
        map.put(mechanicalDepartment, 100);
        map.put(washing, 600);
        map.put(designDepartment, 200);
        return map;
    }
    @Override
    public int getFoodQuantity(Random random) {
        int foodQuantity;
        foodQuantity = random.nextInt(2, 5);
        return foodQuantity;
    }
    @Override
    public StandardCar getCar(Random random, List<StandardCar> cars) {
        StandardCar car = cars.get(random.nextInt(cars.size()));
        car.setClean(random.nextInt(0, 2));
        car.setFood(random.nextInt(0, 2));
        car.setFuel(random.nextInt(0, 2));
        return car;
    }

    @Override
    public List<StandardCar> getCars() {
        return new ArrayList<>(List.of(new StandardCar(), new GoodCar(), new VipCars()));
    }
    @Override
    public Departments getDesignDepartment() {
        return new DesignDepartment(40);
    }
    @Override
    public Departments getWashing() {
        return new Washing(20);
    }
    @Override
    public Departments getMechanicalDepartment() {
        return new MechanicalDepartment(100);
    }
    @Override
    public Departments getGasStation() {
        return new GasStation(20);
    }
    @Override
    public Departments getFoodMarket() {
        return new FoodMarket(12);
    }
    @Override
    public Random getRandom() {
        return new Random();
    }
    @Override
    public boolean isStop(String stop) {
        return stop.equals("Stop");
    }
    @Override
    public boolean monthCheck(int i) {
        return i % 30 == 0;
    }
    @Override
    public boolean isIs_sad(String service) {
        return service.equals("Is sad");
    }
    @Override
    public boolean isIs_moody(String service) {
        return service.equals("Is moody");
    }
    @Override
    public boolean isIs_normal(String service) {
        return service.equals("Is normal");
    }
    @Override
    public boolean isIs_good(String service) {
        return service.equals("Is good");
    }
    @Override
    public boolean isIs_happy(String service) {
        return service.equals("Is Happy");
    }
    @Override
    public boolean necessitiesCheck(StandardCar car) {
        return car.getFood() == 0 || car.getFuel() == 0 || car.getRepair() == 0 || car.getClean() == 0;
    }
    @Override
    public boolean designCheck(Departments designDepartment, Map<Departments, Integer> map, int paintQuantity, StandardCar car) {
        return car.getClass().equals(VipCars.class) && ((VipCars) car).getTuning() == 0 && map.get(designDepartment) > 0 && car.getMoney() >= (paintQuantity * designDepartment.getPrice());
    }
    @Override
    public boolean cleanCheck(Departments washing, Map<Departments, Integer> map, int showerQuantity, StandardCar car) {
        return car.getClean() == 0 && map.get(washing) > 0 && car.getMoney() >= (showerQuantity * washing.getPrice());
    }
    @Override
    public boolean piecesCheck(Departments mechanicalDepartment, Map<Departments, Integer> map, int piecesQuantity, StandardCar car) {
        return car.getRepair() == 0 && map.get(mechanicalDepartment) > 0 && car.getMoney() >= (piecesQuantity * mechanicalDepartment.getPrice());
    }
    @Override
    public boolean gasCheck(Departments gasStation, Map<Departments, Integer> map, int gasQuantity, StandardCar car) {
        return car.getFuel() == 0 && map.get(gasStation) > 0 && car.getMoney() >= (gasQuantity * gasStation.getPrice());
    }
    @Override
    public boolean foodCheck(Departments foodMarket, Map<Departments, Integer> map, int foodQuantity, StandardCar car) {
        return car.getFood() == 0 && map.get(foodMarket) > 0 && car.getMoney() >= (foodQuantity * foodMarket.getPrice());
    }
}
