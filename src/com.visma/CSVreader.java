package com.visma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class CSVreader {

    public ArrayList <Goods> readGoods(String fileName) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader br ;
        try {
            br = new BufferedReader(new FileReader(fileName));

            ArrayList<Goods> list = new ArrayList<>();
            String line;
            int iteration = 0;
            while ((line = br.readLine()) != null) {
                if(iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] details = line.split(",");
                if (details.length > 0) {
                    Goods goods = new Goods((details[0]),
                            Long.parseLong(details[1]),
                            Integer.parseInt(details[2]),
                            date.parse(details[3]));
                    list.add(goods);

                }
            }
            br.close();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}