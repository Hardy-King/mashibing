import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        /*Collection collection = new ArrayList();
        collection.add(1);
        collection.add(true);
        collection.add(1.23);
        collection.add("abc");
        System.out.println(collection);
        Collection collection1 = new ArrayList();
        collection1.add("1");
        collection1.add("abc");
        //collection1.add("dsds");
        Iterator it = collection.iterator();
        while (it.hasNext()){
            Object next = it.next();
            System.out.println(next);
        }

        System.out.println(collection1.retainAll(collection));
        Object[] objects = collection.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }*/
        List list = new ArrayList();
        list.add("asd");
        list.add("dsds");
        Collections.addAll(list,"122","desss","dfdfdd");
        System.out.println(list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length()>s2.length()){
                    return 1;
                } else if (s1.length()<s2.length()){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);


    }
}
