package story;//게임을 시작하기 위한 클래스
import Setting.first;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class start{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    first f = new first();

    public start() {
    }

    public void welcomepage()throws IOException {
        bw.write("1. 시작\n");
        bw.write("2. 불러오기\n");
        bw.write("3. 종료\n");
        bw.flush();

        String tmp = br.readLine();

        switch (tmp){
            case "1":
                f.have_name();
                f.have_job();
                break;
            case "2":
                //파일 불러오기 아직 구현 안함.
                break;
            case "3":
                bw.write("Bye");
                bw.flush();
                break;
            default:
                bw.write("확인하지 못했습니다. 올바른 번호를 입력하세요.\n");
                bw.flush();
                welcomepage();
        }
        bw.close();
    }
}
