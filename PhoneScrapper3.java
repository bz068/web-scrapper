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
public class PhoneScrapper3 {
    
    
    /** Constructor */
    PhoneScrapper3(){
        try{
            scrapePhone();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    void scrapePhone() throws Exception{
      
        
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.idmobile.co.uk/shop/phones/sim-free").get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".filterForm");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //Get the product description
            Elements description = prods.get(i).select(".block text-overflow-ellipsis font-size-20\"");
            
            //Get the product price
            Elements price1 = prods.get(i).select(".margin-bottom-plus-15px");
            Elements finalPrice = price1.select(".block");
            
            
            
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text() + 
                     "; PRICE: " + finalPrice.text());
        }
    }
}
