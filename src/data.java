import com.alibaba.fastjson.JSON;
import java.lang.reflect.Field;
import java.util.*;

public class data {
    public static void main(String[] args)
    {
        List<DisplayFieldInfo> infos = new ArrayList<>();
        Class cl = CSCZZ.class;
        Field[] fields = cl.getFields();
        for(int j = 0;j<fields.length;j++) {
            Field field = fields[j];
            DisplayFieldInfo info = new DisplayFieldInfo();
            if(field.getName() == "TestField02")
            {
                //combobox
                info.comboItems = "新增,0;已计划,1;已审核,2;";
                info.gridEditor = "{\"type\":\"combobox\",\"options\":{\"require\":\"true\",\"editable\":\"true\",\"data\":data,\"valueField\":\"key\",\"textField\":\"value\",\"panelHeight\":\"100\"}}";
            }
            else if(field.getName() == "TestField03"){
                //checkbox
                info.gridEditor = "{\"type\":\"checkbox\",\"options\":{\"on\":\"是\",\"off\":\"否\"}";
            }else if(field.getName() == "TestField04"){
                //datepicker
                info.gridEditor = "{\"type\":\"datebox\"}";
            }else if(field.getName() == "TestField05" || field.getName() == "TestField06"){
                // 固定列
                info.gridEditor = "{\"type\":\"textbox\"}";
                info.fixedOnGrid = true;
            }else{
                info.gridEditor = "{\"type\":\"textbox\"}";
            }
            infos.add(info);
        }
        String jsonData = JSON.toJSONString(infos);
        //生成 .json文件
        CreateFileUtil.createJsonFile(jsonData,"C:\\Users\\Client00\\Desktop","控件模拟信息");
        //获取DisplayFieldInfo的所有字段
        Map<String,String> titleMap = new LinkedHashMap<String,String>();
        Class cls = DisplayFieldInfo.class;
        Field[] field1 = cls.getFields();
        for(int k = 0;k<field1.length;k++) {
            titleMap.put(""+field1[k].getName()+"",field1[k].getName());
        }
        String sheetName = "控件模拟数据";
        System.out.println("start导出");
        long start = System.currentTimeMillis();
        ExportExcel.excelExport(infos, titleMap, sheetName);
        long end = System.currentTimeMillis();
        System.out.println("end导出");
        System.out.println("耗时："+(end-start)+"ms");
    }


}
