import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundNumber(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundNumber(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundNumber(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void printResult() {
        int amount;
        int period;
        int depositType;
        double depositResult = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            depositResult = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            depositResult = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositResult);
    }
// Правила красивого кода от Яндекс рекомендуют "При расстановке фигурных скобок мы будем использовать стиль “K&R”"
// Лучше чтобы скобки в этом коде были на разных строках

    public static void main(String[] args) {
        new DepositCalculator().printResult();
    }


}
