package codingbat;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ignacy on 20.04.16.
 */
public class getSandwich {
    public String getSandwich(String str) {
        String bread = "bread";
        int a = 0;
        int b = 0;
        int c = 0;
        String jam = "";
        while(a-1<str.length()-bread.length()){
            if(str.substring(a,a+5).equals(bread) && b == 0){
                b = a+5;
            }else if(str.substring(a,a+5).equals(bread)){
                c = a;
            }
            a++;
        }
        return str.substring(b,c);
    }
    @Test
    public void worksOk(){
        assertThat(getSandwich("xxbreadyy"),is("aaa"));
    }
}
