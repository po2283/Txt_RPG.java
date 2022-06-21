package Setting;

import user.character;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileWriter;

public class first extends character {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    character c = new character();
    String[] job_arr = {"마법사", "검사", "힐러"};


    //이름을 입력받는 메소드
    public void have_name() throws IOException {
        bw.write("당신의 이름을 입력하세요: ");
        bw.flush();
        c.setName(br.readLine());
        bw.write(c.getName() + "?\n");
        right(c.getName());
    }

    //직업을 갖는 메소드
    public void have_job() throws IOException {
        bw.write("원하는 직업을 선택하세요(번호를 입력하세요)." + "\n");
        bw.flush();
        for (int i = 0; i < job_arr.length; i++) {
            bw.write(i + 1 + ". " + job_arr[i] + "\n");
            bw.flush();
        }
        c.setJob(br.readLine());
        bw.write(job_arr[Integer.parseInt(c.getJob()) - 1] + "?\n");
        right(c.getJob());
    }

    //입력받은 설정이 맞는지 확인하는 메소드
    public void right(String s) throws IOException {
        bw.write("Yes(1)/No(2)\n");
        bw.flush();
        String tmp = br.readLine();
        //if문을 쓰지 않고 switch문을 이용해 해결했다.
        switch (tmp) {
            case "1":
                if (c.getName().equals(s)) {
                    bw.write("안녕하세요 " + c.getName() + ".\n");
                    bw.flush();
                } else if (c.getJob().equals(s)) {
                    bw.write("오늘부터 당신의 직업은 " + job_arr[Integer.parseInt(c.getJob()) - 1] + ".\n");
                    bw.flush();
                    setting_save();
                }
                break;
            case "2":
                if (s.equals(c.getName())) {
                    have_name();
                } else if (s.equals(c.getJob())) {
                    have_job();
                }
                break;
            default:
                bw.write("확인하지 못했습니다. 올바른 번호를 입력하세요.\n");
                bw.flush();
                right(s);
                break;
        }
    }

    //이름과 직업을 저장
    public void setting_save() throws IOException{
        String name = c.getName();
        String job = c.getJob();
        bw.write("파일명을 입력하세요(영문, 숫자만 가능): ");
        bw.flush();
        String fileName = br.readLine();
        String filePath = "C:\\Users\\luuu1\\Documents\\study\\java\\txt_RPG_Save\\" + fileName + ".txt";
        bw.write("저장 중...");
        bw.flush();

        try {
            File file = new File(filePath);
            FileWriter fw = new FileWriter(file, true);
            fw.write(name + "\t" + job_arr[Integer.parseInt(job)-1]);
            fw.flush();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

