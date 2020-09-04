package org.inh3rit.financial.spider;

import org.inh3rit.financial.dao.SecurityMapper;
import org.inh3rit.financial.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Set;

@Component
public class SecurityBaseSpider {

    @Autowired
    private SecurityMapper securityMapper;

    private final String securityUri = "http://datacenter.eastmoney.com/api/data/get?type=RPT_LICO_FN_CPD&sty=ALL&ps=50&st=UPDATE_DATE,SECURITY_CODE&sr=-1,-1&var=kKfLaQNc&filter=(REPORTDATE=%272020-06-30%27)&rt=53304070&p=";

    public void fetchSecurityInfo() throws IOException, InterruptedException {
        Set<String> codeSet = securityMapper.selectAllSecurityCode();
        for (int i = 1; i < 2; i++) {
            HttpResponse httpResponse = HttpUtils.get(securityUri + i);
            System.out.println(httpResponse.body());
        }
    }
}
