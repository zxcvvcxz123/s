package sorts.quick;

import static sorts.Utils.printArray;

/**
 * Быстрая сортировка - это рекурсивный алгоритм "разделяй и властвуй", который использует
 * операцию разделения для перемещения элементов меньше опорного элемента перед ним,
 * а элементы, больше или равные опорному - после.
 *
 * <p>Быстрая сортировка работает путем выбора опорного элемента из массива и разделения
 * других элементов на два подмассива в соответствии с тем, меньше они или больше опорного элемента.
 * Затем алгоритм рекурсивно сортирует два подмассива. Этот процесс продолжается до тех пор,
 * пока не будут обработаны все подмассивы.
 *
 * <p>Важно отметить, что быстрая сортировка - это нестабильный алгоритм сортировки.
 * Время выполнения алгоритма в среднем составляет O(n log n), но в худшем случае оно может достигнуть O(n^2).
 */
public class QuickSort {

    /*
     * Функция быстрой сортировки
     */
    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            /* pi - индекс опорного элемента, array[pi] на своем правильном месте */
            int pi = partition(array, leftIndex, rightIndex);

            // Рекурсивно сортируем элементы до
            // опорного и после опорного
            quickSort(array, leftIndex, pi - 1);
            quickSort(array, pi + 1, rightIndex);
        }
    }

    /*
     * Функция разделения
     */
    public static int partition(int[] array, int leftIndex, int rightIndex) {
        // Выбираем опорный элемент
        int pivot = array[rightIndex];
        int i = (leftIndex - 1); // Индекс меньшего элемента

        // Проходим через массив
        for (int j = leftIndex; j < rightIndex; j++) {
            // Если текущий элемент меньше или равен опорному
            if (array[j] <= pivot) {
                i++;

                // Меняем array[i] и array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            printArray(array);
        }

        // Меняем array[i+1] и array[rightIndex] (или опорный)
        int temp = array[i + 1];
        array[i + 1] = array[rightIndex];
        array[rightIndex] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int arrayLength = array.length;

        quickSort(array, 0, arrayLength - 1);

        System.out.println("Отсортированный массив:");
        printArray(array);
    }
}