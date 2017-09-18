import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by mia on 9/17/17.
 */
public class InformationMask {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while((in = br.readLine()) != null){
            String[] inputs = in.trim().split(":");
            if(inputs[0].trim().equals("E")){
                System.out.print(emailMask(inputs[1].trim()));
            }else if (inputs[0].trim().equals("P")){
                System.out.print(phoneMask(inputs[1].trim()));
            }
        }
        br.close();
    }

    private static String emailMask(String email) {
        StringBuilder sb = new StringBuilder();
        sb.append("E:");
        sb.append(email.charAt(0));
        sb.append("*****");
        sb.append(email.substring(email.lastIndexOf('@')-1));
        return sb.toString();
    }

    private static String phoneMask(String phone) {
        StringBuilder sb = new StringBuilder();

        for(int i = phone.length()-1; i >= 0; i--){
            char c = phone.charAt(i);
            if(!Character.isDigit(c)){
                continue;
            }
            int len = sb.length();
            if(len>0 && len % 4 == 0){
                sb.insert(0, '-');
            }
            if(sb.length()>=5){
                sb.insert(0, '*');
            }else{
                sb.insert(0, c);
            }


        }
        if(sb.length() > 12){
            sb.insert(0, '+');
        }
        sb.insert(0,"P:");
        return sb.toString();
    }
}
