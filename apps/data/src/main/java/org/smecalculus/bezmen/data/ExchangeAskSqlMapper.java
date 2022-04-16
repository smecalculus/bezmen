package org.smecalculus.bezmen.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.smecalculus.bezmen.core.ExchangeAsk;
import org.smecalculus.bezmen.core.ExchangeAskDao;

import java.util.List;

@Mapper
public interface ExchangeAskSqlMapper extends ExchangeAskDao {

    @Override
    @Select("SELECT * FROM asks WHERE offset = #{offset}")
    List<ExchangeAsk> getByOffset(@Param("offset") Long offset);
}
