//
//import java.io.BufferedInputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//
//import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.codec.digest.DigestUtils;
//
//
///**
// * @Author: yanshilong
// * @Date: 18-9-8 下午11:29
// * @Version 1.0
// */
//public class OcrTest {//"/home/syl/图片/2018-07-15 09-49-48 的屏幕截图.png"
//
//
//        /**
//         * 科大讯飞语音识别写入参考
//         * https://github.com/IflytekAIUI/DemoCode/blob/master/webapi/java/Iat.java
//         */
//        final static String APPID="**",APPKEY="**";
//        final static String url = "http://api.xfyun.cn/v1/service/v1/tts/";
//        public static void sendPost( String text)throws Exception{
//            Base64 base64 = new Base64();
//            try {
//                URL httpUrl  = new URL(url);
//                String param = "{\"auf\":\"audio/L16;rate=16000\",\"aue\":\"lame\",\"voice_name\":\"xiaoyan\",\"speed\":\"50\",\"volume\":\"80\",\"pitch\":\"50\",\"engine_type\":\"intp65\",\"text_type\":\"text\"}";
//                String paramBase64=base64.encodeAsString( param.getBytes("UTF-8"));
////建立连接
//                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
//                conn.setRequestMethod("POST");
//
//                String currentTimeMillis =System.currentTimeMillis() / 1000L + "";
//                String md5Hex = DigestUtils.md5Hex( (APPKEY + currentTimeMillis + paramBase64).getBytes());
//
//                conn.setRequestProperty("X-CurTime", currentTimeMillis);
//                conn.setRequestProperty("X-Param",paramBase64);
//                conn.setRequestProperty("X-Appid",APPID);
//                conn.setRequestProperty("X-CheckSum", md5Hex);
//                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
//
//// 设置请求 body
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//
////设置连接超时和读取超时时间
//                conn.setConnectTimeout(20000);
//                conn.setReadTimeout(20000);
//
//                conn.connect();
//                //POST请求
//                OutputStream out = conn.getOutputStream();
//                out.write(("text="+text).getBytes());
//                out.flush()
//                ;
//                //读取响应
//                BufferedInputStream reader = new BufferedInputStream(  conn.getInputStream());
//                String headerField = conn.getHeaderField("Content-type");
//                System.out.println(headerField);
//                out.close();
//                if( headerField.equalsIgnoreCase("text/plain") ){
//                    System.out.println("错误");
//                }else{
//                    OutputStream outs = new FileOutputStream("C:/Users/lilin/Desktop/a.mp3");
//                    int size = 0, len = 0;
//                    byte[] buf = new byte[1024];
//                    while ((size = reader.read(buf)) != -1) {
//                        len += size;  outs.write(buf, 0, size);
//                    }
//                    outs.close();
//                    reader.close();
//                }
//                conn.disconnect();
//
//            } catch (Exception e) { e.printStackTrace();   }
//
//        }
//
//
//
////    //c22e94b9c5f28398aafbbb63ae52afe2
////    public String Test(String path) {
////        OpenPng pp = new OpenPng();
////        String file_content = pp.OcrTest(path);
////        String appid="5b8eaa33";
////        BASE64Encoder base64 = new sun.misc.BASE64Encoder();
////        String appkey="c22e94b9c5f28398aafbbb63ae52afe2";
////        String ttpUrl="http://webapi.xfyun.cn/v1/service/v1/ocr/general";
//////    URL url = new URL(httpUrl);
//////    HttpURLConnection connection = (HttpURLConnection) url
//////            .openConnection();
//////            connection.setRequestMethod("POST");
//////            connection.setRequestProperty("Content-Type",
//////                    "application/x-www-form-urlencoded");
//////    // 填入apikey到HTTP header
//////            connection.setRequestProperty("apikey", "您自己的apikey");
//////            connection.setDoOutput(true);
//////            connection.getOutputStream().write(httpArg.getBytes("UTF-8"));
//////            connection.connect();
//////    InputStream is = connection.getInputStream();
//////    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//////    String strRead = null;
//////            while ((strRead = reader.readLine()) != null) {
//////        sbf.append(strRead);
//////        sbf.append("\r\n");
//////    }
//////            reader.close();
//////    result = sbf.toString();
//////} catch (Exception e) {
//////        e.printStackTrace();
//////        }
//////        return result;
////
////        try {
////            URL url=new URL(ttpUrl);
////            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
////            connection.setRequestMethod("POST");
////            String TimeMillis =System.currentTimeMillis() / 1000L + "";
//////         String   x_param = base64.encode(json.dumps(param).replace(' ', ''))
//////            connection.setRequestProperty("Content-Type",
//////                    "application/x-www-form-urlencoded");
//////            connection.setRequestProperty("apikey", appkey);
//////            connection.setDoOutput(true);
//////            connection.getOutputStream().write(httpArg.getBytes("UTF-8"));
////
////        } catch (MalformedURLException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        return "";
////    }
////}
//
//
//
////    def main():
////    f = open("IMAGE_PATH", 'rb')
////    file_content = f.read()
////    base64_image = base64.b64encode(file_content)
////    body = urllib.urlencode({'image': base64_image})
////
////    url = 'http://webapi.xfyun.cn/v1/service/v1/ocr/general'
////    api_key = 'API_KEY'
////    param = {"language": "en", "location": "true"}
////
////    x_appid = 'APPID'
////    x_param = base64.b64encode(json.dumps(param).replace(' ', ''))
////    x_time = int(int(round(time.time() * 1000)) / 1000)
////    x_checksum = hashlib.md5(api_key + str(x_time) + x_param).hexdigest()
////    x_header = {'X-Appid': x_appid,
////            'X-CurTime': x_time,
////            'X-Param': x_param,
////            'X-CheckSum': x_checksum}
////    req = urllib2.Request(url, body, x_header)
////    result = urllib2.urlopen(req)
////    result = result.read()
////    print result
////    return
////
////
////            if __name__ == '__main__':
////    main()
//
////        }