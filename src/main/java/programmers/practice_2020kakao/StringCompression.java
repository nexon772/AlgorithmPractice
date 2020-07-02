package programmers.practice_2020kakao;

/*
������ ó�� �������� �ǰ� ���� ����ġ�� ���ڿ��� �����ϴ� ����� ���� ���θ� �ϰ� �ֽ��ϴ�.
�ֱٿ� �뷮�� ������ ó���� ���� ������ ��ս� ���� ����� ���� ���θ� �ϰ� �ִµ�,
���ڿ����� ���� ���� �����ؼ� ��Ÿ���� ���� �� ������ ������ �ݺ��Ǵ� ������ ǥ���Ͽ�
�� ª�� ���ڿ��� �ٿ��� ǥ���ϴ� �˰����� �����ϰ� �ֽ��ϴ�.
������ ���� aabbaccc�� ��� 2a2ba3c(���ڰ� �ݺ����� �ʾ� �ѹ��� ��Ÿ�� ��� 1�� ������)��
���� ǥ���� �� �ִµ�, �̷��� ����� �ݺ��Ǵ� ���ڰ� ���� ��� ������� ���ٴ� ������ �ֽ��ϴ�.
���� ���, abcabcdede�� ���� ���ڿ��� ���� ������� �ʽ��ϴ�. ����ġ�� �̷��� ������ �ذ��ϱ�
���� ���ڿ��� 1�� �̻��� ������ �߶� �����Ͽ� �� ª�� ���ڿ��� ǥ���� �� �ִ��� �����
ã�ƺ����� �մϴ�.

���� ���, ababcdcdababcdcd�� ��� ���ڸ� 1�� ������ �ڸ��� ���� ������� ������, 2�� ������
�߶� �����Ѵٸ� 2ab2cd2ab2cd�� ǥ���� �� �ֽ��ϴ�. �ٸ� ������� 8�� ������ �߶� �����Ѵٸ�
2ababcdcd�� ǥ���� �� ������, �̶��� ���� ª�� �����Ͽ� ǥ���� �� �ִ� ����Դϴ�.

�ٸ� ����, abcabcdede�� ���� ���, ���ڸ� 2�� ������ �߶� �����ϸ� abcabc2de�� ������,
3�� ������ �ڸ��ٸ� 2abcdede�� �Ǿ� 3�� ������ ���� ª�� ���� ����� �˴ϴ�. �̶� 3�� ������
�ڸ��� �������� ���� ���ڿ��� �״�� �ٿ��ָ� �˴ϴ�.

������ ���ڿ� s�� �Ű������� �־��� ��, ���� ������ ������� 1�� �̻� ������ ���ڿ��� �߶�
�����Ͽ� ǥ���� ���ڿ� �� ���� ª�� ���� ���̸� return �ϵ��� solution �Լ��� �ϼ����ּ���.
*/
public class StringCompression {
    public static void main(String[] args){
        checkAnswer(new StringCompression().compressString("aabbaccc"), 7);
//        checkAnswer(new StringCompression().compressString("ababcdcdababcdcd"), 9);
//        checkAnswer(new StringCompression().compressString("abcabcdede"), 8);
//        checkAnswer(new StringCompression().compressString("abcabcabcabcdededededede"), 14);
//        checkAnswer(new StringCompression().compressString("xababcdcdababcdcd"), 17);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private int compressString(String s){
        int minSize = s.length();
        for(int i=1; i<s.length(); i++){
            String compressedString = compressByN(s, i);
            minSize = Math.min(minSize, compressedString.length());
        }
        return minSize;
    }

    // 1. get compressor string
    // 2. compare
    private String compressByN(String s, int n){
        System.out.println("n:"+n+" - "+s);
        String result = "";

        StringBuilder sb = new StringBuilder();
        String compressor = "";
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            int idx = i+n;
            if(idx >= s.length()) break;
            if(compressor.equals("")){
                compressor = s.substring(i, i+1);
            }
            if(!s.substring(i, i+1).equals(compressor)){
                sb.append(cnt+compressor);
                compressor = s.substring(i, i+1);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        sb.append(cnt+compressor);
        System.out.println(sb.toString());

        return sb.toString();
    }
}
