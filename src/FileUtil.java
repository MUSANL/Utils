import java.io.*;
import java.text.DateFormat;
import java.util.*;

/**
 *
 * 功能描述：
 *
 * @author Administrator
 * @Date Jul 19, 2008
 * @Time 9:46:11 AM
 * @version 1.0
 */
public class FileUtil {

    /**
     * 功能描述：列出某文件夹及其子文件夹下面的文件，并可根据扩展名过滤
     *
     * @param path
     *            文件夹
     */
    public static void list(File path) {
        if (!path.exists()) {
            System.out.println("文件名称不存在!");
        } else {
            if (path.isFile()) {
                if (path.getName().toLowerCase().endsWith(".pdf")
                        || path.getName().toLowerCase().endsWith(".doc")
                        || path.getName().toLowerCase().endsWith(".chm")
                        || path.getName().toLowerCase().endsWith(".html")
                        || path.getName().toLowerCase().endsWith(".htm")) {// 文件格式
                    System.out.println(path);
                    System.out.println(path.getName());
                }
            } else {
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++) {
                    list(files[i]);
                }
            }
        }
    }

    /**
     * 功能描述：拷贝一个目录或者文件到指定路径下，即把源文件拷贝到目标文件路径下
     *
     * @param source
     *            源文件
     * @param target
     *            目标文件路径
     * @return void
     */
    public static void copy(File source, File target) {
        File tarpath = new File(target, source.getName());
        if (source.isDirectory()) {
            tarpath.mkdir();
            File[] dir = source.listFiles();
            for (int i = 0; i < dir.length; i++) {
                copy(dir[i], tarpath);
            }
        } else {
            try {
                InputStream is = new FileInputStream(source); // 用于读取文件的原始字节流
                OutputStream os = new FileOutputStream(tarpath); // 用于写入文件的原始字节的流
                byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
                int len = 0;
                while ((len = is.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                is.close();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("F:\\Tomcat");
        list(file);
        Date myDate = new Date();
        DateFormat df = DateFormat.getDateInstance();
        System.out.println(df.format(myDate));
    }

}



