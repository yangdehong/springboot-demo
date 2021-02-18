package com.ydh.redsheep.zes;

import com.ydh.redsheep.zes.es.PositionEsRepository;
import com.ydh.redsheep.zes.pojo.Position;
import com.ydh.redsheep.zes.repository.PositionRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ZEsApplicationTests {

    @Resource
    private PositionRepository positionRepository;
    @Resource
    private PositionEsRepository positionEsRepository;
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void contextLoads() {
        // TODO 正常的同步数据要走分页或者流式，这里数据量比较少的测试，直接全部查询出来
        List<Position> positionList = positionRepository.findAll();

        positionEsRepository.saveAll(positionList);

    }

    @Test
    void search() {
//        String positionName = "java工程师";
        String positionName = "java";
        Integer pageNum = 1;
        Integer pageSize = 5;
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.matchQuery("positionName", positionName));
        queryBuilder.withPageable(PageRequest.of(pageNum-1, pageSize));
        SearchHits<Position> search = elasticsearchRestTemplate.search(queryBuilder.build(), Position.class);
        List<SearchHit<Position>> searchHits = search.getSearchHits();
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < searchHits.size(); i++) {
            SearchHit<Position> searchHit = searchHits.get(i);
            Position content = searchHit.getContent();
            System.out.println("获取到第"+i+"个数据="+content);
            ids.add(content.getId());
        }
        // 如果不到5个，再次search
        int size = searchHits.size();
        if (size<5) {
            String positionAdvantage = "美女多、员工福利好";
            NativeSearchQueryBuilder queryBuilder2 = new NativeSearchQueryBuilder();
            BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
            boolQueryBuilder.filter(QueryBuilders.matchQuery("positionAdvantage", positionAdvantage))
                    .mustNot(QueryBuilders.termsQuery("id", ids));
            queryBuilder2.withQuery(boolQueryBuilder);
            queryBuilder2.withPageable(PageRequest.of(0, 5-size));
            SearchHits<Position> search2 = elasticsearchRestTemplate.search(queryBuilder2.build(), Position.class);
            List<SearchHit<Position>> searchHits2 = search2.getSearchHits();
            for (int i = 0; i < searchHits2.size(); i++) {
                SearchHit<Position> searchHit = searchHits2.get(i);
                Position content = searchHit.getContent();
                System.out.println("二次查询获取到第"+i+"个数据="+content);
            }
        }

    }

}
