package main;

import java.util.*;

public class Programmers {

    //https://programmers.co.kr/learn/courses/30/lessons/12925
    public static int 문자열을_정수로_바꾸기(String s) {
        return Integer.parseInt(s);
    }

    //https://programmers.co.kr/learn/courses/30/lessons/12930
    public static String 이상한_문자_만들기(String s) {
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

    //https://programmers.co.kr/learn/courses/30/lessons/76501?language=java
    public static int 음양더하기(int[] absolutes, boolean[] signs){
        int answer = 0;

        for(int i=0; i< absolutes.length; i++){
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }

    //https://programmers.co.kr/learn/courses/30/lessons/77884?language=java
    public static int[] 두개뽑아서더하기(int[] numbers){
        ArrayList<Integer> list = new ArrayList<>();

        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                result = numbers[i] + numbers[j];
                if (!list.contains(result)) {
                    list.add(result);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static String 가운데글자가져오기(String s){
        String answer = "";

        if (s.length() % 2 == 0) {
            answer += s.charAt(s.length()/2-1);
            answer += s.charAt(s.length()/2);
        } else {
            answer += s.charAt(s.length()/2);
        }
        return answer;
    }


}
