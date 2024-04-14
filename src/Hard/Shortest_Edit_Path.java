package Hard;
import java.util.*;
public class Shortest_Edit_Path {
    static class Pair{
        String word;
        int level;
        Pair(String word,int level){
            this.word=word;
            this.level=level;
        }
    }

    static int shortestWordEditPath(String s, String t, String[] words) {
        // your code goes here
        Set<String>st=new HashSet<>();
        for(String str:words){
            st.add(str);
        }
        if(s.equals(t)) return 0;
        if(!st.contains(t)) return -1;
        Queue<Pair>que=new LinkedList<>();
        que.add(new Pair(s,0));
        while(!que.isEmpty()){
            Pair p=que.poll();
            String w=p.word;
            int level=p.level;
            if(w.equals(t)) return level;
            for(int i=0;i<w.length();i++){
                char[]arr=w.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String str1=new String(arr);
                    if(st.contains(str1)){
                        que.add(new Pair(str1,level+1));
                        st.remove(str1);
                    }
                }
            }
        }
        return -1;
    }
}
