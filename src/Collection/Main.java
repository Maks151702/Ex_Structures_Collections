package Collection;



public class Main {
    public static void main(String[]args){
        MyArrayList arrayList = new MyArrayList();

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);

        arrayList.add(8,34);

        arrayList.indexOf(2);
        arrayList.lastIndexOf(2);

        arrayList.remove(5);

    }
}
