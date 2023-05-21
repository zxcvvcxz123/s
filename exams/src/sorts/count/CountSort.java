package sorts.count;

import static sorts.Utils.getMaxValue;
import static sorts.Utils.printArray;

public class CountSort {

    /**
     * Метод, который реализует сортировку подсчётом.
     *
     * @param array Массив, который нужно отсортировать
     * @return Отсортированный массив
     */
    public static int[] countingSort(int[] array) {
        // Находим максимальный элемент массива, чтобы определить размер массива подсчёта
        int maxElement = getMaxValue(array);

        // Инициализируем массив подсчёта
        int[] countArray = new int[maxElement + 1];

        // Подсчитываем количество каждого элемента в исходном массиве
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }

        // Инициализируем индекс для перебора массива подсчёта
        int index = 0;

        // Для каждого элемента в массиве подсчёта
        for (int i = 0; i < countArray.length; i++) {
            // Копируем элемент в исходный массив столько раз, сколько он встречается
            for (int j = 0; j < countArray[i]; j++) {
                array[index++] = i;
            }
        }

        // Возвращаем отсортированный массив
        return array;
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Данный массив");
        printArray(array);

        countingSort(array);

        System.out.println("\nОтсортированный массив");
        printArray(array);
    }
}
