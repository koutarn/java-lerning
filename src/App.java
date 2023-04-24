import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ZonedDateTime japaneseDateTime = localDateTime.atZone(ZoneId.of("Asia/Tokyo"));

        LocalDate localDateTime2 = LocalDate.of(2023,4,25);
        LocalDate localDateTime3 = LocalDate.of(2023,4,30);
        Period period = Period.between(localDateTime2, localDateTime3);
        System.out.println(period);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        for(String s : list) {
            System.out.println(s);
        }

        Set<String> hashSet = new HashSet<>();
        hashSet.add("red");
        hashSet.add("blue");
        hashSet.add("green");
        System.out.println(hashSet);

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("cat");
        treeSet.add("dog");
        treeSet.add("bird");
        for(String s : treeSet) {
            System.out.println(s);
        }

        Iterator<String> it = hashSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("red", 1);
        hashMap.put("blue", 2);
        hashMap.put("green", 3);

        for(String key : hashMap.keySet()) {
            System.out.println(key + " " + hashMap.get(key));
        }

        System.out.println(hashMap.get("red"));

        final AccountType accountType = AccountType.ADMIN;
        System.out.println(accountType);

    }
}

class Hero implements Comparable<Hero>, Cloneable {
    private String name;
    private int hp,mp;

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", mp=" + mp +
                '}';
    }

    public Hero(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

     @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Hero hero = (Hero) o;
        return hp == hero.hp &&
                mp == hero.mp &&
                Objects.equals(name, hero.name);
     }

     @Override
     public int hashCode() {
        return Objects.hash(name, hp, mp);
     }

     @Override
     public int compareTo(Hero o) {
        return Integer.compare(hp, o.hp);
     }

     @Override
     public Hero clone() throws CloneNotSupportedException {
        Hero hero = new Hero(this.name, this.hp, this.mp);
        return hero;
     }

}

//ジェネリクステスト
class Pockect<E>{
    private E e;
    public void put(E e) {
        this.e = e;
    }

    public E get() {
        return e;
    }

    @Override
    public String toString() {
        return "Pockect{" +
                "e=" + e +
                '}';
    }
}

enum AccountType {
    NORMAL,
    ADMIN
}
