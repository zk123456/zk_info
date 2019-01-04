package com.zk.easyexcel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.collect.Lists;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Zhangk
 * @Date 13:49 2018/11/13
 * @Description
 */
public class Excel {

    public static void writeExcel() {
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\Administrator.000\\Desktop\\test.xlsx");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("第一个sheet");
            writer.write0(getListString(), sheet1);
            writer.write(Lists.newArrayList(), sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<List<String>> getData() {
        List<List<String>> list = Lists.newArrayList();
        for(int i=0;i<10;i++) {
            List<String> temp = Lists.newArrayList();
            temp.add(String.valueOf(i));
            list.add(temp);
        }
        return list;
    }

    private static List<List<String>> getListString() {
        List list = new ArrayList();
        list.add("ooo1");
        list.add("ooo2");
        list.add("ooo3");
        list.add("ooo4");
        List list1 = new ArrayList();
        list1.add("ooo1");
        list1.add("ooo2");
        list1.add("ooo3");
        list1.add("ooo4");
        List<List<String>> ll = Lists.newArrayList();
        ll.add(list);
        ll.add(list1);
        return ll;
    }

    public static void testExcel2003NoModel() {
        File file = new File("C:\\Users\\Administrator.000\\Desktop\\123.xls");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null,
                    new AnalysisEventListener<List<String>>() {
                        @Override
                        public void invoke(List<String> object, AnalysisContext context) {
                            System.out.println(
                                    "当前sheet:" + context.getCurrentSheet().getSheetNo() + " 当前行：" + context.getCurrentRowNum()
                                            + " data:" + object);
                            /**
                             * 当前sheet:1 当前行：0 data:[1]
                             当前sheet:1 当前行：1 data:[2]
                             当前sheet:1 当前行：2 data:[3]
                             当前sheet:1 当前行：3 data:[4]
                             */
                        }
                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {

                        }
                    });

            reader.read();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testExcel2007NoModel() {
        File file = new File("C:\\Users\\Administrator.000\\Desktop\\123456.xlsx");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null,
                    new AnalysisEventListener<List<String>>() {
                        @Override
                        public void invoke(List<String> object, AnalysisContext context) {
                            System.out.println(
                                    "当前sheet:" + context.getCurrentSheet().getSheetNo() + " 当前行：" + context.getCurrentRowNum()
                                            + " data:" + object);
                            /**
                             * 当前sheet:1 当前行：0 data:[1, 2, 3, 4, 5, 6, 7, null, null, null, null, null, null, null, null, null, null, null, null, null]
                             当前sheet:1 当前行：1 data:[2, 3, 4, 5, 6, 7, 8, null, null, null, null, null, null, null, null, null, null, null, null, null]
                             */
                        }
                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {

                        }
                    });

            reader.read();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testExcelNoModelAndHasListener() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\Administrator.000\\Desktop\\123.xls");
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
            //ExcelReader excelReader = new ExcelReader(inputStream, null, listener);
            excelReader.read();
        } catch (Exception e) {
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * down excel
     * @param request
     * @param response
     */
    public void cooperation(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServletOutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
            String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                    .getBytes(), "UTF-8");
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("第一个sheet");
            writer.write0(getListString(), sheet1);
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
            out.flush();
        }catch (Exception e){

        }


}

    public static void main(String []args) {
        writeExcel();
        //testExcel2007NoModel();
        //testExcel2003NoModel();
        //testExcelNoModelAndHasListener();
    }
}
