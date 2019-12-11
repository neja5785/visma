package com.visma;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class DataList {

    public ArrayList<Goods> goods;
    public  int checkerIfThereIsAnyGoods=0;

    public DataList(){
        CSVreader rd = new CSVreader();
        goods = rd.readGoods("./data/sample.csv");
        Collections.sort(goods);
    }


    public void deleteDublicatesAndPrint(String stringVariable, String operationID) {

        int totalQuantity = 0;
        String temporaryName= goods.get(0).getItemName();
        Date temporaryDate= goods.get(0).getExpDate();
        Long temporaryCode = goods.get(0).getCode();
        for (int i =0; i<goods.size();i++){

            if (temporaryName.equals(goods.get(i).getItemName())  && temporaryDate.equals(goods.get(i).getExpDate())  && temporaryCode.equals(goods.get(i).getCode()) || i==0){
                totalQuantity +=  goods.get(i).getQuantity();

            }

            else {
                try{
                if (operationID.equals("1")) {
                    if (Integer.parseInt(stringVariable) > totalQuantity) {
                        System.out.print("Item name: " + goods.get(i - 1).getItemName() + ";");
                        System.out.print(" Total quantity:" + totalQuantity + ";");
                        System.out.print(" Code: " + goods.get(i - 1).getCode() + ";");
                        System.out.println(" Date: " + goods.get(i - 1).getExpDate() + ";");
                        checkerIfThereIsAnyGoods++;
                    }
                    totalQuantity = goods.get(i).getQuantity();
                }
                }  catch (Exception e){
                    System.out.println("Blogai įvedėte prekių skaičių");
                    return;
                }

                try{
                if(operationID.equals("2")){
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                    if(goods.get(i-1).getExpDate().before(date.parse(stringVariable))) {
                        System.out.print("Item name: " + goods.get(i - 1).getItemName() + ";");
                        System.out.print(" Total quantity:" + totalQuantity + ";");
                        System.out.print(" Code: " + goods.get(i - 1).getCode() + ";");
                        System.out.println(" Date: " + goods.get(i - 1).getExpDate() + ";");
                        checkerIfThereIsAnyGoods++;
                    }
                    totalQuantity = goods.get(i).getQuantity();

                }
                }
                catch (Exception e){
                    System.out.println("\nBlogai įvedėte datą");
                    return;
                }
            }
                temporaryName = goods.get(i).getItemName();
                temporaryDate = goods.get(i).getExpDate();
                temporaryCode = goods.get(i).getCode();

                }
        if(checkerIfThereIsAnyGoods==0){
            System.out.println("\nTokių prekių nėra");
        }

    }

}






