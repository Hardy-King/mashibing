import java.util.LinkedList;
import java.util.Vector;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        /**
         * add()  默认是从链表的尾部插入
         */
        linkedList.add(123);
        linkedList.add(false);
        linkedList.add("abc");
        System.out.println(linkedList);
        linkedList.add(0,"mashibing");
        System.out.println(linkedList);
        linkedList.addFirst("sds");
        linkedList.addLast("dsw");
        System.out.println(linkedList);
/**
 * vector也是List接口的一个子类实现
 * vector跟ArrayList一样，底层都是使用数组进行实现的
 * 面试问题：
 *      1.ArrayList是线程不安全的，效率高，Vector是线程安全的，效率低
 *      2.ArrayList扩容是1.5倍，Vector是2倍
 */
        Vector vector = new Vector();

    }
}
