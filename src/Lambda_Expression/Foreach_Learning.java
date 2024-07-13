package Lambda_Expression;

import java.util.*;
import java.util.stream.Collectors;

public class Foreach_Learning {
    public static void main(String[] args) {
        List<Integer>lst = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            lst.add(i);
        }
        lst.forEach(System.out::println);
        List<Integer>ans = lst.stream().filter((a) -> a % 2 ==0).collect(Collectors.toList());
        System.out.println(ans);
        Class<?>cls=lst.getClass();
        System.out.println(cls.getName());
    }
}
