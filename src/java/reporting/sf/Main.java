package reporting.sf;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.function.Consumer;
/**
 * Created by israel on 5/3/17.
 */
public class Main {
    public static void main(String[] args){
        String name = "Java Israel";
        Test t = x ->{
            System.out.println(x);
        };

        //t.doSomething(45);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        //list.stream().forEach(Main::printValue);

        System.out.println(name.chars().count());
        //System.out.println(name.chars().distinct().max());
        //name.chars().distinct().forEach(System.out::println);
        System.out.println(name.chars().distinct().count());

    }


    public static void printValue(Integer x){
        System.out.println(x);
    }
}
