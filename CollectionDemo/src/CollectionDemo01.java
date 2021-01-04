import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        /** 1.
         * addAll()方法
         * static <T> boolean	addAll(Collection<? super T> c, T... elements)    //集合，可变参数
         * 将所有指定的元素添加到指定的集合。
         */
        Collections.addAll(list,"e","d");
        System.out.println(list);

        /** 2.
         * sort();  //升序排列
         */
        Collections.sort(list);
        System.out.println(list);
        /** 3.
         * sort();
         * 匿名内部类  这里比较的是字符长度
         * new Comparator<String>() {
         *             @Override
         *             public int compare(String o1, String o2) {
         *                 return o1.length()-o2.length();
         *             }
         *         }
         */
        List list1 = new ArrayList();
        list1.add("feeee");
        list1.add("fefsfsdfs");
        list1.add("ee");
        list1.add("q");
        list1.add("dffsd");
        list1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //3.1 长度升序 [q, ee, feeee, dffsd, fefsfsdfs]
                return o1.length()-o2.length();
                //3.2 长度降序 [fefsfsdfs, feeee, dffsd, ee, q]
                //return o2.length()-o1.length();

            }
        });
        System.out.println(list1);

    }
}
