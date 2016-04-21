package codingbat;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ignacy on 13.04.16.
 */
public class oneTwo {
    public String oneTwo(String str) {
        char a;
        char b;
        char c;

        int thre = 0;
        if(str.length()<3){
            return "";
        }
        while(str.length()-2>=thre){
            a = str.charAt(thre);
            b = str.charAt(thre+1);
            c = str.charAt(thre+2);
            str = str.substring(0, thre) + b + c + a + str.substring(thre+3, str.length());
            thre += 3;
        }
        return str;
    }

@Test
    public void worksOk(){
    assertThat(oneTwo("abcabca"),is("bcabca"));
}
}
