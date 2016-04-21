package codingbat;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ignacy on 20.04.16.
 */
public class starOut {
    public String starOut(String str) {
        int a = 0;
        String strEnd = "";
        int[] chars = new int[str.length()];
        for(;a<str.length();a++){
            if(str.charAt(a) == '*'){
                chars[a] = 1;
            }else{
                chars[a] = 0;
            }
        }
        if(str.length() == 1 && !str.equals("*")){
            return str;
        }
        int b = 1;
        for(;b<str.length();b++){
            if(str.length() == 1){
                return str;
            }
            if(b-1 == 0 && chars[0] == 0 && chars[1] == 0){
                strEnd = strEnd+str.charAt(0);
            }
            if(b == str.length()-1){
                if(chars[b] == 1){
                    break;
                }
                if(chars[b-1] == 0 && chars[b] == 0 ){
                    strEnd = strEnd + str.charAt(b);
                    break;
                }
            }
            if(chars[b-1] == 0 && chars[b] == 0 && chars[b+1] == 0){
                strEnd = strEnd+str.charAt(b);
            }
        }
        return strEnd;
    }
@Test
    public void worksOk(){
    assertThat(starOut("a"),is("a"));
}
}
