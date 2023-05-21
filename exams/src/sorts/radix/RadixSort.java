package sorts.radix;

import java.util.Arrays;

import static sorts.Utils.getMaxValue;
import static sorts.Utils.printArray;

public class RadixSort {

    // Функция, реализующая подсчет сортировки array[] по значимому разряду.
    public static void countingSort(int[] array, int exp) {
        int arrayLength = array.length;
        int[] sortedArray = new int[arrayLength]; // Выводимый массив

        int[] countArray = new int[10];
        Arrays.fill(countArray, 0);

        // Считаем количество элементов для каждой цифры
        for (int arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++) {
            int countIndex = (array[arrayIndex] / exp) % 10;
            countArray[countIndex]++;
        }

        // Изменяем countArray[sortedArrayIndex] так,
        // чтобы countArray[sortedArrayIndex] содержало актуальное положение этой цифры в sortedArray[]
        for (int countArrayIndex = 1; countArrayIndex < 10; countArrayIndex++) {
            countArray[countArrayIndex] += countArray[countArrayIndex - 1];
        }

        // Построение выходного массива
        for (int arrayIndex = arrayLength - 1; arrayIndex >= 0; arrayIndex--) {
            int countArrayIndex = (array[arrayIndex] / exp) % 10;
            int sortedElementIndex = --countArray[countArrayIndex];
            sortedArray[sortedElementIndex] = array[arrayIndex];
        }

        // Копирование выходного массива в array[],
        // чтобы array[] содержал отсортированные числа по текущему разряду
        for (int arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++) {
            array[arrayIndex] = sortedArray[arrayIndex];
        }
        printArray(array);
    }

    // Функция реализации Radix Sort (поразрядной сортировки)
    public static void radixSort(int[] array) {
        // Находим максимальное число, чтобы знать количество разрядов
        int maxValue = getMaxValue(array);

        // Выполняем подсчет сортировки для каждого разряда
        // Вместо передачи количества разрядов, передается exp.
        // exp - это 10 ^ i, где i - текущий разряд числа
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(array);
        printArray(array);
    }
}