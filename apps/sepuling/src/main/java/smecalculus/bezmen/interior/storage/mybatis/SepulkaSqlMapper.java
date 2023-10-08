package smecalculus.bezmen.interior.storage.mybatis;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import smecalculus.bezmen.interior.storage.SepulkaRec;

public interface SepulkaSqlMapper {

    @Insert("INSERT INTO sepulkas (id, version, name) VALUES (#{id}, #{version}, #{name})")
    void insert(SepulkaRec sepulkaRec);

    @Select("SELECT id, version, name FROM sepulkas WHERE id = #{id}")
    Optional<SepulkaRec> findById(@Param("id") String id);

    @Select("SELECT * FROM sepulkas")
    List<SepulkaRec> selectAll();
}