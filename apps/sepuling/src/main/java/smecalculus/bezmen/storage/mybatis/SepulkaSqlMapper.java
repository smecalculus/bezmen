package smecalculus.bezmen.storage.mybatis;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import smecalculus.bezmen.storage.SepulkaEdge;

public interface SepulkaSqlMapper {

    @Insert("INSERT INTO sepulkas (id, version, name) VALUES (#{id}, #{version}, #{name})")
    void insert(SepulkaEdge sepulkaEdge);

    @Select("SELECT id, version, name FROM sepulkas WHERE id = #{id}")
    Optional<SepulkaEdge> findById(@Param("id") String id);

    @Select("SELECT * FROM sepulkas")
    List<SepulkaEdge> selectAll();
}
