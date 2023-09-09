package Collection;



public class Main {
    public static void main(String[]args){
        MyArrayList<Integer> arrayList = new MyArrayList();

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


        MyLinkedList<String> linkedList = new MyLinkedList();
        linkedList.add("False");
        linkedList.add(0,"Fuck");
        linkedList.printList();

        MyHashMap<String> hashMap = new MyHashMap();
        hashMap.size();
        hashMap.isEmpty();
        hashMap.put("Goal", "Olddd");
        boolean element = hashMap.remove("Olddd");
        System.out.println(element);
        System.out.println(hashMap.keyArray() +"   "+ hashMap.valueArray()+"   "+ hashMap.get("Goal"));
    }
}
