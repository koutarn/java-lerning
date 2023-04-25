import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.IntBinaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;

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

        FunctionClass functionClass = new FunctionClass();
        FunctionObject executor = functionClass::execute;
        executor.execute();

        FunctionClass2 functionClass2 = new FunctionClass2();
        FunctionObject executor2 = functionClass2::execute;
        executor2.execute();

        FunctionObject executor3 = () -> System.out.println("execute for lambda");
        executor3.execute();

        IntBinaryOperator func = (a, b) -> a + b;
        System.out.println(func.applyAsInt(10,20));

        IntBinaryOperator func2 = (a,b) -> a * b;
        System.out.println(func2.applyAsInt(10,20));

        IntToDoubleFunction  func3 = (x) -> {
            return x * x;
        };

        IntToDoubleFunction func4 = x -> x + x;

        System.out.println(func3.applyAsDouble(10));
        System.out.println(func4.applyAsDouble(10));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        for(Integer i : list1) {
            System.out.println(i);
        }

        Properties properties = System.getProperties();
        Iterator<String> iterator = properties.stringPropertyNames().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " = " + properties.getProperty(key));
        }

        System.out.println(Hero.class);
        System.out.println(func4.getClass());

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(100);
        arrayList.add(2);
        



        List<Integer> numbers = Arrays.asList(1, 2,30,2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                                            .distinct()
                                            .filter(n -> n % 2 == 0)
                                            .map(n -> n * 2)
                                            .sorted()
                                            .collect(Collectors.toList());
                            
        evenNumbers.stream().forEach(n -> System.out.println(n));

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        List<Integer> nameLengths = names.stream()
                                         .map(name -> name.length())
                                         .collect(Collectors.toList());
        System.out.println(nameLengths);

        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        List<String> sortedNames = names2.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        System.out.println(sortedNames);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers2.stream()
                         .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        List<String> names3 = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob", "Dave");
        List<String> distinctNames = names3.stream()
                                          .distinct()
                                          .collect(Collectors.toList());
        System.out.println(distinctNames);
        


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

interface FunctionObject{
    public abstract void execute();
}

class FunctionClass{
    public void execute(){
        System.out.println("execute");
    }
}

class FunctionClass2{
    public void execute(){
        System.out.println("execute for FunctionClass2");
    }
}

