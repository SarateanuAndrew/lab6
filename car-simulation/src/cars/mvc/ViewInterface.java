package cars.mvc;

import cars.clients.StandardCar;
import cars.company.Departments;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface ViewInterface {
    boolean finish(int clients);

    void dayCount(int i);

    void carSetup(int j, StandardCar car);

    void necessitiesSetUp(Departments foodMarket, Departments gasStation, Departments mechanicalDepartment, Departments washing, Departments designDepartment, Map<Departments, Integer> map, int gasQuantity, int foodQuantity, int piecesQuantity, int showerQuantity, int paintQuantity, StandardCar car);

    void monthResults(int isHappy, int isGood, int isNormal, int isMoody, int isSad, double monthSum, int clients, int i);

    String getStringToFinish(Scanner scanner);

    void moodTotalStatus(int isHappy2, int isGood2, int isNormal2, int isMoody2, int isSad2, List<Integer> integers1, List<Integer> integers2);

    void totalResults(int foodUse, int gasUse, int mechanicUse, int washUse, int paintUse, int foodIncome, int gasIncome, int mechanicIncome, int washIncome, int paintIncome, double totalSum, int i);
}
