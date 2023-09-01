package Collection;

public class MyArrayList implements MyList{
    int number;

    Integer[] integerArray = new Integer[10]; // Создание  массива типа Integer


    void upgrade(){
        number = 0;
        for(int i=0; i<integerArray.length; i++){
            if(integerArray[i]!=null){
                number++;
            }
        }
        if(number==integerArray.length){
            integerArray = new Integer[integerArray.length*2];
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
            }else if(integerArray[i]==null){
                integerArray[i]=object;
                System.out.println(integerArray[i]);
                break;
            }
        }
    }

    @Override
    public void add(int index, Integer object) { // добавление по индексу
        if(integerArray[index]==null){
            integerArray[index]=object;

        }else if(integerArray[index]!=null){
            for(int i=index; i<=integerArray.length; i++){
                if(i>=integerArray.length){
                    upgrade();
                    System.out.println("Апгрейд");
                }

                if(integerArray[i]==null){
                    break;
                }
                integerArray[i+1]=integerArray[i];
                System.out.println(integerArray[i]);

                integerArray[index]=object;
                System.out.println(integerArray[index]=object);

            }
        } else if (index>=integerArray.length){
            for(int i=0; i<=integerArray.length; i++){
                if(i==integerArray.length){
                    upgrade();
                }else if(integerArray[i]==null){
                    integerArray[i]=object;
                    System.out.println(integerArray[i]);
                    break;
                }
            }
        }
    }

    @Override
    public boolean remove(Integer object) { //удаление
        return false;
    }

    @Override
    public void clear() { // очистить массив
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = null;
        }
    }


    @Override
    public Integer get(int index) { //получения элемента по индексу
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
