package com.linjie;

import static org.junit.Assert.assertTrue;

import com.linjie.airbnb.Hackerank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldPaginateCorrectly(){

        String[] strs = new String[]{
                "1,28,300.1,SanFrancisco", //1
                "4,5,209.1,SanFrancisco",  //1
                "20,7,208.1,SanFrancisco", //1
                "23,8,207.1,SanFrancisco", //1
                "16,10,206.1,Oakland",     //1
                "1,16,205.1,SanFrancisco",  //2
                "6,29,204.1,SanFrancisco", //1
                "7,20,203.1,SanFrancisco", //1
                "8,21,202.1,SanFrancisco", //1
                "2,18,201.1,SanFrancisco", //1
                "2,30,200.1,SanFrancisco", //2
                "15,27,109.1,Oakland", //1
                "10,13,108.1,Oakland", //1
                "11,26,107.1,Oakland", //1
                "12,9,106.1,Oakland", //2
                "13,1,105.1,Oakland", //2
                "22,17,104.1,Oakland", //2
                "1,2,103.1,Oakland",   //3
                "28,24,102.1,Oakland", //2
                "18,14,11.1,SanJose",  //2
                "6,25,10.1,Oakland",  //2
                "19,15,9.1,SanJose", //2
                "3,19,8.1,SanJose",  //2
                "3,11,7.1,Oakland", //3
                "27,12,6.1,Oakland", //2
                "1,3,5.1,Oakland", //3-last
                "25,4,4.1,SanJose", //2
                "5,6,3.1,SanJose",  //3
                "29,22,2.1,SanJose",  //3
                "30,23,1.1,SanJose"  //3
        };

        Hackerank hackerank = new Hackerank();

        List<String> results = hackerank.paginateStrings(new ArrayList<String>(Arrays.asList(strs)), 12);

        for(int i = 0; i < results.size();i++){

            if(results.get(i).equals(" ")){
                System.out.println();
                System.out.println();
                System.out.println();
            }else {

                System.out.println(results.get(i));
            }
        }

    }
}
