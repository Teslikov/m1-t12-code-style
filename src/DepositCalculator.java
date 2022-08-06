import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().getDataForDepositCalculator();
    }

    double calculateComplexPercent(double deposit, double yearRate, int depositPeriod) {
        double payments = deposit * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundResult(payments, 2);
    }

    double calculateSimplePercent(double deposit, double yearRate, int depositPeriod) {
        return roundResult(deposit + deposit * yearRate * depositPeriod, 2);
    }

    double roundResult(double payments, int places) {
        double scale = Math.pow(10, places);
        return Math.round(payments * scale) / scale;
    }

    void getDataForDepositCalculator() {
        int depositPeriod;
        int command;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        command = scanner.nextInt();

        double amountOfPayments = 0;

        if (command == 1) {
            amountOfPayments = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (command == 2) {
            amountOfPayments = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + amountOfPayments);
    }
}
