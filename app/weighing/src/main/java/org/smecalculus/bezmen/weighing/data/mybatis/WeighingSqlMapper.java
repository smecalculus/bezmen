package org.smecalculus.bezmen.weighing.data.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.smecalculus.bezmen.weighing.data.WeighingDm;

import java.util.Optional;

public interface WeighingSqlMapper {

    @Insert("INSERT INTO weighings (ID, VERSION) VALUES (#{id}, #{version})")
    void insert(WeighingDm weighingDm);

    @Select("SELECT ID, VERSION FROM weighings WHERE ID = #{id}")
    Optional<WeighingDm> findById(@Param("id") String id);
}