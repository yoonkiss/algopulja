package stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1082&sca=3010
 1809 탑

 */
public class StackStudy1 {

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        System.setIn(new FileInputStream("sample_static_study1.txt"));
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T ; i++) {
            int N = s.nextInt();
            int A[] = new int[N];
            int R[] = new int[N];

            Deque<TMP> S = new ArrayDeque<TMP>();
            for (int j = 0; j < N; j++) {
                A[j] = s.nextInt();
            }
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    R[0] = 0;
                    S.push(new TMP(j, A[j]));
                    continue;
                }
                if (A[j-1] > A[j] ) {
                    R[j] = j-1 +1; // not j-1
                    S.push(new TMP(j, A[j]));
                } else if (A[j-1] <= A[j] ) { // 뒤보다 더 크면..
                    TMP t = S.peek();
                    if (t.height > A[j]) {  //
                       R[j] = t.index +1; 
                    } else { // 자신보다 큰것이 나올때 까지 찾으면서 삭제한
                        for (TMP e : S) {
                            if (e.height > A[j]) {
                                R[j] = e.index+1;
                                break;
                            } else {
                                S.pop();
                                
                            }
                        }
                        
                    }
                    S.push(new TMP(j, A[j]));
                }
            }
            for (int j = 0; j < N; j++) {
                if (j < N -1)
                    System.out.print(R[j] + " ");
                else
                    System.out.print(R[j]);
            }
            System.out.println("");

            //break;
        }
        long end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start ));
    }

    static class TMP {
        public TMP(int j, int i) {
            index = j;
            height = i;
        }
        int index;
        int height;
    }
}
