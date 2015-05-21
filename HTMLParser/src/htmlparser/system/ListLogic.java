/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlparser.system;

import htmlparser.components.DetailComponent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ярослав
 */
public class ListLogic {
    ArrayList <DetailComponent> dl = new ArrayList();
    DetailComponent  detail;
    private final String baseDir= "http://shop.atlasparts.com.ua/search/?p=";
    
    public void createDetailList() throws InterruptedException{
        int pageNumber = 1;
        int r = 0;
        do{ 
            try {
                
                if((pageNumber%12)==0){
                    Thread.sleep(300000);
                }
                System.out.println("Page : "+pageNumber);
                Document doc = Jsoup.connect(baseDir+pageNumber).get();
                Element detail  = doc.select("table.list").first();
                
                if(detail.hasText()){
                    detail.select("tr.theader").remove();
                }else{
                    break;
                }
                Elements details = detail.select("tr");
                if (details.size() == 0) {
                     break;
                }
                
                for(Element detailtd : details){
                    r++;
                    Elements tds = detailtd.select("td");
                        Element td = tds.get(0);
                        Element td1 = tds.get(1);
                        Element td2 = tds.get(2);
                        String analogs = detailtd.outerHtml().substring(detailtd.outerHtml().indexOf("<!--"),detailtd.outerHtml().length())
                                .replaceAll("<[!-- a-zA-Z\\s/]+>", "")
                                .replaceAll(" <div style=\"display:none;\">","");
                         td1.select("del").remove();
                        this.dl.add(new DetailComponent(
                                td.select("em").text(),
                                td.select("h2").text(),
                                td.select("strong").text(),
                                Double.parseDouble(td1.select("b.lprice").text())/SystemClass.curse,
                                td1.select("strong.available").text(),
                                analogs,
                                td2.text().replaceAll("<br>", "")
                                ));
                  
                    }
                if(pageNumber==15)
                {
                    return;
                }
                pageNumber++;
                Thread.sleep(60000);
             } catch (IOException ex) {
                Logger.getLogger(ListLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(true);
        
     }
    
    public void createDocument(String fileName, ArrayList<DetailComponent> details) throws FileNotFoundException, IOException{
        FileOutputStream file = new FileOutputStream(fileName);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("Details information");
        HSSFRow row = worksheet.createRow((short) 0);
        HSSFCell cellA = row.createCell((short) 0);
        HSSFCell cellB = row.createCell((short) 1);
        HSSFCell cellC = row.createCell((short) 2);
        HSSFCell cellD = row.createCell((short) 3);
        HSSFCell cellE = row.createCell((short) 4);
        HSSFCell cellF = row.createCell((short) 5);
        HSSFCell cellG = row.createCell((short) 6);
        cellA.setCellValue("Articul");
        cellB.setCellValue("Name");
        cellC.setCellValue("Producer");
        cellD.setCellValue("Price");
        cellE.setCellValue("isAvailable");
        cellF.setCellValue("Analogs");
        cellG.setCellValue("Applicability");
        for(int i = 0; i<details.size(); i++){
            formateDocument(worksheet, (short) (i+1),details.get(i));
        }
        workbook.write(file);    
        file.flush();
        file.close();
    }
    
    public void formateDocument(HSSFSheet worksheet,short rowNumber,DetailComponent detail ){
        HSSFRow row = worksheet.createRow((short) rowNumber);
        HSSFCell cellA = row.createCell((short) 0);
        HSSFCell cellB = row.createCell((short) 1);
        HSSFCell cellC = row.createCell((short) 2);
        HSSFCell cellD = row.createCell((short) 3);
        HSSFCell cellE = row.createCell((short) 4);
        HSSFCell cellF = row.createCell((short) 5);
        HSSFCell cellG = row.createCell((short) 6);
        cellA.setCellValue(detail.getArticul());
        cellB.setCellValue(detail.getName());
        cellC.setCellValue(detail.getProducer());
        cellD.setCellValue(detail.getPrice());
        cellE.setCellValue(detail.getAvailable());
        cellF.setCellValue(detail.getAnalogs());
        cellG.setCellValue(detail.getUsing());
    }


}
