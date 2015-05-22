/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlparser.system;

import java.io.IOException;
import java.util.ArrayList;

/*
 *
 * @author Ярослав
 */
public class SystemClass {
    ListLogic logic = new ListLogic();
    private  String filePath=new String();
    public static double curse;
    private ArrayList<String> proxyIPs = new ArrayList<>();
    public void start() throws InterruptedException{
        proxyIPs.add("188.166.103.115");
        proxyIPs.add("62.210.72.123");
        proxyIPs.add("168.63.249.35");
        proxyIPs.add("190.152.98.102");
        proxyIPs.add("177.190.209.10");
        proxyIPs.add("70.168.108.216");
        proxyIPs.add("77.175.221.22");
        proxyIPs.add("219.77.132.54");
        proxyIPs.add("113.255.121.46");
        proxyIPs.add("213.85.92.10");
        proxyIPs.add("212.232.52.56");
        proxyIPs.add("213.93.83.9");
        proxyIPs.add("113.252.219.128");
        proxyIPs.add("84.26.71.87");
        proxyIPs.add("178.82.146.9");
        proxyIPs.add("185.27.56.110");
        proxyIPs.add("84.107.88.151");
        proxyIPs.add("27.34.169.28");
        proxyIPs.add("199.8.233.107");
        proxyIPs.add("203.8.17.200");
        proxyIPs.add("88.159.224.143");
        proxyIPs.add("202.225.191.177");
        proxyIPs.add("77.174.24.254");
        proxyIPs.add("84.25.54.237");
        proxyIPs.add("188.166.103.115");
        proxyIPs.add("79.140.18.69");
        proxyIPs.add("219.90.56.76");
        //http://proxylist.hidemyass.com/search-1544294#listable ВСЕ, КРОМЕ КИТАЙСКИХ. можно ещё китайские добавить сюда. порт 80
        while(proxyIPs.iterator().hasNext()) {
            String ip = proxyIPs.iterator().next();
            System.out.println("opening proxy "+ip);
            logic.createDetailList(ip); 
            System.out.println("closing proxy "+ip);
        }
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
