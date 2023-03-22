package org.smecalculus.bezmen.data.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.smecalculus.bezmen.data.SepulkaRec;

import java.util.Optional;

public interface SepulkaSqlMapper {

    @Insert("INSERT INTO sepulkas (ID, VERSION) VALUES (#{id}, #{version})")
    void insert(SepulkaRec sepulkaRec);

    @Select("SELECT ID, VERSION FROM sepulkas WHERE ID = #{id}")
    Optional<SepulkaRec> findById(@Param("id") String id);
}