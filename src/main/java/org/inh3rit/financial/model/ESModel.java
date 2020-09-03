package org.inh3rit.financial.model;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 15:05 2019-09-18
 */
//@Document(indexName = "#{customConfiguration.indexName}", type = "_doc")
public class ESModel implements Serializable {

//    @Id
    private String id;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
