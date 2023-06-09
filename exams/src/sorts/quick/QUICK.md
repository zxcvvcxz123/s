Алгоритм быстрой сортировки основывается на стратегии "разделяй и властвуй". Он работает следующим образом:

    Выбирается элемент из массива, который будет служить опорным элементом (в нашей реализации это всегда последний элемент подмассива).

    Массив переразбивается таким образом, что элементы меньше опорного элемента располагаются слева от него, а больше или равные – справа. Этот процесс называется партицированием.

    Выполняются рекурсивные вызовы функции быстрой сортировки для подмассивов слева и справа от позиции опорного элемента. Это продолжается до тех пор, пока не останутся подмассивы размером в один элемент.

Давайте пройдемся по этому алгоритму на примере. Пусть есть массив:

[8, 7, 6, 1, 3, 5, 2, 4]

Выбираем опорный элемент. В нашей реализации это всегда последний элемент в текущем подмассиве, так что в начале это 4.

Затем мы начинаем партицировать массив. Элементы, которые меньше 4, переходят в левую часть массива, а которые больше или равны - в правую. Результат этого шага:

[1, 3, 2, 4, 8, 7, 6, 5]

Теперь мы рекурсивно вызываем функцию быстрой сортировки для подмассивов слева и справа от 4. Левый подмассив: [1, 3, 2], правый подмассив: [8, 7, 6, 5].

Рекурсивно сортируя эти подмассивы, мы получим:

Левый подмассив: [1, 2, 3]

Правый подмассив: [5, 6, 7, 8]

Скомбинировав оба отсортированных подмассива вместе с опорным элементом 4, получим окончательно отсортированный массив:

[1, 2, 3, 4, 5, 6, 7, 8]