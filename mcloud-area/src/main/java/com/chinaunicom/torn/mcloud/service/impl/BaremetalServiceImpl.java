package com.chinaunicom.torn.mcloud.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.torn.mcloud.cloudboot.payload.CloudbootLoginPayload;
import com.chinaunicom.torn.mcloud.domain.vo.CloudbootTokenEntity;
import com.chinaunicom.torn.mcloud.cloudboot.enums.CloudbootAPIEnum;
import com.chinaunicom.torn.mcloud.service.BaremetalService;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

/**
 * @Author MingChao Jin
 * @Date 2021/6/7 10:36
 * @Description: TODO
 */
@Service
public class BaremetalServiceImpl implements BaremetalService {

    @Override
    public Optional<CloudbootTokenEntity> loginCloudboot(String host, String username, String password) {
        try {
            HttpPost post = this.buildCloudbootPost(host, CloudbootAPIEnum.LOGIN, new CloudbootLoginPayload(username, password));

            CloseableHttpResponse response = HttpClients.createDefault().execute(post);
            String resultString = EntityUtils.toString(response.getEntity());
            JSONObject result = JSONObject.parseObject(resultString);

            CloudbootTokenEntity entity = new CloudbootTokenEntity();
            entity.setHost(host);
            entity.setToken(result.getJSONObject("Content").getString("AccessToken"));
            Header[] headers = response.getHeaders("Set-Cookie");
            if (headers.length == 0) {
                return Optional.empty();
            }
            entity.setCookie(headers[0].getValue());

            return Optional.of(entity);
        }
        catch (Exception ex) {
            ex.printStackTrace();

//            this.logService.error(BaremetalServiceImpl.logFactory.product()
//                    .who(ServiceRole.PROMOTER).how(LogHow.CALL).what("RPC Cloudboot login API failed").why(ex.getMessage()).build());

            return Optional.empty();
        }
    }

    private <T> HttpPost buildCloudbootPost(String host, CloudbootAPIEnum api, T payload) throws UnsupportedEncodingException {
        String url = api.url(host);
        String serializedPayload = JSONObject.toJSONString(payload);
        HttpPost result = new HttpPost(url);
        result.setHeader("Content-Type", "application/json;charset=utf-8");

        result.setEntity(new StringEntity(serializedPayload, "utf-8"));

//        this.logService.info(BaremetalServiceImpl.logFactory.product()
//                .how(LogHow.CALL).what(String.format("HTTP POST url: %s, payload: %s", url, serializedPayload)).build());

        return result;
    }
}
