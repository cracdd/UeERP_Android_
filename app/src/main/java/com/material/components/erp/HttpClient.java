package com.material.components.erp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpClient {

    private static final String WWW_FORM = "application/x-www-form-urlencoded";
    private int httpStatusCode; //상태
    private String body;



    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getBody() {
        return body;
    }

    private Builder builder;

    private void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void request() {
        HttpURLConnection conn = getConnection();
        setHeader(conn);
        setBody(conn);
        httpStatusCode = getStatusCode(conn);
        body = readStream(conn);
        conn.disconnect();
    }

    private HttpURLConnection getConnection() {
        try {
            URL url = new URL(builder.getUrl());
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setHeader(HttpURLConnection conn) {
        setContentType(conn);
        setRequestMethod(conn);

        conn.setConnectTimeout(5000);
        conn.setDoOutput(true);
        conn.setDoInput(true);
    }

    private void setContentType(HttpURLConnection conn) {
        conn.setRequestProperty("content-Type", WWW_FORM);
    }

    private void setRequestMethod(HttpURLConnection conn) {
        try {
            conn.setRequestMethod(builder.getMethod());
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    private void setBody(HttpURLConnection conn) {
        String parameter = builder.getParameter();
        if (parameter != null && parameter.length() > 0) {
            OutputStream outputStream = null;
            try {
                outputStream = conn.getOutputStream();
                outputStream.write(parameter.getBytes("UTF-8"));
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int getStatusCode(HttpURLConnection conn) {
        try {
            return conn.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -10;
    }

    private String readStream(HttpURLConnection conn) {
        String result = "";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static class Builder {
        private Map<String, String> parameters;
        private String method;
        private String url;

        public String getMethod() {
            return method;
        }

        public String getUrl() {
            return url;
        }

        // 스프링 컨트롤러에 url 요청시 호출
        public Builder(String method, String url) {
            if (method == null) {
                method = "GET";
            }
            this.method = method;
            this.url = url;
            this.parameters = new HashMap<>();
        }

        public void addOrReplace(String key, String value) {
            parameters.put(key, value);
        }

        public void addAllParameters(Map<String, String> param) {
            parameters.putAll(param);
        }

        public String getParameter() {
            return generateParameters();
        }

        public String getParameter(String key) {
            return this.parameters.get(key);
        }

        private String generateParameters() {
            StringBuffer urlParameters = new StringBuffer();

            Iterator keys = getKeys();

            String key = "";
            while (keys.hasNext()) {
                key = (String) keys.next();
                urlParameters.append(String.format("%s=%s", key, parameters.get(key)));
                urlParameters.append("&");
            }
            String params = urlParameters.toString();
            if (params.length() > 0) {
                params = params.substring(0, params.length() - 1);
            }
            return params;
        }

        private Iterator getKeys() {
            return this.parameters.keySet().iterator();
        }

        public HttpClient create() {
            HttpClient client = new HttpClient();
            client.setBuilder(this);
            return client;
        }
    }

}
