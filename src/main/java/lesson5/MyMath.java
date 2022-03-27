package lesson5;

public class MyMath {

    //1. Написать программу по возведению числа в степень с помощью рекурсии.
    public static double pow(int n, int m) {

        if (m < 0) {

            if (m == -1) return 1.0 / n * (m * -1);

            return (1.0 / n ) * pow(n, m + 1);

        } else if (m > 0) {

            if (m == 1) return n * m;

            return n * pow(n, m - 1);
        }

        return 1;
    }
}
