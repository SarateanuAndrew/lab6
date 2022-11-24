package cars.mvc;

import cars.clients.StandardCar;
import cars.clients.VipCars;
import cars.company.Departments;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View implements ViewInterface {
    @Override
    public boolean finish(int clients) {
        if (clients <= 0) {
            System.out.println("We have less clients than normal you lost");
            return true;
        }
        return false;
    }

    @Override
    public void dayCount(int i) {
        System.out.println("_____________");
        System.out.println(i + ". Day ");
    }

    @Override
    public void carSetup(int j, StandardCar car) {
        if (car.getClass().equals(VipCars.class)) {
            System.out.println(j + ". Vip Car ");
        } else if (car.getClass().equals(StandardCar.class)) {
            System.out.println(j + ". Standard Car");
        } else {
            System.out.println(j + ". Good Car");
        }
    }

    @Override
    public void necessitiesSetUp(Departments foodMarket, Departments gasStation, Departments mechanicalDepartment, Departments washing, Departments designDepartment, Map<Departments, Integer> map, int gasQuantity, int foodQuantity, int piecesQuantity, int showerQuantity, int paintQuantity, StandardCar car) {
        if (car.getFood() == 0 && map.get(foodMarket) > 0 && car.getMoney() >= (foodQuantity * foodMarket.getPrice())) {
            System.out.println("    Buy food: " + foodQuantity);
        }
        if (car.getFuel() == 0 && map.get(gasStation) > 0 && car.getMoney() >= (gasQuantity * gasStation.getPrice())) {
            System.out.println("    Buy fuel: " + gasQuantity);
        }
        if (car.getRepair() == 0 && map.get(mechanicalDepartment) > 0 && car.getMoney() >= (piecesQuantity * mechanicalDepartment.getPrice())) {
            System.out.println("    Need repair using: " + piecesQuantity);
        }
        if (car.getClean() == 0 && map.get(washing) > 0 && car.getMoney() >= (showerQuantity * washing.getPrice())) {
            System.out.println("    Need washing with: " + showerQuantity);
        }
        if (car.getClass().equals(VipCars.class) && ((VipCars) car).getTuning() == 0 && map.get(designDepartment) > 0 && car.getMoney() >= (paintQuantity * designDepartment.getPrice())) {
            System.out.println("    Need coloured: " + paintQuantity);
        }
    }

    @Override
    public void monthResults(int isHappy, int isGood, int isNormal, int isMoody, int isSad, double monthSum, int clients, int i) {
        System.out.println("******************************");
        System.out.println(i / 30 + ". Month");
        System.out.println("The month income: " + monthSum);
        System.out.println("The month medium income: " + monthSum / 30);

        System.out.println("Clients Status");
        System.out.println("Happy: " + isHappy);
        System.out.println("Good: " + isGood);
        System.out.println("Normal: " + isNormal);
        System.out.println("Moody: " + isMoody);
        System.out.println("Sad: " + isSad);

        if (isHappy > 100) {
            System.out.println("We had a productive month may be next month we will have more clients");
        } else if ((isSad >= 3) || (isMoody >= 5)) {
            System.out.println("We had a less productive month may be next month we will have less clients");
        }
        if (clients > 20) {
            System.out.println("We have  more with 25% of clients your business is successful ");
        }
    }

    @Override
    public String getStringToFinish(Scanner scanner) {
        String stop;
        System.out.println("******************************");

        //Stop & Final Function
        System.out.print("Tap \"Stop\" to finish: ");
        stop = scanner.next();
        return stop;
    }

    @Override
    public void moodTotalStatus(int isHappy2, int isGood2, int isNormal2, int isMoody2, int isSad2, List<Integer> integers1, List<Integer> integers2) {
        System.out.println("The least used is: " + integers1.stream().min(Integer::compareTo).orElseThrow());
        System.out.println("The smallest income is: " + integers2.stream().min(Integer::compareTo).orElseThrow());

        System.out.println("The most used is: " + integers1.stream().max(Integer::compareTo).orElseThrow());
        System.out.println("The biggest income is: " + integers2.stream().max(Integer::compareTo).orElseThrow());
        System.out.println("Clients Final Status");
        System.out.println("Happy: " + isHappy2);
        System.out.println("Good: " + isGood2);
        System.out.println("Normal: " + isNormal2);
        System.out.println("Moody: " + isMoody2);
        System.out.println("Sad: " + isSad2);

        System.out.println("####################################################################");
    }

    @Override
    public void totalResults(int foodUse, int gasUse, int mechanicUse, int washUse, int paintUse, int foodIncome, int gasIncome, int mechanicIncome, int washIncome, int paintIncome, double totalSum, int i) {
        System.out.println("####################################################################");

        System.out.println("The total income: " + totalSum);
        System.out.println("The medium income: " + totalSum / (i / 30));
        System.out.println("The number of cars that need food " + foodUse + " with income of " + foodIncome);
        System.out.println("The number of cars that need fuel " + gasUse + " with income of " + gasIncome);
        System.out.println("The number of cars that need mechanic " + mechanicUse + " with income of " + mechanicIncome);
        System.out.println("The number of cars that need washing " + washUse + " with income of " + washIncome);
        System.out.println("The number of cars that need painting " + paintUse + " with income of " + paintIncome);
    }
}
