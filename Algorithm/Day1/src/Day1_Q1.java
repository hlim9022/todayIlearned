public class Day1_Q1 {
    public static String solution(int a, int b) {
        String answer = "";

        //각 month의 day 수를 배열로 저장
        int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        /*
        문제에서 2016년1월1일이 "FRI"라고 하였으니,
        7로 나눈 나머지가 1이면 "FRI"로 설계
        => 나머지 값 = day배열의 index값
        */
        String[] day = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int dayIdx; // day배열의 인덱스값을 얻기위한 변수 선언
        int yearDays = 0; // 몇번째날인지 알기위한 변수선언


        /* monthDays의 값을 a-1까지 다 더한 값에 b값을 더하면
        2016년의 몇번째 날인지 확인가능
        예) 3월2일은 monthDays[0]+monthDays[1]=60에 b값인 2를 더하면 '62'번째 날
        */
        for (int i=0; i < a - 1; i++) {
            yearDays += monthDays[i];
        }
        dayIdx = (yearDays + b) % 7;
        return day[dayIdx];
    }
}
