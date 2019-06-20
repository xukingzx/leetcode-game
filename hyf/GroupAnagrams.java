package waitSolve;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int count = 0;
        List<List<String>> ll = new ArrayList<>();
        HashMap<HashMap<Character,Integer>,Integer> m = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int j = 0;j < strs[i].length();j++){
                if(hm.containsKey(strs[i].charAt(j)) == true){
                    hm.put(strs[i].charAt(j),hm.get(strs[i].charAt(j)) + 1);
                }
                else{
                    hm.put(strs[i].charAt(j),1);
                }
            }
            if(m.containsKey(hm) == true){
                ll.get(m.get(hm)).add(strs[i]);
            }
            else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                ll.add(l);
                m.put(hm,count++);
            }
        }
        return ll;
    }
    public List<List<String>> groupAnagrams_v2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
