package util;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParamsUtil {

    /**
     * 接收到的params map转化为我们需要的map
     *
     * @param params
     * @return
     */
    @Deprecated
    public static Map<String, Object> params2Map(Map<String, Object> params) {
        if (null == params.get("params")) {
            return new HashMap<>();
        }
        return ((Map) JSONUtils.parse(params.get("params") + ""));

    }

    /**
     * 接收到的params转化为我们需要的map
     *
     * @param params
     * @return
     */
    public static Map<String, Object> params2Map(String params) {
        Map maps = (Map) JSON.parse(params);
        if (maps == null) {
            maps = new HashMap();
        }
        return maps;
    }

    /**
     * 手机号验证
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 电话号码验证
     */
    public static boolean isPhone(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean b = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
    }

    /**
     * 电话手机号验证
     */
    public static boolean isPhoneAndMobile(String str) {
        return isPhone(str) || isMobile(str);
    }
}
