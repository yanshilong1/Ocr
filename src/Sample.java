import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * @Author: yanshilong
 * @Date: 18-9-9 上午1:30
 * @Version 1.0
 */
public class Sample {
    public static final String APP_ID = "11790704";
    public static final String API_KEY = "EVKfOuLdQhg9PLoIOzZo545v";
    public static final String SECRET_KEY = "KO8cTEqAiIumcqSFUhnUagKv4Iy6qKxX";




    public static void main(String[] args) {
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "/home/syl/图片/2018-09-09 01-51-31 的屏幕截图.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
//

     





    }



    }

