package main;

import java.util.*;



public class Main {

    //https://programmers.co.kr/learn/courses/30/lessons/12930
    public static String 이상한문자만들기(String s) {
        String answer = "";
        String str[] = s.split("");
        int idx = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(" ")) {
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    idx++;
                    str[i] = str[i].toUpperCase();
                } else {
                    idx++;
                    str[i] = str[i].toLowerCase();
                }
            }
            answer += str[i];
        }
        return answer;
    }

    //https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
    public static String 완주하지못한선수(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < completion.length; i++) {
            if (hm.containsKey(completion[i])) {
                hm.put(completion[i], hm.get(completion[i]) + 1);
            } else {
                hm.put(completion[i], 1);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (hm.containsKey(participant[i])) {
                hm.put(participant[i], hm.get(participant[i]) - 1);
                if (hm.get(participant[i]) < 0) {
                    answer = participant[i];
                    break;
                }
            } else {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    //https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
    public static boolean 전화번호목록(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    //https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
    public static int 위장(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (int val : hm.values()) {
            System.out.println(val);
            answer *= (val + 1);
        }

        return answer - 1;
    }

    //https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
    public static int[] 주식가(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!st.empty() && prices[st.peek()] > prices[i]) {
                int top = st.peek();
                st.pop();
                answer[top] = i - top;
            }
            st.push(i);
        }

        while (!st.empty()) {
            int top = st.peek();
            st.pop();
            answer[top] = prices.length - 1 - top;
        }

        return answer;
    }

    //https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
    public static int[] 카펫(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int temp = 0, i;
        for (i = 3; i <= brown; i++) {
            if (total % i == 0)
                temp = total / i;
            if ((temp * 2 + i * 2) - 4 == brown)
                break;
        }

        answer[0] = temp > i ? temp : i;
        answer[1] = temp < i ? temp : i;
        return answer;
    }

    //    public static int 커머스1번(int[] gift_cards, int[] wants) {
//        Map<Integer, Integer> hm = new HashMap<>();
//        int answer = 0;
//        for (int i = 0; i < gift_cards.length; i++) {
//            hm.put(gift_cards[i], hm.getOrDefault(gift_cards[i], 0) + 1);
//        }
//
//        for (int i = 0; i < wants.length; i++) {
//            if (hm.containsKey(wants[i]) && hm.get(wants[i]) > 0) {
//                hm.put(wants[i], hm.get(wants[i]) - 1);
//            } else {
//                answer++;
//            }
//        }
//        return answer;
//    }
//
//    public static int 커머스2번(int[][] needs, int r) {
//        int robot = needs.length;
//        int answer = 0;
//        boolean[] visited = new boolean[robot];
//        int temp;
//        for (int i = 0; i < robot - r; i++) {
//            visited[i] = true;
//            temp = combination(i, 1, r, robot, visited, needs);
//            visited[i] = false;
//        }
//
//        return answer;
//    }
//
//    static int[] result = new int[2];
//
//    public static int[] 커머스3(int n, int[] passenger, int[][] train) {
//
//        int temp = 0;
//        boolean[][] map = new boolean[n][n];
//
//        for (int i = 0; i < train.length; i++) {
//            map[train[i][0] - 1][train[i][1] - 1] = true;
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < n; j++) {
//
//                boolean[] visited = new boolean[n];
//                temp = passenger[0];
//                visited[0] = true;
//
//                if (map[0][j]) {
//                    dfs(j, i, temp, visited, passenger, map);
//                }
//
//            }
//        }
//        result[0]++;
//        return result;
//    }
//
//    public static void dfs(int st, int end, int total, boolean[] visited, int[] passenger, boolean[][] map) {
//
//        if (st == end) {
//            total += passenger[end];
//            if (result[1] < total) {
//                result[1] = total;
//                result[0] = end;
//            } else if (result[1] == total) {
//                if (result[0] < end)
//                    result[0] = end;
//            }
//            return;
//        }
//
//        for (int i = 0; i < passenger.length; i++) {
//            if (visited[i]) continue;
//            if (map[st][i]) {
//                visited[i] = true;
//                dfs(i, end, total + passenger[st], visited, passenger, map);
//                visited[i] = false;
//            }
//        }
//    }
//    public static int[] solution(int[] lottos, int[] win_nums) {
//        int[] answer = new int[2];
//        Map<Integer, Integer> hm = new HashMap<>();
//        int corret = 0;
//        int not_corret = 0;
//
//        for(int i=0; i< win_nums.length; i++){
//            hm.put(win_nums[i], 1);
//        }
//
//        for(int i=0; i<lottos.length; i++){
//            if(hm.containsKey(lottos[i]))
//                corret++;
//            if(lottos[i]==0)
//                not_corret++;
//        }
//
//        int best_win = 7 - (corret+not_corret);
//        int worst_win = 7 - corret;
//
//        best_win = best_win > 5 ? 6 : best_win;
//        worst_win = worst_win > 5 ? 6 : worst_win;
//
//        answer[0] = best_win;
//        answer[1] = worst_win;
//
//        return answer;
//    }

//    public static int[] solution(int rows, int columns, int[][] queries) {
//        int[] answer = new int[queries.length];
//        int[][] map = new int[rows][columns];
//        int num = 1;
//        for (int i = 0; i < rows; i++)
//            for (int j = 0; j < columns; j++) {
//                map[i][j] = num++;
//            }
//
//        for (int i = 0; i < queries.length; i++) {
//            int temp = 10001;
//            int[] corner = new int[3];
//            int x1 = queries[i][0] - 1, x2 = queries[i][2] - 1, y1 = queries[i][1] - 1, y2 = queries[i][3] - 1;
//
//            corner[0] = map[x1][y2];
//            for (int y = y2; y > y1; y--) {
//
//                map[x1][y] = map[x1][y - 1];
//            }
//
//            corner[1] = map[x2][y2];
//            for (int x = x2; x > x1 + 1; x--) {
//
//                map[x][y2] = map[x - 1][y2];
//            }
//            map[x1 + 1][y2] = corner[0];
//
//            corner[2] = map[x2][y1];
//            for (int y = y1; y < y2 - 1; y++) {
//
//                map[x2][y] = map[x2][y + 1];
//            }
//            map[x2][y2 - 1] = corner[1];
//
//            for (int x = x1; x < x2 - 1; x++) {
//
//                map[x][y1] = map[x + 1][y1];
//            }
//            map[x2 - 1][y1] = corner[2];
//
//            for (int x = x1; x <= x2; x++) {
//                for (int y = y1; y <= y2; y++) {
//                    if (x == x1) {
//                        temp = Math.min(temp, map[x][y]);
//                    } else if (x == x2) {
//                        temp = Math.min(temp, map[x][y]);
//                    } else {
//                        if (y != y1 && y != y2)
//                            continue;
//                        temp = Math.min(temp, map[x][y]);
//                    }
//                }
//            }
//            answer[i] = temp;
//        }
//        return answer;
//    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i=0; i<amount.length; i++)
            amount[i] *= 100;

        Map<String, Integer> total = new HashMap<>();
        Map<String, String> link = new HashMap<>();

        for(int i=0; i<enroll.length; i++){
            total.put(enroll[i], 0);
        }

        for(int i=0; i< referral.length; i++){
            link.put(enroll[i], referral[i]);
        }

        for(int i=0; i<seller.length; i++){

            total.put(seller[i], total.get(seller[i]) + amount[i] / 100 * 90);
            String temp = seller[i];
            int temp_money = amount[i];

            while(true){
                temp = link.get(temp);
                if(temp.equals("-"))
                    break;
                total.put(temp, total.get(temp)+(temp_money/100*90));
                temp_money = temp_money / 100 * 10;
            }

        }


        int[] answer = {};

        return answer;
    }


    public static void main(String[] args) {

        

    }
}

//    enroll	referral	seller	amount	result
//        ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	["young", "john", "tod", "emily", "mary"]	[12, 4, 2, 5, 10]	[360, 958, 108, 0, 450, 18, 180, 1080]
//        ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	["sam", "emily", "jaimie", "edward"]	[2, 3, 5, 4]	[0, 110, 378, 180, 270, 450, 0, 0]