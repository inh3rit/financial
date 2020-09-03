package org.inh3rit.financial.service;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.inh3rit.financial.dao.DemoDao;
import org.inh3rit.financial.kits.EsClient;
import org.inh3rit.financial.model.ESModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

//import org.inh3rit.spring.boot.demo.dao.elastic.ESModelDao;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 14:21 2019-09-17
 */
@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public void delById(String id) {
        demoDao.delById(id);
    }

    public void index(ESModel esModel) throws IOException {
        RestHighLevelClient client = EsClient.getInstance();
        IndexRequest indexRequest = new IndexRequest("tsindex")
                .id("2")
                .source(JSON.toJSONString(esModel))
                .opType(DocWriteRequest.OpType.CREATE);
        try {
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse);
        } catch (ElasticsearchException e) {
            e.printStackTrace();
        }
    }
}
