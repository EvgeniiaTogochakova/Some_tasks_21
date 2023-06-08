//Первый семинар. Домашнее задание
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i = new Random().nextInt(2001);
        System.out.println(i);
        String str = Integer.toBinaryString(i);
        System.out.println(str);
        int n = str.length();
        System.out.println(n + " - это номер старшего значащего бита");
        int maxShort = Short.MAX_VALUE;
        System.out.println(maxShort);

        int[] m1 = create_multiples(i, maxShort, n);
        System.out.println("Печатаю массив m1");

        for (int item : m1) {
            System.out.printf("%d ", item);
        }

        int minShort = Short.MIN_VALUE;
        System.out.println();
        System.out.println(minShort);

        int[] m2 = create_if_not_multiples(minShort, i, n);
        System.out.println("Печатаю массив m2");

        for (int item : m2) {
            System.out.printf("%d ", item);
        }
    }

    public static int[] create_multiples(int start, int finish, int what_number) {
        int[] array = {};
        for (int k = start; k <= finish; k++) {
            if (k % what_number == 0) array = append_this_num(array, k);
        }
        return array;
    }

    public static int[] create_if_not_multiples(int start, int finish, int what_number) {
        int[] array = {};
        for (int k = start; k <= finish; k++) {
            if (k % what_number != 0) array = append_this_num(array, k);
        }
        return array;
    }

    public static int[] append_this_num(int[] array, int num) {
        int[] temporary = new int[array.length + 1];
        for (int l = 0; l < array.length; l++) {
            temporary[l] = array[l];
        }
        array = temporary;
        array[array.length - 1] = num;
        return array;
    }
}
