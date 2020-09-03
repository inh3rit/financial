package org.inh3rit.financial.service;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.inh3rit.financial.kits.EsUtils;
import org.inh3rit.financial.BaseTest;
import org.inh3rit.financial.kits.EsClient;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 14:22 2019-09-17
 */
public class DemoServiceTest extends BaseTest {

    @Test
    public void testIndex() throws IOException {
        RestHighLevelClient client = EsClient.getInstance();
        IndexRequest indexRequest = new IndexRequest("tsindex")
                .id("2")
                .source("id", "id_1",
                        "content", "content_1")
                .opType(DocWriteRequest.OpType.CREATE);
        try {
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse);
        } catch (ElasticsearchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScrollSearch() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(matchAllQuery());
        List<SearchHit> searchHits = EsUtils.scrollSearch(searchSourceBuilder, "tsindex");
        System.out.println(searchHits);
    }
}
