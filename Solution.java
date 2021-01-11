/* Nathan Test Score Result Problem */


import java.util.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
  
  public static void main(String[] args) {
    String[] S = {"test1", "test2a", "test2b", "test3"};
    String[] R = {"OK", "Wrong answer", "OK", "OK"};
    System.out.println(getTestScore(S, R));
  }

  public static int getTestScore(String[] S, String[] R){

        Map<String,List<String>> map = new HashMap<String,List<String>>();

        for( int i = 0 ; i < S.length ; i++){
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(S[i]);
            while(m.find()) {
                if(map.containsKey(m.group())){
                        List<String> list = map.get(m.group());
                        list.add(R[i]);
                        map.put(m.group(),list);

                } else {
                    List<String> list = new ArrayList<>();
                    list.add(R[i]);
                    map.put(m.group(),list);
                }
            }
        }

        int scoreCounter = 0;

        for(String key : map.keySet()){
            List<String> list = map.get(key);
            if(!list.contains("Wrong answer") && !list.contains("Time out") && !list.contains("Error")){
                scoreCounter++;
            }
        }

        //System.out.println(map.toString());
        //System.out.println(scoreCounter);
        //System.out.println(map.size());
        return (scoreCounter*100)/map.size();

    }


}
