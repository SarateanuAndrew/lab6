package cars.mvc;

import cars.clients.StandardCar;
import cars.company.Departments;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    ModelInterface model = new Model();
    ViewInterface view = new View();

    public void display() {
        Random random = model.getRandom();
        Departments foodMarket = model.getFoodMarket();
        Departments gasStation = model.getGasStation();
        Departments mechanicalDepartment = model.getMechanicalDepartment();
        Departments washing = model.getWashing();
        Departments designDepartment = model.getDesignDepartment();
        List<StandardCar> cars = model.getCars();
        boolean cycle = true;
        Scanner scanner = model.getScanner();
        Map<Departments, Integer> map = model.getDepartmentsIntegerMap(foodMarket, gasStation, mechanicalDepartment, washing, designDepartment);
        int findCar;
        int gasQuantity, foodQuantity, piecesQuantity, showerQuantity, paintQuantity;
        int foodUse = 0, gasUse = 0, mechanicUse = 0, washUse = 0, paintUse = 0;
        int foodIncome = 0, gasIncome = 0, mechanicIncome = 0, washIncome = 0, paintIncome = 0;
        int isHappy = 0, isGood = 0, isNormal = 0, isMoody = 0, isSad = 0;
        int isHappy2 = 0, isGood2 = 0, isNormal2 = 0, isMoody2 = 0, isSad2 = 0;
        String stop;
        double totalSum = 0;
        double monthSum = 0;
        int daySum;
        int clients = 15;
        //Cycle Star
        for (int i = 1; cycle; i++) {
            daySum = 0;
            if (view.finish(clients)) break; //view
            findCar = random.nextInt(10, clients);
            view.dayCount(i);  //view
            for (int j = 1; j <= findCar; j++) {

                //Car declaring

                StandardCar car = model.getCar(random, cars);
                foodQuantity = model.getFoodQuantity(random);
                gasQuantity = model.getGasQuantity(random);
                piecesQuantity = model.getPiecesQuantity(random);
                showerQuantity = model.getShowerQuantity(random);
                paintQuantity = model.getPaintQuantity(random);
                if (model.necessitiesCheck(car)) {
                    view.carSetup(j, car);  //view

                    model.setCarMoney(random, car);


                    //Start doing car requirements
                    view.necessitiesSetUp(foodMarket, gasStation, mechanicalDepartment, washing, designDepartment, map, gasQuantity, foodQuantity, piecesQuantity, showerQuantity, paintQuantity, car); //view
                    if (model.foodCheck(foodMarket, map, foodQuantity, car)) {
                        model.foodBuy(foodMarket, map, foodQuantity, car);
                        foodUse = model.getFoodUse(foodUse);
                        daySum = model.getDayFood(foodMarket, foodQuantity, daySum);
                        foodIncome = model.getFoodIncome(foodMarket, foodQuantity, foodIncome);
                    }
                    if (model.gasCheck(gasStation, map, gasQuantity, car)) {
                        model.gasBuy(gasStation, map, gasQuantity, car);
                        daySum = model.getDayGas(gasStation, gasQuantity, daySum);
                        gasUse = model.getGasUse(gasUse);
                        gasIncome = model.getGasIncome(gasStation, gasQuantity, gasIncome);
                    }
                    if (model.piecesCheck(mechanicalDepartment, map, piecesQuantity, car)) {
                        model.piecesBuy(mechanicalDepartment, map, piecesQuantity, car);
                        daySum = model.getDayPieces(mechanicalDepartment, piecesQuantity, daySum);
                        mechanicUse = model.getMechanicUse(mechanicUse);
                        mechanicIncome = model.getMechanicIncome(mechanicalDepartment, piecesQuantity, mechanicIncome);
                    }
                    if (model.cleanCheck(washing, map, showerQuantity, car)) {
                        model.washBuy(washing, map, showerQuantity, car);
                        daySum = model.getDayWash(washing, showerQuantity, daySum);
                        washUse = model.getWashUse(washUse);
                        washIncome = model.getWashIncome(washing, showerQuantity, washIncome);
                    }
                    if (model.designCheck(designDepartment, map, paintQuantity, car)) {
                        model.designBuy(designDepartment, map, paintQuantity, car);
                        daySum = model.getDayPaint(daySum, paintQuantity * designDepartment.getPrice());
                        paintUse = model.getPaintUse(paintUse);
                        paintIncome = model.getPaintIncome(designDepartment, paintQuantity, paintIncome);
                    }

                    String service = car.Service();
                    System.out.println("@" + service);
                    if (model.isIs_happy(service)) {
                        isHappy += 1;
                    }
                    if (model.isIs_good(service)) {
                        isGood += 1;
                    }
                    if (model.isIs_normal(service)) {
                        isNormal += 1;
                    }
                    if (model.isIs_moody(service)) {
                        isMoody += 1;
                    }
                    if (model.isIs_sad(service)) {
                        isSad += 1;
                    }
                }
            }
            monthSum += daySum;

            if (model.monthCheck(i)) {
                view.monthResults(isHappy, isGood, isNormal, isMoody, isSad, monthSum, clients, i);  //view
                clients = model.getClients(isHappy, isMoody, isSad, clients);
                totalSum += monthSum;
                monthSum = 0;
                isHappy2 += isHappy;
                isGood2 += isGood;
                isNormal2 += isNormal;
                isMoody2 += isMoody;
                isSad2 += isSad;
                isHappy = 0;
                isGood = 0;
                isNormal = 0;
                isMoody = 0;
                isSad = 0;

                model.refreshResources(foodMarket, gasStation, mechanicalDepartment, washing, designDepartment, map);
                stop = view.getStringToFinish(scanner); //view
                if (model.isStop(stop)) {
                    view.totalResults(foodUse, gasUse, mechanicUse, washUse, paintUse, foodIncome, gasIncome, mechanicIncome, washIncome, paintIncome, totalSum, i);
                    List<Integer> integers1 = model.getUse(foodUse, gasUse, mechanicUse, washUse, paintUse);
                    List<Integer> integers2 = model.getIncome(foodIncome, gasIncome, mechanicIncome, washIncome, paintIncome);
                    view.moodTotalStatus(isHappy2, isGood2, isNormal2, isMoody2, isSad2, integers1, integers2); //view
                    cycle = false;
                }
            }
        }
    }
}
