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
public class PhoneScrapper4 {
    
    
    /** Constructor */
    PhoneScrapper4(){
        try{
            scrapePhone();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    void scrapePhone() throws Exception{
      
        
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.o2.co.uk/shop/phones?contractType=payasyougo#sort=content.sorting.featured&page=1").get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".device-tile-wrapper");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //Get the product description
            Elements description = prods.get(i).select(".details");
            
            //Get the product price
            Elements price1 = prods.get(i).select(".device-tile__bottom");
            Elements finalPrice = price1.select(".costs");
            
            
            
            //Output the data that we have downloaded
            System.out.println(finalPrice.text());
        }
    }
}
