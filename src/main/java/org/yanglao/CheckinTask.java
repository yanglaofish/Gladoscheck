package org.yanglao;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
@Log4j
public class CheckinTask {
    private final OkHttpClient client ;
    private final Config config;
    private Request request;
    public CheckinTask(){
        this.client = new OkHttpClient();
        this.config = new Config("Config.yaml");
        buildClient();

    }

    private void buildClient(){
        client.newBuilder().build();
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),config.find("BODY"));
        this.request = new Request.Builder()
                .url(config.find("URL"))
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", config.find("COOKIE"))
                //.addHeader("Authorization","35760725020723938811840811722317-1080-1920")
                .addHeader("authority","glados.rocks")
                .post(body)
                .build();

    }

    /**
     * 执行签到
     * @throws IOException 捕获错误
     */
    public void Check() throws IOException
    {
        try{//尝试请求
            Call call = client.newCall(request);
            Response response = call.execute();
            if(response.code()==200){
                log.info("Checkin Success!");
                System.out.println("Checkin Success!");
            }
            //System.out.println(response.body().string());
        }catch (IOException e){
            log.error("Error! Checkin Failed!");
            e.printStackTrace();
            System.out.println("Error! Checkin Failed!");
            throw e ;
        }
    }


}
//yaml配置文件读取
@Log4j
class Config{
    private Yaml config;
    private String Filename;

    private Map<String, String> input;

    /**
     * 读取配置文件
     * @param Filename 文件名
     */
    public Config(String Filename){
        this.config = new Yaml();
        this.Filename = Filename;
        this.input=new HashMap<>();
        try{
            InputStream inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream(Filename);
            input = config.load(inputStream);
        }catch (Exception e){
            log.error("Error! Config File READ ERROR!");
            System.out.println("Error! Config File READ ERROR!");
        }
    }

    /**
     * 通过key查找value
     * @param key 要查找的字段
     * @return 返回值
     */
    public String find(String key){
        //System.out.println(input.get(key));
        return input.get(key);
    }
}
