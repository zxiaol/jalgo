package com.linjie.airbnb;

import java.util.*;

/**
 * Created by zhuxiaolong on 2019/1/17.
 */
public class Hackerank {

    public List<String> paginateStrings(ArrayList<String> results, int pageSize){

        if(results == null || results.size() < 1)
            return results;

        if(pageSize < 1)
            return null;

        int currentPageSize = 0;

        boolean returnFromEnd = false;

        Iterator<String> iter = results.iterator();

        Set<String> addedHosts = new HashSet<>();

        List<String> paginatedResults = new ArrayList<>();

        while (iter.hasNext()){

            String value = iter.next();

            String host = value.split(",")[0];

            if(returnFromEnd || !addedHosts.contains(host)){

                paginatedResults.add(value);
                currentPageSize++;
                addedHosts.add(host);
                iter.remove();

            }

            if(currentPageSize == pageSize){

                if(!results.isEmpty()){
                    paginatedResults.add(" ");
                }
                currentPageSize = 0;
                addedHosts.clear();
                returnFromEnd = false;
                iter = results.iterator();
            }

            if(!iter.hasNext()){

                returnFromEnd = true;
                iter = results.iterator();
            }
        }

        return paginatedResults;
    }

}
