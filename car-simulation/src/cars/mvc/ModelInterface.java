package cars.mvc;

import cars.clients.StandardCar;
import cars.company.Departments;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public interface ModelInterface {
    List<Integer> getIncome(int foodIncome, int gasIncome, int mechanicIncome, int washIncome, int paintIncome);

    List<Integer> getUse(int foodUse, int gasUse, int mechanicUse, int washUse, int paintUse);

    void refreshResources(Departments foodMarket, Departments gasStation, Departments mechanicalDepartment, Departments washing, Departments designDepartment, Map<Departments, Integer> map);

    int getClients(int isHappy, int isMoody, int isSad, int clients);

    int getPaintIncome(Departments designDepartment, int paintQuantity, int paintIncome);

    int getWashIncome(Departments washing, int showerQuantity, int washIncome);

    int getMechanicIncome(Departments mechanicalDepartment, int piecesQuantity, int mechanicIncome);

    int getGasIncome(Departments gasStation, int gasQuantity, int gasIncome);

    int getFoodIncome(Departments foodMarket, int foodQuantity, int foodIncome);

    int getDayPaint(int daySum, int paintQuantity);

    int getDayWash(Departments washing, int showerQuantity, int daySum);

    int getDayPieces(Departments mechanicalDepartment, int piecesQuantity, int daySum);

    int getDayGas(Departments gasStation, int gasQuantity, int daySum);

    int getDayFood(Departments foodMarket, int foodQuantity, int daySum);

    int getPaintUse(int paintUse);

    int getWashUse(int washUse);

    int getMechanicUse(int mechanicUse);

    int getGasUse(int gasUse);

    int getFoodUse(int foodUse);

    void designBuy(Departments designDepartment, Map<Departments, Integer> map, int paintQuantity, StandardCar car);

    void washBuy(Departments washing, Map<Departments, Integer> map, int showerQuantity, StandardCar car);

    void piecesBuy(Departments mechanicalDepartment, Map<Departments, Integer> map, int piecesQuantity, StandardCar car);

    void gasBuy(Departments gasStation, Map<Departments, Integer> map, int gasQuantity, StandardCar car);

    void foodBuy(Departments foodMarket, Map<Departments, Integer> map, int foodQuantity, StandardCar car);

    void setCarMoney(Random random, StandardCar car);


    int getPaintQuantity(Random random);

    int getShowerQuantity(Random random);

    int getPiecesQuantity(Random random);

    int getGasQuantity(Random random);

    Scanner getScanner();

    Map<Departments, Integer> getDepartmentsIntegerMap(Departments foodMarket, Departments gasStation, Departments mechanicalDepartment, Departments washing, Departments designDepartment);

    int getFoodQuantity(Random random);

    StandardCar getCar(Random random, List<StandardCar> cars);

    List<StandardCar> getCars();

    Departments getDesignDepartment();

    Departments getWashing();

    Departments getMechanicalDepartment();

    Departments getGasStation();

    Departments getFoodMarket();

    Random getRandom();

    boolean isStop(String stop);


    boolean monthCheck(int i);

    boolean isIs_sad(String service);

    boolean isIs_moody(String service);

    boolean isIs_normal(String service);

    boolean isIs_good(String service);

    boolean isIs_happy(String service);

    boolean necessitiesCheck(StandardCar car);

    boolean designCheck(Departments designDepartment, Map<Departments, Integer> map, int paintQuantity, StandardCar car);

    boolean cleanCheck(Departments washing, Map<Departments, Integer> map, int showerQuantity, StandardCar car);

    boolean piecesCheck(Departments mechanicalDepartment, Map<Departments, Integer> map, int piecesQuantity, StandardCar car);

    boolean gasCheck(Departments gasStation, Map<Departments, Integer> map, int gasQuantity, StandardCar car);

    boolean foodCheck(Departments foodMarket, Map<Departments, Integer> map, int foodQuantity, StandardCar car);
}
