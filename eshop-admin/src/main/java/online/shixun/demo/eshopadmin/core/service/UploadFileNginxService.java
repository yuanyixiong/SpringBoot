package online.shixun.demo.eshopadmin.core.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 文件上传nginx文件服务器服务
 */
@Component("uploadFileNginx")
public class UploadFileNginxService {

    @Value("${system.file.images.service.nginxManagerURL}")
    private String nginxManagerURL;


    // [HTTP请求]换行符
    final String newLine = "\r\n";
    final String boundaryPrefix = "--";
    // [HTTP请求]定义数据分隔线
    final String boundary = "========7d4a6d158c9";

    /**
     * java net io  模拟post请求上传文件到nginx中
     *
     * @param name        请求参数名称
     * @param value       请求参数的值[文件名]
     * @param inputStream 上传的文件的流
     * @return
     */
    public String upload(String method,String name, String value, InputStream inputStream) {
        //请求响应的数据
        StringBuilder result = new StringBuilder();
        BufferedReader reader = null;
        try {
            // 服务器的域名
            URL url = new URL(String.format("%s%s", nginxManagerURL, method));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置为POST情
            connection.setRequestMethod("POST");

            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);

            // 设置请求头参数
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Charsert", "UTF-8");
            connection.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", boundary));

            // 上传文件
            StringBuilder uploadFile = new StringBuilder();
            uploadFile.append(boundaryPrefix);
            uploadFile.append(boundary);
            uploadFile.append(newLine);

            // 文件参数
            //name为表单的名称
            //value为表单的值，此处为文件名称
            uploadFile.append(String.format("Content-Disposition: form-data;name=%s;filename=%s", name, value));
            uploadFile.append(newLine);

            uploadFile.append("Content-Type:application/octet-stream");
            // 参数头设置完以后需要两个换行，然后才是参数内容
            uploadFile.append(newLine);
            uploadFile.append(newLine);

            // 将参数头的数据写入到输出流中
            OutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(uploadFile.toString().getBytes());

            // 数据输入流,用于读取文件数据
            DataInputStream in = new DataInputStream(inputStream);
            byte[] bufferOut = new byte[1024];
            int bytes = 0;
            // 每次读1KB数据,并且将文件数据写入到输出流中
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            // 最后添加换行
            out.write(newLine.getBytes());
            in.close();

            // 定义最后数据分隔线，即--加上BOUNDARY再加上--。
            byte[] end_data = String.format("%s%s%s%s%s", newLine, boundaryPrefix, boundary, boundaryPrefix, newLine).getBytes();

            // 写上结尾标识
            out.write(end_data);
            out.flush();
            out.close();

            // 定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * 发送GETT方法的请求
     *
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public String sendGET(String method, String param) {
        //请求响应的数据
        BufferedReader reader = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(String.format("%s%s?%s", nginxManagerURL, method, param));
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
//
//    /**
//     * 发送POST方法的请求
//     *
//     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @return 所代表远程资源的响应结果
//     */
//    public String sendPost(String method, String param) {
//        PrintWriter writer = null;
//        BufferedReader reader = null;
//        StringBuilder result = new StringBuilder();
//        try {
//            URL realUrl = new URL(String.format("%s%s?%s", nginxManagerURL, method));
//            // 打开和URL之间的连接
//            URLConnection conn = realUrl.openConnection();
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            writer = new PrintWriter(conn.getOutputStream());
//            // 发送请求参数
//            writer.print(param);
//            // flush输出流的缓冲
//            writer.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                result.append(line);
//            }
//        } catch (Exception e) {
//            System.out.println("发送 POST 请求出现异常！" + e);
//            e.printStackTrace();
//        } finally {
//            try {
//                if (writer != null) {
//                    writer.close();
//                }
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return result.toString();
//    }

}
