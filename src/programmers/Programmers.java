package programmers;

public class Programmers {

    //https://programmers.co.kr/learn/courses/30/lessons/12925
    public static int solution(String s) {
        return Integer.parseInt(s);
    }

    //https://programmers.co.kr/learn/courses/30/lessons/12930
    public static String solution2(String s) {
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

}
