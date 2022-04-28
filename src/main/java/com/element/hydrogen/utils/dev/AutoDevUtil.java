package com.element.hydrogen.utils.dev;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AutoDevUtil
 * @Description 在逆向工程的基础上，根据模板半自动生成service，controller，vue等代码文件；
 * 将文件放到对应目录下即可正常调用
 * @Author yanyu
 * @Date 2022/2/1 0:31
 * @Version 1.0
 */
public class AutoDevUtil {

    public static void main(String[] args) throws IOException {

        //配置项
        String oldBase = "donLogInfo";  //donOld    --源名称（每次需要修改）
        String newBase = "donHlmRel"; //donNew ----目标名称（每次需要修改）
        String newModelNameBase = "红楼梦人物关系"; //donNew ----目标名称（每次需要修改）

        //两个字符串数组用于vue展示字段
        String[] ids = "relId,fromId,toId,relName,relType,relLevel,relStatus,remark".split(","); //用于vue
        String[] names = "关系ID,FROM_ID,TO_ID,关系名,关系类型,关系等级,关系状态,备注".split(",");  //用于vue

        //模块目录配置
        String new_Model = "graph";
        String serviceImport_Old = "com.element.hydrogen.service.monitor"; //一般不修改
        String serviceImport_New = "com.element.hydrogen.service."+new_Model; //新模块路径（根据需要修改）
        String entityImport_Old = "com.element.hydrogen.entity.monitor"; //一般不修改
        String entityImport_New = "com.element.hydrogen.entity."+new_Model; //新模块路径（根据需要修改）
        String mapperImport_Old = "com.element.hydrogen.mapper.monitor"; //一般不修改
        String mapperImport_New = "com.element.hydrogen.mapper."+new_Model; //新模块路径（根据需要修改）


        //读取特定目录下文件
        String oldPath = "C:\\Users\\yanyu\\Desktop\\唐吉坷德文档库\\4_Tool\\AutoDev\\resource"; //源文件基础路径（一般不需要修改）
        String newPathBase = "C:\\Users\\yanyu\\Desktop\\唐吉坷德文档库\\4_Tool\\AutoDev\\result"; //目标文件基础路径（一般不需要修改）
        File oldFiles = new File(oldPath);
        File[] oldFileList = oldFiles.listFiles();

        //源目录文件全部复制到新目录下（新旧文件的文件名相同）
        for (int i = 0; i < oldFileList.length; i++) {
            if (oldFileList[i].isFile()) {
                File oldFile = oldFileList[i];
                //新目录下文件全名
                String newPath = newPathBase+"\\"+oldFile.getName();
                FileChannel input = new FileInputStream(oldFile).getChannel();
                FileChannel output = new FileOutputStream(new File(newPath)).getChannel();
                output.transferFrom(input, 0, input.size());
                output.close();
                input.close();
            }
        }

        File newFiles = new File(newPathBase);
        File[] newFileList = newFiles.listFiles();

        String OldBase=oldBase.substring(0,1).toUpperCase().concat(oldBase.substring(1)); //DonOld
        String NewBase=newBase.substring(0,1).toUpperCase().concat(newBase.substring(1)); //DonNew

        String oldBase1 = null;
        String newBase1 = null;
        String OldBase1 = null;
        String NewBase1 = null;
        if (oldBase.startsWith("don",0)){
            OldBase1 = oldBase.substring(3, oldBase.length());
            oldBase1 = OldBase1.substring(0,1).toLowerCase().concat(OldBase1.substring(1)); //old
        }
        if (newBase.startsWith("don",0)){
            NewBase1 = newBase.substring(3, newBase.length());
            newBase1 = NewBase1.substring(0,1).toLowerCase().concat(NewBase1.substring(1)); //new
        }

        //Controller
        String Controller_Old = OldBase1!=null?OldBase1+"Controller":OldBase+"Controller";
        String Controller_New = NewBase1!=null?NewBase1+"Controller":NewBase+"Controller";
        //Service
        String Service_Old = OldBase1!=null?OldBase1+"Service":OldBase+"Service";
        String Service_New = NewBase1!=null?NewBase1+"Service":NewBase+"Service";
        //service
        String service_old = oldBase1!=null?oldBase1+"Service":oldBase+"Service";
        String service_new = newBase1!=null?newBase1+"Service":newBase+"Service";

        //Mapper
        String Mapper_Old = OldBase+"Mapper";
        String Mapper_New = NewBase+"Mapper";
        //mapper
        String mapper_old = oldBase+"Mapper";
        String mapper_new = oldBase+"Mapper";

        //Entity
        String Entity_Old = OldBase+"Entity";
        String Entity_New = NewBase+"Entity";
        //entity
        String entity_old = oldBase+"Entity";
        String entity_new = newBase+"Entity";
        //entityList
        String entityList_old = oldBase+"EntityList";
        String entityList_new = newBase+"EntityList";
        //@Date
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String oldDate = "@Date";
        String newDate = "@Date "+df.format(new Date());
        //api
        String oldApi = "/"+(oldBase1!=null?oldBase1:oldBase);
        String newApi = "/"+(newBase1!=null?newBase1:newBase);

        //fileName_Controller
        String oldFileName_Controller = Controller_Old+".java";
        String newFileName_Controller = Controller_New+".java";

        //fileName_Service
        String oldFileName_Service = Service_Old+".java";
        String newFileName_Service = Service_New+".java";

        //fileName_ServiceImpl
        String oldFileName_ServiceImpl = Service_Old+"Impl.java";
        String newFileName_ServiceImpl= Service_New+"Impl.java";

        //fileName_ServiceImpl
        String oldFileName_vue = oldBase1!=null?oldBase1+"Main.vue":oldBase+"Main.vue";
        String newFileName_vue = newBase1!=null?newBase1+"Main.vue":newBase+"Main.vue";

        //循环转换每一个文件中的配置项
        for (int i = 0; i < newFileList.length; i++) {
            if (newFileList[i].isFile()) {

                //处理controller
                if (oldFileName_Controller.equals(newFileList[i].getName())){
                    File newFile0 = new File(newFileList[i].getParent() + File.separator + oldFileName_Controller);
                    File newFile = new File(newFileList[i].getParent() + File.separator + newFileName_Controller);
                    if (newFile.exists()){
                        newFile.delete();
                    }
                    if (!newFile0.renameTo(newFile)){}
                    modifyFileContent(newFile,Controller_Old,Controller_New);
                    modifyFileContent(newFile,Service_Old,Service_New);
                    modifyFileContent(newFile,service_old,service_new);
                    modifyFileContent(newFile,Entity_Old,Entity_New);
                    modifyFileContent(newFile,entity_old,entity_new);
                    modifyFileContent(newFile,entityList_old,entityList_new);
                    modifyFileContent(newFile,oldDate,newDate);
                    modifyFileContent(newFile,oldApi,newApi);
                    modifyFileContent(newFile,serviceImport_Old,serviceImport_New);
                    modifyFileContent(newFile,entityImport_Old,entityImport_New);
                    modifyFileContent(newFile,mapperImport_Old,mapperImport_New);

                }

                //处理service
                if (oldFileName_Service.equals(newFileList[i].getName())){
                    File newFile0 = new File(newFileList[i].getParent() + File.separator + oldFileName_Service);
                    File newFile = new File(newFileList[i].getParent() + File.separator + newFileName_Service);
                    if (newFile.exists()){
                        newFile.delete();
                    }
                    if (!newFile0.renameTo(newFile)){}
                    modifyFileContent(newFile,Controller_Old,Controller_New);
                    modifyFileContent(newFile,Service_Old,Service_New);
                    modifyFileContent(newFile,service_old,service_new);
                    modifyFileContent(newFile,Entity_Old,Entity_New);
                    modifyFileContent(newFile,entity_old,entity_new);
                    modifyFileContent(newFile,entityList_old,entityList_new);
                    modifyFileContent(newFile,oldDate,newDate);
                    modifyFileContent(newFile,oldApi,newApi);
                    modifyFileContent(newFile,serviceImport_Old,serviceImport_New);
                    modifyFileContent(newFile,entityImport_Old,entityImport_New);
                    modifyFileContent(newFile,mapperImport_Old,mapperImport_New);
                }
                //处理serviceImpl
                if (oldFileName_ServiceImpl.equals(newFileList[i].getName())){
                    File newFile0 = new File(newFileList[i].getParent() + File.separator + oldFileName_ServiceImpl);
                    File newFile = new File(newFileList[i].getParent() + File.separator + newFileName_ServiceImpl);
                    if (newFile.exists()){
                        newFile.delete();
                    }
                    if (!newFile0.renameTo(newFile)){}
                    modifyFileContent(newFile,Controller_Old,Controller_New);
                    modifyFileContent(newFile,Service_Old,Service_New);
                    modifyFileContent(newFile,service_old,service_new);
                    modifyFileContent(newFile,Mapper_Old,Mapper_New);
                    modifyFileContent(newFile,mapper_old,mapper_new);
                    modifyFileContent(newFile,Entity_Old,Entity_New);
                    modifyFileContent(newFile,entity_old,entity_new);
                    modifyFileContent(newFile,entityList_old,entityList_new);
                    modifyFileContent(newFile,oldDate,newDate);
                    modifyFileContent(newFile,oldApi,newApi);
                    modifyFileContent(newFile,serviceImport_Old,serviceImport_New);
                    modifyFileContent(newFile,entityImport_Old,entityImport_New);
                    modifyFileContent(newFile,mapperImport_Old,mapperImport_New);
                }
                //处理vue
                String oldModelName = "titleName:''";
                String newModelName = "titleName:'"+newModelNameBase+"'";
                StringBuilder tableStrs = new StringBuilder();
                StringBuilder insStrs = new StringBuilder();
                StringBuilder updsStrs = new StringBuilder();
                for (int k = 0; k < ids.length; k++) {
                    String tableStr = "         <el-table-column prop=\""+ids[k]+"\" label=\""+names[k]+"\" min-width=\"150px\"></el-table-column>";
                    tableStrs.append(tableStr);
                    if(k != ids.length-1){
                        tableStrs.append("\r\n");
                    }
                }

                String model = "";
                for (int h = 0; h < 2; h++) {
                    if (h == 0){
                        model = "insForm.";
                    }else {
                        model = "updForm.";
                    }
                    StringBuilder tmpStrs = new StringBuilder();
                    tmpStrs.append("            <el-row>");
                    tmpStrs.append("\r\n");
                    for (int j = 0; j < ids.length; j++) {
                        tmpStrs.append("                <el-col :span=\"10\">");
                        tmpStrs.append("\r\n");
                        tmpStrs.append("                    <el-form-item label=\""+names[j]+"\" prop=\""+ids[j]+"\">");
                        tmpStrs.append("\r\n");
                        tmpStrs.append("                        <el-input v-model=\""+model+ids[j]+"\" placeholder=\""+names[j]+"\"/>");
                        tmpStrs.append("\r\n");
                        tmpStrs.append("                    </el-form-item>");
                        tmpStrs.append("\r\n");
                        tmpStrs.append("                </el-col>");
                        tmpStrs.append("\r\n");
                        if ((j+1)%2==0){
                            tmpStrs.append("            </el-row>");
                            tmpStrs.append("\r\n");
                            tmpStrs.append("            <el-row>");
                            tmpStrs.append("\r\n");
                        }
                        if(j+1 == ids.length){
                            tmpStrs.append("            </el-row>");
                        }
                    }
                    if (h == 0){
                        insStrs = tmpStrs;
                    }else {
                        updsStrs = tmpStrs;
                    }
                }

                if (oldFileName_vue.equals(newFileList[i].getName())){
                    File newFile0 = new File(newFileList[i].getParent() + File.separator + oldFileName_vue);
                    File newFile = new File(newFileList[i].getParent() + File.separator + newFileName_vue);
                    if (newFile.exists()){
                        newFile.delete();
                    }
                    if (!newFile0.renameTo(newFile)){}
                    modifyFileContent(newFile,Controller_Old,Controller_New);
                    modifyFileContent(newFile,Service_Old,Service_New);
                    modifyFileContent(newFile,service_old,service_new);
                    modifyFileContent(newFile,Mapper_Old,Mapper_New);
                    modifyFileContent(newFile,mapper_old,mapper_new);
                    modifyFileContent(newFile,Entity_Old,Entity_New);
                    modifyFileContent(newFile,entity_old,entity_new);
                    modifyFileContent(newFile,entityList_old,entityList_new);
                    modifyFileContent(newFile,oldDate,newDate);
                    modifyFileContent(newFile,oldApi,newApi);

                    modifyFileContent(newFile,"MatchingTable",tableStrs.toString());
                    modifyFileContent(newFile,"MatchingInsert",insStrs.toString());
                    modifyFileContent(newFile,"MatchingUpdate",updsStrs.toString());
                    modifyFileContent(newFile,oldModelName,newModelName);

                }

            }
        }

    }



    private static boolean modifyFileContent(File file, String oldstr, String newStr) {
        List<String> list = null;
        try {
            list = FileUtils.readLines(file, "UTF-8");
            for (int i = 0; i < list.size(); i++) {
                String temp = list.get(i).replaceAll(oldstr, newStr);
                list.remove(i);
                list.add(i, temp);
            }
            FileUtils.writeLines(file, "UTF-8", list, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}
