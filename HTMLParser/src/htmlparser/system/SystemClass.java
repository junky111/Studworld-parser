/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlparser.system;

import frames.MainFrame;
import htmlparser.components.DetailComponent;
import java.io.IOException;

/**
 *
 * @author Ярослав
 */
public class SystemClass {
    ListLogic logic  = new ListLogic();
    private  String filePath=new String();
    public static double curse;
    public void start() throws InterruptedException{
       logic.createDetailList(); 
    }
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
    public String getFilePath(){
        return this.filePath;
    }
   
    public void finish() throws IOException{
        logic.createDocument(this.getFilePath(), logic.dl);
    }
}
