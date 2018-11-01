import java.io.*;
import java.util.Enumeration;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.util.zip.ZipOutputStream;

/**
 * 解压Zip文件工具类
 *
 * @author zhangyongbo
 */
public class ZipUtil {
    private static final int buffer = 2048;

    /**
     * @param file    要压缩的文件
     * @param zipFile 压缩文件存放地方
     */
    public static void zip(File file, File zipFile) {
        ZipOutputStream outputStream = null;
        try {
            if (!zipFile.exists()) {
                throw new RuntimeException(zipFile + "不存在！");
            }
            if (!file.exists()) {
                throw new RuntimeException(file + "不存在！");
            }
            outputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            zipFile(outputStream, file, "");
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @param output   ZipOutputStream对象
     * @param file     要压缩的文件或文件夹
     * @param basePath 条目根目录
     */
    private static void zipFile(ZipOutputStream output, File file, String basePath) {
        FileInputStream input = null;
        try {
            // 文件为目录
            if (file.isDirectory()) {
                // 得到当前目录里面的文件列表
                File list[] = file.listFiles();
                basePath = basePath + (basePath.length() == 0 ? "" : "/")
                        + file.getName();
                // 循环递归压缩每个文件
                for (File f : list) {
                    zipFile(output, f, basePath);
                }
            } else {
                // 压缩文件
                basePath = (basePath.length() == 0 ? "" : basePath + "/")
                        + file.getName();
                output.putNextEntry(new ZipEntry(basePath));
                input = new FileInputStream(file);
                int readLen = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((readLen = input.read(buffer, 0, 1024 * 8)) != -1) {
                    output.write(buffer, 0, readLen);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭流
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * @param sourceZip 待解压文件路径
     * @param destDir   解压到的路径
     */
    public static void unZip(String sourceZip, String destDir) {
        //保证文件夹路径最后是"/"或者"\"
        char lastChar = destDir.charAt(destDir.length() - 1);
        if (lastChar != '/' && lastChar != '\\') {
            destDir += File.separator;
        }
        Project p = new Project();
        Expand e = new Expand();
        e.setProject(p);
        e.setSrc(new File(sourceZip));
        e.setOverwrite(false);
        e.setDest(new File(destDir));
        /*
             ant下的zip工具默认压缩编码为UTF-8编码，
             而winRAR软件压缩是用的windows默认的GBK或者GB2312编码
             所以解压缩时要制定编码格式
         */
        e.setEncoding("gbk");
        e.execute();
    }

    /**
     * 解压Zip文件
     * @param path 文件目录
     */
    public static void unZip(String path) {
        int count = -1;
        String savepath = "";

        File file = null;
        InputStream is = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        savepath = path.substring(0, path.lastIndexOf(".")) + File.separator; //保存解压文件目录
        new File(savepath).mkdir(); //创建保存目录
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(path, "gbk"); //解决中文乱码问题
            Enumeration<?> entries = zipFile.getEntries();

            while (entries.hasMoreElements()) {
                byte buf[] = new byte[buffer];

                ZipEntry entry = (ZipEntry) entries.nextElement();

                String filename = entry.getName();
                boolean ismkdir = false;
                if (filename.lastIndexOf("/") != -1) { //检查此文件是否带有文件夹
                    ismkdir = true;
                }
                filename = savepath + filename;
                //如果是文件夹先创建
                if (entry.isDirectory()) {
                    file = new File(filename);
                    file.mkdirs();
                    continue;
                }
                file = new File(filename);
                //如果是目录先创建
                if (!file.exists()) {
                    if (ismkdir) {
                        //目录先创建
                        new File(filename.substring(0, filename.lastIndexOf("/"))).mkdirs();
                    }
                }
                file.createNewFile(); //创建文件

                is = zipFile.getInputStream(entry);
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos, buffer);

                while ((count = is.read(buf)) > -1) {
                    bos.write(buf, 0, count);
                }
                bos.flush();
                bos.close();
                fos.close();

                is.close();
            }

            zipFile.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
//        String sourcePath = "C:\\Users\\Client00\\Desktop\\110000002.zip";
//        String destPath = "C:\\Users\\Client00\\Desktop\\11";
//        unZip(sourcePath, destPath);

        zip(new File("C:\\Users\\Client00\\Desktop\\22"), new File("C:\\Users\\Client00\\Desktop\\110000002.zip"));

//        unZip("C:\\Users\\Client00\\Desktop\\110000002.zip");
//
//        String f = "C:\\Users\\Client00\\Desktop\\110000002\\110000002";
//        File file = new File(f);
//        if (!file.exists()) {
//            throw new RuntimeException(f + "不存在！");
//        }
//        String[] test = file.list();
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test[i]);
//        }
//
//        System.out.println("------------------");
//
//        String fileName = "";
//
//        File[] tempList = file.listFiles();
//        for (int i = 0; i < tempList.length; i++) {
//            if (tempList[i].isFile()) {
//                System.out.println("文     件：" + tempList[i]);
//
//                fileName = tempList[i].getName();
//
//                System.out.println("文件名：" + fileName);
//            }
//            if (tempList[i].isDirectory()) {
//                System.out.println("文件夹：" + tempList[i]);
//            }
//        }
//
    }
}