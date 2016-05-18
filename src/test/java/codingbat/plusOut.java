package codingbat;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ignacy on 03.05.16.
 */
public class plusOut {
    public String plusOut(String str, String word) {
        String str2 = str;
        for(int a = 0; a<str.length()-word.length(); a++){

            if(str2.substring(a, a+word.length()).equals(word)){
                str = str.substring(0, a)+word+str.substring(a+word.length(), str.length());
            }else{
                String plus = "";
                for(int b = word.length();b>0; b--){
                    plus = plus + "+";
                }
                str = str.substring(0,a)+plus+str.substring(a+word.length(),str.length());
            }
        }
        if(str.substring(str.length()-word.length(), str.length()).equals(word)){
            return str2;
        }else{
            String plus = "";
            for(int b = word.length();b>0; b--){
                plus = plus + "+";
            }
            str = str.substring(0, str.length()-word.length())+plus;
            return str;
        }
    }
    @Test
    public void worksOk(){
        assertThat(plusOut("abXYabcXYZ", "XY"), is("++XY+++XY+"));
    }
}
