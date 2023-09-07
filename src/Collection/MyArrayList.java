package Collection;

public class MyArrayList implements MyList{
    int number;

    Integer[] integerArray = new Integer[10]; // Создание  массива типа Integer

    void show(){
        System.out.println("Массив:");
        for(int i=0; i<integerArray.length; i++){

            System.out.println(integerArray[i]);
        }
    }
    void upgrade(){
        number = 0;
        for(int i=0; i<integerArray.length; i++){
            if(integerArray[i]!=null){
                number++;
            }
        }
        if(number==integerArray.length){
            Integer[] timeArray = integerArray;

            for (int i = 0; i < timeArray.length; i++) {
                timeArray[i] = integerArray[i];
            }

            integerArray = new Integer [integerArray.length*2];

            // Копируем элементы из временного массива
            for (int i = 0; i < timeArray.length; i++) {
                integerArray[i] = timeArray[i];
            }
        }
    }
    @Override
    public int size() { // возвращает текущий размер массива
        return integerArray.length;
    }

    @Override
    public boolean isEmpty() { // возвращает логическое значение, пустой ли массив
        number = 0;

        for(int i=0; i<integerArray.length; i++){
            if(integerArray[i]==null){
                number++;
            }
        }
        if(number==integerArray.length){
            System.out.println("true");

            return true;
        }
        System.out.println("false");
        return false;
    }

    @Override
    public boolean contains(Integer object) { // возвращает логическое значение, содержит ли массив переданный, как параметр, элемент
        for(int i=0; i<integerArray.length; i++){
            if(integerArray[i]==object){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Integer object) { // добавление элемента в конец массива
        for(int i=0; i<=integerArray.length; i++){
            if(i==integerArray.length){
                upgrade();
            }if(integerArray[i]==null){
                integerArray[i]=object;
                System.out.println(integerArray[i]);
                break;
            }
        }
    }

    @Override
    public void add(int index, Integer object) {
        if (index < 0 || index > integerArray.length) {
            throw new IndexOutOfBoundsException("Индекс находится вне допустимых границ");
        }

        if (index == integerArray.length) {
            upgrade();
        }

        for (int i = integerArray.length - 1; i > index; i--) {
            integerArray[i] = integerArray[i - 1];
        }

        integerArray[index] = object;
    }


    @Override
    public void remove(Integer object) {
        for (int i = 0; i < integerArray.length; i++) {
            if (object.equals(integerArray[i])) {

                for (int j = i; j < integerArray.length - 1; j++) {
                    integerArray[j] = integerArray[j + 1];

                }
                integerArray[integerArray.length - 1] = null;
            }
        }
    }



    @Override
    public void clear() { // очистить массив
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = null;
        }
    }


    @Override
    public Integer get(int index) { // получения элемента по индексу
        return integerArray[index];
    }

    @Override
    public int indexOf(Integer object) { // получения первого индекса переданного элемента в массиве
        for (int i = 0; i < integerArray.length; i++) {
            if(integerArray[i]==object){
                System.out.println(i);
                return i;
            }
        }
        System.out.println("0");
        return 0;
    }

    @Override
    public int lastIndexOf(Integer object) { // - получения последнего индекса переданного элемента в массиве
        for (int i = integerArray.length-1; i>=0; i--) {
            if(integerArray[i]==object){
                System.out.println(i);
                return i;
            }
        }
        System.out.println("0");
        return 0;
    }
}
