package me.hatter.tests.https;

import java.io.IOException;

import me.hatter.tools.commons.network.HttpTool;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

public class OkHTTPTest {

    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        System.out.println(client.newCall(new Request.Builder().url("https://www.baidu.com/").build()).execute().body().string());
        System.out.println(HttpTool.defaultInstance().url("https://wiki.hellosecurity.org/").read());
    }
}
