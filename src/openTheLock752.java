
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        Queue<String> q = new LinkedList<>();
        String start = "0000";
        Set<String> visited = new HashSet<>();
        visited.add(start);
        q.offer(start);
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) return step;
                if (deads.contains(curr)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String p1 = plus1(curr, j);
                    if(!visited.contains(p1)) {
                        visited.add(p1);
                        q.offer(p1);
                    }
                    String m1 = minus1(curr, j);
                    if(!visited.contains(m1)) {
                        visited.add(m1);
                        q.offer(m1);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plus1(String curr, int j) {
        char[] ch = curr.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    private String minus1(String curr, int j) {
        char[] ch = curr.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}