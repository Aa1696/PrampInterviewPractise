package Stream_API;
import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
        //Find list of students whose first name starts with alphabet A
        List<Student>ans=list.stream().filter((a)->a.getFirstName().startsWith("A")).collect(Collectors.toList());
        ans.forEach(System.out::println);
        System.out.println("Find list of students whose first name starts with alphabet A"+ans);
        //Group The Student By Department Names
        Map<String,List<Student>>ans1 = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));

        //Find the total count of student using stream
        long cnt = list.stream().count();
        System.out.println("Total count of the student ="+ cnt);

        //Find the max age of student
        OptionalInt opt1 = list.stream().mapToInt((a) -> a.getAge()).max();
        System.out.println("Max Age of the Student=" + opt1.getAsInt());

        //Find all departments names
        List<String>department_name =list.stream().map((a) -> a.getDepartmantName()).collect(Collectors.toList());
        System.out.println("Departments_Name = "+ department_name);

        //Find the count of student in each department
        Map<String, Long>map1 = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));
        System.out.println("Count of the Student =" + map1);

        //Find the list of students whose age is less than 30
        List<Student>age_std = list.stream().filter((a)->a.getAge() < 30).collect(Collectors.toList());
        System.out.println("List Of Student Whose Age is less than 30"+age_std);

        //Find the list of students whose rank is in between 50 and 100
        List<Student>stdnt = list.stream().filter((a) -> a.getRank() >=50 && a.getRank()<=100).collect(Collectors.toList());
        System.out.println("List Of student age between 50 and 100="+ stdnt);

        Map<String,Double>grp = list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));
        System.out.println("Get Age by Average of student :"+ grp);
        Map.Entry<String,Long>map_val =list.stream().
                collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("Department having maximum number of students: "+ map_val);

        List<Student>lst1 = list.stream().filter((a) -> a.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());

        System.out.println("Delhi sorted student: "+ lst1);

       Map<String,Double>rank =  list.stream()
                .collect(Collectors.
                        groupingBy(Student::getDepartmantName , Collectors.averagingInt(Student :: getRank)));

        System.out.println("Rank of the department of the student: "+ rank);

       Map<String,Optional<Student>>ans_rnk= list.stream().
                collect(Collectors.
                        groupingBy(Student::getDepartmantName,Collectors.maxBy(Comparator.comparing(Student ::getRank))));

        System.out.println("Max rank of the student in each department "+ ans_rnk);

        List<Student>ran_student = list.stream().sorted(Comparator.comparing(Student :: getRank))
                .collect(Collectors.toList());
        System.out.println("Rank of the sorted student "+ ran_student);

        Student stdnt1 = list.stream().sorted(Comparator.
                comparing(Student::getRank)).skip(1).findFirst().get();
        System.out.println(stdnt1);
        long parallel_time = System.currentTimeMillis();
        list.parallelStream().
                filter((a)->a.getAge()%2 == 0).collect(Collectors.toList());
        System.out.println("Total Time to complete the parallel process = "+(System.currentTimeMillis() - parallel_time));
    }

}
