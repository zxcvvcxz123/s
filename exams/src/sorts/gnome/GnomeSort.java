package sorts.gnome;

import static sorts.Utils.printArray;

public class GnomeSort {

    public static int[] gnomeSort(int[] array) {
        // Инициализация позиции гнома
        int gnomePosition = 0;

        // Пока гном не достиг конца массива
        while (gnomePosition < array.length) {
            // Если гном находится в начале массива или предыдущий элемент меньше или равен текущему,
            // гном делает шаг вперед
            if (gnomePosition == 0 || array[gnomePosition - 1] <= array[gnomePosition]) {
                gnomePosition++;
            } else {
                // Иначе, гном меняет местами текущий и предыдущий элементы
                // и делает шаг назад
                int temp = array[gnomePosition];
                array[gnomePosition] = array[gnomePosition - 1];
                array[gnomePosition - 1] = temp;
                gnomePosition--;
            }
        }

        // Возвращаем отсортированный массив
        return array;
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Данный массив");
        printArray(array);

        gnomeSort(array);

        System.out.println("\nОтсортированный массив");
        printArray(array);
    }
}
