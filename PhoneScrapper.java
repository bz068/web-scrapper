/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baghdadzazai.phonecomparrison;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/** Example code to illustrate web scraping with JSoup */
public class PhoneScrapper {

    PhoneScrapper(){
        try{
            scrapePhone();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
            void scrapePhone() throws Exception{
        //Name of item that we want to scrape
       // String itemName = "cornflakes";
        
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.giffgaff.com/mobile-phones/").get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".handset-item");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //Get the product description
            Elements description = prods.get(i).select(".handset-name--mobile");
            
            //Get the product price
            Elements price1 = prods.get(i).select(".details");
            Elements finalPrice = price1.select(".price");
            
            //Get the weight
            //Elements weight = prods.get(i).select(".fop-catch-weight");
            
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text() + 
                     "; PRICE: " + finalPrice.text());
        }
    }
}
