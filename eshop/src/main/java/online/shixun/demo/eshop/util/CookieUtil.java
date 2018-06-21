package online.shixun.demo.eshop.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;

public final class CookieUtil {
    /**
     * 保存Cookie
     *
     * @param response    响应对象
     * @param cookieName  Cookie 名称
     * @param cookieValue Cookie 数据
     * @throws IOException
     */
    public static void saveCookie(HttpServletResponse response, String cookieName, Object cookieValue) throws IOException {
        //JSON/对象转换工具
        ObjectMapper transition = new ObjectMapper();
        transition.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //将对象转换成JSON
        Writer writer = new StringWriter();
        transition.writeValue(writer, cookieValue);

        //新建Cookie进行保存
        Cookie cookie = new Cookie(cookieName, formattingJsonWriter(writer.toString()));
        //设置path是可以共享cookie
        cookie.setPath("/");
        //设置Cookie过期时间: -1 表示关闭浏览器失效  0: 立即失效  >0: 单位是秒, 多少秒后失效
        cookie.setMaxAge(7 * 24 * 60 * 60);//缓存一周
        //将Cookie写到浏览器
        response.addCookie(cookie);
    }

    /**
     * 清空Cookie
     *
     * @param response   响应对象
     * @param cookieName 需要清空Cookie的名称
     * @throws IOException
     */
    public static void emptyCookie(HttpServletResponse response, String cookieName) throws IOException {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setPath("/");
        //清空Cookie 设置存活时间为0, 立马销毁
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * 读取Cookie
     *
     * @param request    请求对象
     * @param cookieName 读取Cookie的名称
     * @param classType  将Cookie转换成的对象类型
     * @param <T>
     * @return Cookie信息对应的对象
     * @throws IOException
     */
    public static <T> Object readCookie(HttpServletRequest request, String cookieName, Class<T> classType) throws IOException, IllegalAccessException, InstantiationException {
        //JSON/对象转换工具
        ObjectMapper transition = new ObjectMapper();
        transition.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //获取Cookie
        Cookie[] cookies = request.getCookies();
        if (Objects.nonNull(cookies) && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Objects.equals(cookieName, cookie.getName())) {
                    //将json转换成对象
                    return transition.readValue(formattingJsonRead(cookie.getValue()), classType);
                }
            }
        }
        return classType.newInstance();
    }

    /**
     * 格式化从Cookie中读取的JSON
     *
     * @param json 类似JSON的字符串
     * @return 标准JSON
     */
    private static String formattingJsonRead(String json) {
        return json.replaceAll("#", ",").replaceAll("'", "\"");
    }

    /**
     * 格式化写入Cookie 的JSON非法字符,Cookie中不允许出现,和"因此,和"被替换为#和'
     *
     * @param json 标准JSON
     * @return 格式化后的类似JSON的字符串
     */
    private static String formattingJsonWriter(String json) {
        return json.replaceAll(",", "#").replaceAll("\"", "'");
    }
}
