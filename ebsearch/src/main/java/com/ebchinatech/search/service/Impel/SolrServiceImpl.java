package com.ebchinatech.search.service.Impel;



import java.util.List;
import java.util.Map;

import com.ebchinatech.search.model.Mayday;
import com.ebchinatech.search.service.MaydayService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.ebchinatech.search.model.Solr;

import org.springframework.stereotype.Service;

@Service("SolrService")


public class SolrServiceImpl implements MaydayService {

//     定义http的solr服务
    private HttpSolrServer httpSolrServer = HttpSolrServerSington.getServer();

    public void add(Solr solr) throws Exception {
        httpSolrServer.addBean(solr); //添加数据到solr服务器
        httpSolrServer.commit(); //提交
    }

    public void delete(List<String> ids) throws Exception {
        this.httpSolrServer.deleteById(ids);
        this.httpSolrServer.commit(); //提交
    }

    public List<Solr> search(String keywords, Integer page, Integer rows) throws Exception {
        SolrQuery solrQuery = new SolrQuery(); //构造搜索条件
        solrQuery.setQuery("title:" + keywords); //搜索关键词
        // 设置分页 start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
        solrQuery.setStart((Math.max(page, 1) - 1) * rows);
        solrQuery.setRows(rows);

        //是否需要高亮
        boolean isHighlighting = !StringUtils.equals("*", keywords) && StringUtils.isNotEmpty(keywords);

        if (isHighlighting) {
            // 设置高亮
            solrQuery.setHighlight(true); // 开启高亮组件
            solrQuery.addHighlightField("title");// 高亮字段
            solrQuery.setHighlightSimplePre("<em>");// 标记，高亮关键字前缀
            solrQuery.setHighlightSimplePost("</em>");// 后缀
        }

        // 执行查询
        QueryResponse queryResponse = this.httpSolrServer.query(solrQuery);
        List<Solr> solrs = queryResponse.getBeans(Solr.class);
        if (isHighlighting) {
            // 将高亮的标题数据写回到数据对象中
            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
                for (Solr solr : solrs) {
                    if (!highlighting.getKey().equals(solr.getId().toString())) {
                        continue;
                    }
                    solr.setTitle(StringUtils.join(highlighting.getValue().get("title"), ""));
                    break;
                }
            }
        }

        return solrs;
    }

    @Override
    public void create(String Title, Integer title) {

    }

    @Override
    public void deleteByTitle(String title) {

    }

    @Override
    public List<Mayday> search(String search, int page) {
        return null;
    }

    @Override
    public int totalPages(String totalpages) {
        return 0;
    }
}
