package flik;

/** An Integer tester created by Flik Enterprises.
 * @author Josh Hug
 * */
public class Flik {
    /** @param a Value 1
     *  @param b Value 2
     *  @return Whether a and b are the same */
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b);
    }
    /**
     * Java 为了优化内存使用，对于某些范围的数值，会在装箱时缓存这些对象。
     * Integer 的默认缓存范围是 -128 到 127。
     * 当装箱的值在这个范围内时，Java 会返回缓存中的同一个对象。
     * 超出这个范围时，Java 会创建新的对象
     * == 用于比较两个对象时，比较的是它们的引用是否相同（是否指向同一个内存地址），而不是值是否相等。
    */
}
